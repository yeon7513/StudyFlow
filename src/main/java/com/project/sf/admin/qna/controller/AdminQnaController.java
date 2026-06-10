package com.project.sf.admin.qna.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.project.sf.admin.Admin;
import com.project.sf.common.pager.AdminQnaPostSearch;
import com.project.sf.qna.AnswerPost;
import com.project.sf.qna.QuestionPost;
import com.project.sf.qna.service.AnswerPostService;
import com.project.sf.qna.service.QnaService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/management/qna")
public class AdminQnaController {

  @Autowired
  QnaService qnaService;

  @Autowired
  AnswerPostService answerPostService;

  // 문의 관리
  @GetMapping("/list")
  String main(Model model, AdminQnaPostSearch adminQnaPostSearch) {

    // 보여질 개수 설정
    adminQnaPostSearch.setPerPage(10);

    // 최초 접근 시 기본값을 '미답변'으로 설정
    if (adminQnaPostSearch.getAnswerState() == null) {
      adminQnaPostSearch.setAnswerState("waiting");
    }

    List<QuestionPost> questionPosts = answerPostService.loadAllPosts(adminQnaPostSearch);

    model.addAttribute("questionPosts", questionPosts);
    model.addAttribute("pager", adminQnaPostSearch);

    // 최초 접근 시 우측 상세 정보쪽에 초기 문의글 설정
    QuestionPost initPost = answerPostService.loadOldestNoAnswerPost();

    model.addAttribute("detailPost", initPost);

    return "pages/admin/management/qna/list";
  }

  // 문의글 상세 조회
  @GetMapping("/detail/{no}")
  String detail(@PathVariable Long no, Model model) {

    QuestionPost detailPost = qnaService.loadQnaPostDetailByNo(no);

    if (detailPost != null) {
      // 비밀번호 제외
      detailPost.setPostPw(null);
    }

    model.addAttribute("detailPost", detailPost);

    // 타임리프 Fragment + AJAX
    // 데이터를 JSON으로 넘기지 않고, 특정 프래그먼트로만 데이터를 넘겨줌
    // -> Javascript로 DOM 조작 없이 간단하게 렌더링이 가능!!

    // 참고
    // https://romanc3.tistory.com/81
    // https://chaelin1211.github.io/study/2021/04/14/thymeleaf-ajax.html
    // https://joyhong.tistory.com/104

    // 프래그먼트를 반환하는 것도 가능!!
    // 타임리프가 SSR라서 가능한듯함.

    return "layout/admin/fragments/qna_detail :: QnaDetail";
  }


  // 답변 등록
  @ResponseBody
  @PostMapping("/register")
  boolean registerAnswerPost(HttpSession session, AnswerPost answerPost) {

    Admin admin = (Admin) session.getAttribute("logined_admin");

    if (admin != null) {
      answerPost.setAdminId(admin.getId());

      answerPostService.registerAnswerPost(answerPost);

      return true;
    }

    return false;
  }
}
