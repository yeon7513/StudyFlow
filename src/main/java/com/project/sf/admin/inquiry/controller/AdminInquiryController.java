package com.project.sf.admin.inquiry.controller;

import com.project.sf.admin.auth.model.Admin;
import com.project.sf.common.filter.admin.AdminInquirySearchFilter;
import com.project.sf.common.pager.AdminInquiryPostSearch;
import com.project.sf.inquiry.AnswerPost;
import com.project.sf.inquiry.QuestionPost;
import com.project.sf.inquiry.service.AnswerPostService;
import com.project.sf.inquiry.service.QuestionPostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/management/inquiry")
public class AdminInquiryController {

  @Autowired
  QuestionPostService questionPostService;

  @Autowired
  AnswerPostService answerPostService;

  // 문의 관리
  @GetMapping("/list")
  String list(Model model, AdminInquiryPostSearch adminInquiryPostSearch) {

    // 보여질 개수 설정
    adminInquiryPostSearch.setPerPage(10);

    // 최초 접근 시 기본값을 '미답변'으로 설정
    if (adminInquiryPostSearch.getAnswerState() == null) {
      adminInquiryPostSearch.setAnswerState("waiting");
    }

    List<QuestionPost> questionPosts = answerPostService.loadAllPosts(adminInquiryPostSearch);

    model.addAttribute("questionPosts", questionPosts);
    model.addAttribute("pager", adminInquiryPostSearch);

    // 최초 접근 시 우측 상세 정보쪽에 초기 문의글 설정
    QuestionPost initPost = answerPostService.loadOldestNoAnswerPost(adminInquiryPostSearch);

    model.addAttribute("inquiryDetail", initPost);

    // 검색용 필터 추가
    model.addAttribute("searchOptions", new AdminInquirySearchFilter());

    return "pages/admin/management/inquiry/list";
  }

  // 문의글 상세 조회
  @GetMapping("/detail/{no}")
  String detail(@PathVariable Long no, Model model) {

    QuestionPost inquiryDetail = questionPostService.loadQnaPostDetailByNo(no);

    if (inquiryDetail != null) {
      // 비밀번호 제외
      inquiryDetail.setPostPw(null);
    }

    model.addAttribute("inquiryDetail", inquiryDetail);

    // 타임리프 Fragment + AJAX
    // 데이터를 JSON으로 넘기지 않고, 특정 프래그먼트로만 데이터를 넘겨줌
    // -> Javascript로 DOM 조작 없이 간단하게 렌더링이 가능!!

    // 참고
    // https://romanc3.tistory.com/81
    // https://chaelin1211.github.io/study/2021/04/14/thymeleaf-ajax.html
    // https://joyhong.tistory.com/104

    // 프래그먼트를 반환하는 것도 가능!!
    // 타임리프가 SSR라서 가능한듯함.

    return "layout/admin/fragments/inquiry/inquiry_detail :: InquiryDetail";
  }


  // 답변 등록
  @ResponseBody
  @PostMapping("/register_reply/{postNo}")
  boolean registerReply(@PathVariable Long postNo, HttpSession session, AnswerPost answerPost) {

    Admin admin = (Admin) session.getAttribute("logined_admin");

    if (admin != null) {
      answerPost.setPostNo(postNo);
      answerPost.setAdminId(admin.getId());

      answerPostService.registerAnswerPost(answerPost);

      return true;
    }

    return false;
  }
}
