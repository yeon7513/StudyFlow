package com.project.sf.qna.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.sf.qna.QuestionPost;
import com.project.sf.qna.service.QnaService;

@Controller
@RequestMapping("/qna")
public class QnaController {

  @Autowired
  QnaService qnaService;

  @GetMapping("")
  String main(Model model) {

    List<QuestionPost> questionPosts = qnaService.findQnaPosts();

    model.addAttribute("questionPosts", questionPosts);

    return "pages/qna/list";
  }

  @GetMapping("/detail/{no}")
  String detail(@PathVariable Long no, Model model) {

    QuestionPost detailPost = qnaService.findQnaPostDetailByNo(no);

    model.addAttribute("detail", detailPost);

    return "pages/qna/detail";
  }

  @GetMapping("/write")
  String writePost() {
    return "pages/qna/write";
  }



}
