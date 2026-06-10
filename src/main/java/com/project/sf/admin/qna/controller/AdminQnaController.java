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

  // 문의 관리 - 미답변
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

    return "pages/admin/management/qna/list";
  }

  // 문의글 상세 조회
  @ResponseBody
  @GetMapping("/detail/{no}")
  QuestionPost detail(@PathVariable Long no, Model model) {

    QuestionPost detailPost = qnaService.loadQnaPostDetailByNo(no);

    if (detailPost != null) {
      // 비밀번호 제외
      detailPost.setPostPw(null);

      return detailPost;
    }

    return null;
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
