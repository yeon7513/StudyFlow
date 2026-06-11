package com.project.sf.trend.controller;

import com.project.sf.trend.Keyword;
import com.project.sf.trend.service.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/trend")
public class TrendController {

  @Autowired
  TrendService trendService;

  @GetMapping("")
  String displayTrend(Model model) {
    List<Keyword> topKeywords = trendService.findTopKeywords();

    model.addAttribute("topKeywords", topKeywords);

    return "pages/trend/trend";
  }


}
