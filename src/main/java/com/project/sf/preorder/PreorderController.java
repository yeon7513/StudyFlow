package com.project.sf.preorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.sf.preorder.reservation.Reservation;

@Controller
@RequestMapping("/preorder")
public class PreorderController {

  @Autowired
  PreorderService preorderService;

  @GetMapping("/main")
  String preorder() {
    return "pages/preorder/preorder";
  }

  @PostMapping("/reserve")
  String reserve(Reservation reservation, Model model) {
    preorderService.registerReserve();

    model.addAttribute("reservedData", reservation);

    return "redirect:reserved";
  }

  @GetMapping("/search/{email}")
  String searchReserved(@PathVariable String email, Model model) {
    return "preorder/search";
  }

}
