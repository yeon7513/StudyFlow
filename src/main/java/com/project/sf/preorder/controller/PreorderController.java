package com.project.sf.preorder.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.project.sf.preorder.Reservation;
import com.project.sf.preorder.service.PreorderService;
import com.project.sf.trend.Category;
import com.project.sf.trend.service.TrendService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/preorder")
public class PreorderController {

  @Autowired
  TrendService trendService;

  @Autowired
  PreorderService preorderService;


  @GetMapping({"", "/", "/list"})
  String preorder() {
    return "pages/preorder/preorder";
  }

  // 키워드 선택
  @GetMapping("/select_keywords")
  String reserve(Model model) {
    List<Category> keywords = trendService.loadKeywords();

    model.addAttribute("keywords", keywords);

    return "pages/preorder/select_keywords";
  }

  @GetMapping("/reserve")
  String reserve() {
    return "pages/preorder/reserve";
  }

  // 사전 예약 등록
  @ResponseBody
  @PostMapping("/reserve")
  boolean reserve(@RequestBody Reservation reservation, HttpServletRequest request,
      HttpSession session) {
    try {
      // 사용자 IP 추출
      String ip = request.getRemoteAddr();
      reservation.setUserIp(ip);

      preorderService.registerReserve(reservation);

      String email = reservation.getEmail();
      String password = reservation.getPassword();

      // HttpSession을 사용하는 이유!!
      // -> @SessionAttribute보다 유연함 (덜 깐깐함..)
      session.setAttribute("email", email);
      session.setAttribute("password", password);

      return true;

    } catch (Exception e) {
      return false;
    }
  }

  // 사전 예약 완료 시
  @GetMapping("/reserve_completed")
  String reserveCompleted(HttpSession session, Model model) {
    String email = (String) session.getAttribute("email");
    String password = (String) session.getAttribute("password");

    // 세션에 저장된 내용이 없을 경우 메인으로 이동
    if (email == null || password == null) {
      return "redirect:/";
    }

    Reservation completedReservation = preorderService.findReservationDetail(email, password);

    model.addAttribute("completedReservation", completedReservation);

    // 임시로 저장한 세션의 내용 삭제
    session.removeAttribute("email");
    session.removeAttribute("password");

    return "pages/preorder/reserve_completed";
  }

  // 사전 예약 검색 결과
  @PostMapping("/search_result")
  String searchReserved(@RequestParam String email, @RequestParam String password, Model model) {

    Reservation result = preorderService.findReservationDetail(email, password);

    model.addAttribute("result", result);

    return "pages/preorder/search_result";
  }

}
