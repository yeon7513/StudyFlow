package com.project.sf.admin.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.project.sf.admin.service.AdminService;
import com.project.sf.common.pager.Pager;
import com.project.sf.qna.service.QnaService;
import com.project.sf.reservation.Reservation;
import com.project.sf.reservation.service.ReservationService;
import com.project.sf.trend.service.TrendService;

@Controller
@RequestMapping("/admin")
public class AdminController {

  @Autowired
  AdminService adminService;

  @Autowired
  ReservationService reservationService;

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
  String managementReservations(Model model, Pager pager) {

    // 예약자 전체 조회
    List<Reservation> reservations = reservationService.loadAllReservations(pager);

    // 비밀번호 제외
    for (Reservation reservation : reservations) {
      reservation.setPassword(null);
    }

    model.addAttribute("reservations", reservations);

    return "pages/admin/management/reservation/list";
  }

  // 예약자 상세 조회
  @ResponseBody
  @GetMapping("/management/reservation/list/{no}")
  ResponseEntity<?> findReservationDetailByEmail(@PathVariable Long no) {

    Reservation reservation = reservationService.findReservationDetailByEmail(no);


    if (reservation == null) {
      return ResponseEntity.badRequest().body("사용자의 예약 정보를 찾을 수 없습니다.");
    }

    // 비밀번호 제외
    reservation.setPassword(null);

    return ResponseEntity.ok(reservation);
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
