package com.project.sf.trend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trend")
public class TrendController {

  @GetMapping({"", "/", "/list"})
  String trend() {
    return "pages/trend/trend";
  }
}
