package com.project.sf.reservation.controller;

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
import com.project.sf.reservation.Reservation;
import com.project.sf.reservation.SelectedKeyword;
import com.project.sf.reservation.service.ReservationService;
import com.project.sf.trend.Category;
import com.project.sf.trend.service.TrendService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

  @Autowired
  TrendService trendService;

  @Autowired
  ReservationService reservationService;


  @GetMapping("")
  String reservationMain() {
    return "pages/reservation/main";
  }

  // 키워드 선택 페이지 렌더링
  @GetMapping("/select_keywords")
  String selectKeywords(Model model) {
    List<Category> keywords = trendService.loadKeywords();

    model.addAttribute("keywords", keywords);

    return "pages/reservation/select_keywords";
  }

  // 사전 예약 페이지 렌더링
  @GetMapping("/reserve")
  String reserve() {
    return "pages/reservation/reserve";
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

      Long newRsvNo = reservationService.registerReserve(reservation);

      String email = reservation.getEmail();
      String password = reservation.getPassword();

      List<SelectedKeyword> selectedKeywords = reservation.getSelectedKeywords();

      reservationService.registerSelectedKeywords(newRsvNo, selectedKeywords);

      // HttpSession을 사용하는 이유!!
      // -> @SessionAttribute보다 유연함 (덜 깐깐함..)
      session.setAttribute("email", email);
      session.setAttribute("password", password);
      session.setAttribute("selectedKeywords", selectedKeywords);

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
    // if (email == null || password == null) {
    // return "redirect:/";
    // }

    Reservation completedReservation = reservationService.findReservationDetail(email, password);

    model.addAttribute("completedReservation", completedReservation);

    // 임시로 저장한 세션의 내용 삭제
    session.invalidate();

    return "pages/reservation/reserve_completed";
  }


  // 사전 예약 검색 결과
  @PostMapping("/search_result")
  String searchResult(@RequestParam String email, @RequestParam String password, Model model) {

    Reservation result = reservationService.findReservationDetail(email, password);

    model.addAttribute("result", result);

    return "pages/reservation/search_result";
  }

}
