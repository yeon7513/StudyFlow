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

@Controller
@RequestMapping("/preorder")
public class PreorderController {

  @Autowired
  PreorderService preorderService;

  @GetMapping({"", "/", "/list"})
  String preorder() {
    return "pages/preorder/preorder";
  }

  @GetMapping("/select_keywords")
  String selectKeywords(Model model) {
    List<Category> keywords = preorderService.loadKeywords();

    model.addAttribute("keywords", keywords);

    return "pages/preorder/select_keywords";
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
