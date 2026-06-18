package com.project.sf.admin.overview.dao;

import java.util.List;
import java.util.Map;

public interface AdminOverviewDao {
  int countNewReserve();

  int countTotalReserve();

  Map<String, Object> findTopKeyword();

  int countWaitingInquiry();

  List<Map<String, Object>> loadNewReserveChartData(int range);

  List<Map<String, Object>> loadSelectedKeywordChartData();

  List<Map<String, Object>> loadInflowChartData();

  List<Map<String, Object>> loadRegionChartData();

  List<Map<String, Object>> loadInquiryCategoryChartData();
}
