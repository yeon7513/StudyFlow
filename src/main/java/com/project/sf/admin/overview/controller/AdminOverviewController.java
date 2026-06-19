package com.project.sf.admin.overview.controller;

import com.project.sf.admin.overview.model.OverviewChart;
import com.project.sf.admin.overview.model.OverviewWidget;
import com.project.sf.admin.overview.service.AdminOverviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/admin_dashboard")
public class AdminOverviewController {

  @Autowired
  AdminOverviewService adminOverviewService;

  // 초기 화면 (관리자 대시보드 메인)
  @GetMapping("")
  String dashboardMain(Model model) {

    // TODAY 위젯
    OverviewWidget widget = adminOverviewService.loadOverviewWidgetData();
    model.addAttribute("widget", widget);

    // 차트 섹션
    Map<String, OverviewChart> charts = adminOverviewService.loadAllChartDatas();
    model.addAttribute("charts", charts);


    return "pages/admin/overview";
  }

  // 날짜별 신규 예약자
  // 이것만 따로 빼놓은 이유?
  // -> 날짜별로 차트를 재렌더링하기 위해서
  // 이 메소드는 프론트쪽에서 요청을 해야만 작동하는 메소드!!
  @ResponseBody
  @GetMapping("/chart/new_reserve/{range}")
  OverviewChart loadNewReserveChartData(@PathVariable int range) {
    return adminOverviewService.loadNewReserveChartData(range);
  }

}
