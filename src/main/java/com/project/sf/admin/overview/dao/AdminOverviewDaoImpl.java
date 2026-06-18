package com.project.sf.admin.overview.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class AdminOverviewDaoImpl implements AdminOverviewDao {

  @Autowired
  SqlSession sql;

  // 위젯
  @Override
  public int countNewReserve() {
    return sql.selectOne("adminOverview.countNewReserve");
  }

  @Override
  public int countTotalReserve() {
    return sql.selectOne("adminOverview.countTotalReserve");
  }

  @Override
  public Map<String, Object> findTopKeyword() {
    return sql.selectOne("adminOverview.findTopKeyword");
  }

  @Override
  public int countWaitingInquiry() {
    return sql.selectOne("adminOverview.countWaitingInquiry");
  }

  @Override
  public List<Map<String, Object>> loadNewReserveChartData(int range) {
    return sql.selectList("adminChart.loadNewReserveChartData", range);
  }

  @Override
  public List<Map<String, Object>> loadSelectedKeywordChartData() {
    return sql.selectList("adminChart.loadSelectedKeywordChartData");
  }

  @Override
  public List<Map<String, Object>> loadInflowChartData() {
    return sql.selectList("adminChart.loadInflowChartData");
  }

  @Override
  public List<Map<String, Object>> loadRegionChartData() {
    return sql.selectList("adminChart.loadRegionChartData");
  }

  @Override
  public List<Map<String, Object>> loadInquiryCategoryChartData() {
    return sql.selectList("adminChart.loadInquiryCategoryChartData");
  }

  // 차트
}
