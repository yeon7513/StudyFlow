package com.project.sf.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.sf.admin.service.AdminService;
import com.project.sf.qna.service.QnaService;
import com.project.sf.reservation.service.ReservationService;
import com.project.sf.trend.service.TrendService;

@Controller
@RequestMapping("/admins")
public class AdminController {

  @Autowired
  AdminService adminService;

  @Autowired
  ReservationService preorderService;

  @Autowired
  TrendService trendService;

  @Autowired
  QnaService qnaService;

  // 초기 화면 (관리자 대시보드 홈)
  @GetMapping("")
  String adminHome() {
    return "pages/admin/home";
  }

  // 운영 현황
  @GetMapping("/operational_status")
  String operationalStatus() {
    return "pages/admin/operational_status/operational_status";
  }

  // 예약자 관리
  @GetMapping("/management/reservation/list")
  String managementReservations(Model model) {

    // Reservation reservations = preorderService.


    return "pages/admin/management/reservation/list";
  }


  // 문의 관리
  @GetMapping("/management/qna/list")
  String managementQnas() {
    return "pages/admin/management/qna/list";
  }


  // 관심 분야 관리
  @GetMapping("/management/interest/list")
  String managementInterests() {
    return "pages/admin/management/interest/list";
  }

  // 블랙리스트 관리
  @GetMapping("/management/blacklist/list")
  String managementBlacklists() {
    return "pages/admin/management/blacklist/list";
  }

  // 운영자 관리 (SUPER만 접근 가능)
  @GetMapping("/management/operator/list")
  String managementOperators() {
    return "pages/admin/management/operator/list";
  }

}
