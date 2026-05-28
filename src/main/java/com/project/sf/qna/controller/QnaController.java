package com.project.sf.qna.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.project.sf.qna.QuestionPost;
import com.project.sf.qna.service.QnaService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/qna")
public class QnaController {

  @Autowired
  QnaService qnaService;

  @GetMapping("")
  String main(Model model) {

    List<QuestionPost> questionPosts = qnaService.loadQnaPosts();

    model.addAttribute("questionPosts", questionPosts);

    return "pages/qna/list";
  }

  // 게시글 작성 페이지 이동
  @GetMapping("/write")
  String writePost() {
    return "pages/qna/write";
  }

  // 게시글 상세 정보 조회
  @GetMapping("/detail/{no}")
  String detail(@PathVariable Long no, Model model) {

    QuestionPost detailPost = qnaService.loadQnaPostDetailByNo(no);

    model.addAttribute("detail", detailPost);

    return "pages/qna/detail";
  }

  // 게시글 작성자인지 판별
  @PostMapping("/verify")
  @ResponseBody
  boolean verifyWriterByPassword(@RequestParam Long no, @RequestParam String postPw,
      HttpSession session) {

    boolean isMatch = qnaService.checkPassword(no, postPw);

    if (isMatch) {
      session.setAttribute("validatedPostNo", no);
    }

    return isMatch;
  }

  // 게시글 수정 페이지 이동
  @GetMapping("/edit/{no}")
  String editPost() {
    return "pages/qna/edit";
  }

  @GetMapping("/delete/{no}")
  String deletePost() {
    return "redirect:../../qna";
  }

}
