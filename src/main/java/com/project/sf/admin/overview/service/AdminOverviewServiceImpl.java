package com.project.sf.admin.overview.service;

import com.project.sf.admin.overview.dao.AdminOverviewDao;
import com.project.sf.admin.overview.model.OverviewChart;
import com.project.sf.admin.overview.model.OverviewWidget;
import com.project.sf.common.enums.inquiry.InquiryCategoryEnum;
import com.project.sf.common.enums.reservation.InflowEnum;
import com.project.sf.common.enums.reservation.RegionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminOverviewServiceImpl implements AdminOverviewService {

  @Autowired
  AdminOverviewDao adminOverviewDao;

  @Override
  public OverviewWidget loadOverviewWidgetData() {
    OverviewWidget widget = new OverviewWidget();

    // 1위 키워드 & 선택 수를 Map으로 조립
    Map<String, Object> topKeywordMap = adminOverviewDao.findTopKeyword();

    if (topKeywordMap != null) {
      String topKeyword = (String) topKeywordMap.get("keyword");
      int topKeywordCount = ((Number) topKeywordMap.get("count")).intValue();

      widget.setTopKeyword(topKeyword);
      widget.setTopKeywordCount(topKeywordCount);
    }

    int newReserve = adminOverviewDao.countNewReserve();
    int totalReserve = adminOverviewDao.countTotalReserve();
    int waitingInquiry = adminOverviewDao.countWaitingInquiry();

    widget.setNewReserve(newReserve);
    widget.setTotalReserve(totalReserve);
    widget.setWaitingInquiry(waitingInquiry);

    return widget;
  }

  // 차트 데이터를 하나로 묶어서 반환
  @Override
  public Map<String, OverviewChart> loadAllChartDatas() {
    Map<String, OverviewChart> charts = new HashMap<>();

    charts.put("newReserveData", loadNewReserveChartData(7));
    charts.put("selectedKeywordData", loadSelectedKeywordChartData());
    charts.put("inflowData", loadInflowChartData());
    charts.put("regionData", loadRegionChartData());
    charts.put("inquiryCategoryData", loadInquiryCategoryChartData());

    return charts;
  }

  // 날짜별 신규 사용자
  // 비동기 통신으로 날짜별로 다시 차트를 재렌더링
  @Override
  public OverviewChart loadNewReserveChartData(int range) {
    OverviewChart newReserveChart = new OverviewChart();

    // [{"label": "String", "value": Integer}, { ... }] => Object로 가져옴
    List<Map<String, Object>> chartDatas = adminOverviewDao.loadNewReserveChartData(range);

    // 없는 날짜에도 값(0)을 넣기 위해 임시로 변수에 담아둠.
    Map<String, Integer> tempMap = new HashMap<>();
    for (Map<String, Object> data : chartDatas) {
      tempMap.put((String) data.get("label"),
        ((Number) data.get("value")).intValue());
    }

    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M월 d일");

    // Chart.js에서 쓰기 좋게 key와 value를 분리하기
    // -> { labels: [ ... ], values: [ ... ] }
    for (int i = range - 1; i >= 0; i--) {
      String label = today.minusDays(i).format(formatter);
      // 값이 있으면 그대로, 없으면 0으로
      int value = tempMap.getOrDefault(label, 0);

      newReserveChart.addData(label, value);
    }

    return newReserveChart;
  }

  // 서비스 내부에만 존재하는 차트 데이터를 불러오는 메소드들
  // 컨트롤러에서 직접적으로 접근하지 않으니 private로 선언

  // 선택된 관심 분야
  private OverviewChart loadSelectedKeywordChartData() {
    OverviewChart selectedKeywordChart = new OverviewChart();

    List<Map<String, Object>> chartDatas = adminOverviewDao.loadSelectedKeywordChartData();

    for (Map<String, Object> data : chartDatas) {
      String label = (String) data.get("label");
      int value = ((Number) data.get("value")).intValue();

      selectedKeywordChart.addData(label, value);
    }

    return selectedKeywordChart;
  }

  // 유입경로
  private OverviewChart loadInflowChartData() {
    OverviewChart inflowChart = new OverviewChart();

    List<Map<String, Object>> chartDatas = adminOverviewDao.loadInflowChartData();

    for (Map<String, Object> data : chartDatas) {
      String label = (String) data.get("label");
      int value = ((Number) data.get("value")).intValue();

      // label을 한글로
      String koreanLabel = InflowEnum.changeValueToLabel(label);

      inflowChart.addData(koreanLabel, value);
    }

    return inflowChart;
  }

  // 지역
  private OverviewChart loadRegionChartData() {
    OverviewChart regionChart = new OverviewChart();

    List<Map<String, Object>> chartDatas = adminOverviewDao.loadRegionChartData();

    for (Map<String, Object> data : chartDatas) {
      String label = (String) data.get("label");
      int value = ((Number) data.get("value")).intValue();

      String koreanLabel = RegionEnum.changeValueToLabel(label);

      regionChart.addData(koreanLabel, value);
    }

    return regionChart;
  }

  // 문의글 카테고리
  private OverviewChart loadInquiryCategoryChartData() {
    OverviewChart inquiryCategoryChart = new OverviewChart();

    List<Map<String, Object>> chartDatas = adminOverviewDao.loadInquiryCategoryChartData();

    for (Map<String, Object> data : chartDatas) {
      String label = (String) data.get("label");
      int value = ((Number) data.get("value")).intValue();

      String koreanLabel = InquiryCategoryEnum.changeValueToLabel(label);

      inquiryCategoryChart.addData(koreanLabel, value);
    }

    return inquiryCategoryChart;
  }


}
