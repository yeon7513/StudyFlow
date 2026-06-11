package com.project.sf.qna.controller;

import com.project.sf.common.pager.Pager;
import com.project.sf.qna.QuestionPost;
import com.project.sf.qna.service.QnaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/qna")
public class QnaController {

  @Autowired
  QnaService qnaService;

  // 전체 리스트 조회
  @GetMapping("")
  String displayQnaPosts(Model model, Pager pager) {

    pager.setPerPage(10);

    List<QuestionPost> questionPosts = qnaService.loadQnaPosts(pager);

    model.addAttribute("questionPosts", questionPosts);

    return "pages/qna/list";
  }

  // 게시글 작성 페이지 이동
  @GetMapping("/write")
  String writePost() {
    return "pages/qna/write";
  }

  @PostMapping("/register")
  String registerPost(HttpServletRequest request, QuestionPost questionPost) {
    String ip = request.getRemoteAddr();
    questionPost.setWriterIp(ip);

    Long newPostNo = qnaService.registerPost(questionPost);

    return "redirect:/qna/detail/" + newPostNo;
  }

  // 게시글 상세 정보 조회
  @GetMapping("/detail/{no}")
  String detail(@PathVariable Long no, Model model) {

    QuestionPost detailPost = qnaService.loadQnaPostDetailByNo(no);

    // 비밀번호 제외
    // detailPost.setPostPw(null);

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
      session.setAttribute("validated_post_no", no);
    }

    return isMatch;
  }

  // 게시글 수정 페이지 이동
  @GetMapping("/modify/{no}")
  String modifyPost(@PathVariable Long no, Model model, HttpSession session) {

    if (session.getAttribute("validated_post_no") == null) {
      return "redirect:/qna/detail/" + no;
    }

    QuestionPost prevPost = qnaService.findQnaPostByNo(no);

    model.addAttribute("prevPost", prevPost);

    return "pages/qna/modify";
  }

  // 수정된 게시글 적용
  @PostMapping("/modify/{no}")
  String modifyPost(@PathVariable Long no, QuestionPost questionPost, HttpSession session) {

    questionPost.setNo(no);

    qnaService.modifyPost(questionPost);

    session.removeAttribute("validated_post_no");

    return "redirect:/qna/detail/" + no;
  }

  // 게시글 삭제
  @GetMapping("/delete/{no}")
  String deletePost(@PathVariable Long no, HttpSession session) {

    qnaService.deletePost(no);

    session.removeAttribute("validated_post_no");

    return "redirect:/qna";
  }

}
