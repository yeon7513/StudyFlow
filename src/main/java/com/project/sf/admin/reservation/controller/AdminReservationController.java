package com.project.sf.admin.reservation.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.project.sf.common.pager.Pager;
import com.project.sf.reservation.Reservation;
import com.project.sf.reservation.service.ReservationService;

@Controller
@RequestMapping("/admin/management/reservation")
public class AdminReservationController {

  @Autowired
  ReservationService reservationService;

  // 예약자 관리
  @GetMapping("/list")
  String main(Model model, Pager pager) {

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
  @GetMapping("/detail/{no}")
  ResponseEntity<?> findReservationDetailByEmail(@PathVariable Long no) {

    Reservation reservation = reservationService.findReservationDetailByEmail(no);


    if (reservation == null) {
      return ResponseEntity.badRequest().body("사용자의 예약 정보를 찾을 수 없습니다.");
    }

    // 비밀번호 제외
    reservation.setPassword(null);

    return ResponseEntity.ok(reservation);
  }
}
