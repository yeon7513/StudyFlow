package com.project.sf.preorder.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.sf.preorder.Reservation;
import com.project.sf.preorder.service.PreorderService;
import com.project.sf.trend.Category;
import com.project.sf.trend.service.TrendService;
import jakarta.servlet.http.HttpServletRequest;

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

  @PostMapping("/reserve")
  String reserve(Reservation reservation, HttpServletRequest request, Model model) {
    // 사용자 IP 추출
    String ip = request.getRemoteAddr();
    reservation.setUserIp(ip);

    preorderService.registerReserve(reservation);

    String email = reservation.getEmail();

    Reservation completedReservation = preorderService.findReservationDetail(email, ip);

    model.addAttribute("reservation", completedReservation);

    return "pages/preorder/reserve_completed";
  }

  @GetMapping("/search/{email}")
  String searchReserved(@PathVariable String email, Model model) {
    return "preorder/search";
  }

}
