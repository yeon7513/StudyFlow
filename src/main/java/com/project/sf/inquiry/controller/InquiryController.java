package com.project.sf.inquiry.controller;

import com.project.sf.common.pager.Pager;
import com.project.sf.inquiry.QuestionPost;
import com.project.sf.inquiry.service.QuestionPostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

  @Autowired
  QuestionPostService questionPostService;

  // 전체 리스트 조회
  @GetMapping("")
  String inquiryMain(Model model, Pager pager) {

    pager.setPerPage(10);

    List<QuestionPost> questionPosts = questionPostService.loadQnaPosts(pager);

    model.addAttribute("questionPosts", questionPosts);

    return "pages/inquiry/list";
  }

  // 게시글 작성 페이지 이동
  @GetMapping("/write")
  String writePost() {
    return "pages/inquiry/write";
  }

  @PostMapping("/register")
  String registerPost(HttpServletRequest request, QuestionPost questionPost) {
    String ip = request.getRemoteAddr();
    questionPost.setWriterIp(ip);

    Long newPostNo = questionPostService.registerPost(questionPost);

    return "redirect:/inquiry/detail/" + newPostNo;
  }

  // 게시글 상세 정보 조회
  @GetMapping("/detail/{no}")
  String detail(@PathVariable Long no, Model model) {

    QuestionPost detailPost = questionPostService.loadQnaPostDetailByNo(no);

    // 비밀번호 제외
    // detailPost.setPostPw(null);

    model.addAttribute("detail", detailPost);

    return "pages/inquiry/detail";
  }

  // 게시글 작성자인지 판별
  @PostMapping("/verify")
  @ResponseBody
  boolean verifyWriterByPassword(@RequestParam Long no, @RequestParam String postPw,
                                 HttpSession session) {

    boolean isMatch = questionPostService.checkPassword(no, postPw);

    if (isMatch) {
      session.setAttribute("validated_post_no", no);
    }

    return isMatch;
  }

  // 게시글 수정 페이지 이동
  @GetMapping("/modify/{no}")
  String modifyPost(@PathVariable Long no, Model model, HttpSession session) {

    if (session.getAttribute("validated_post_no") == null) {
      return "redirect:/inquiry/detail/" + no;
    }

    QuestionPost prevPost = questionPostService.findQnaPostByNo(no);

    model.addAttribute("prevPost", prevPost);

    return "pages/inquiry/modify";
  }

  // 수정된 게시글 적용
  @PostMapping("/modify/{no}")
  String modifyPost(@PathVariable Long no, QuestionPost questionPost, HttpSession session) {

    questionPost.setNo(no);

    questionPostService.modifyPost(questionPost);

    session.removeAttribute("validated_post_no");

    return "redirect:/inquiry/detail/" + no;
  }

  // 게시글 삭제
  @GetMapping("/delete/{no}")
  String deletePost(@PathVariable Long no, HttpSession session) {

    questionPostService.deletePost(no);

    session.removeAttribute("validated_post_no");

    return "redirect:/inquiry";
  }

}
