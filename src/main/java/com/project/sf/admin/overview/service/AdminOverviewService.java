package com.project.sf.admin.overview.service;

import com.project.sf.admin.overview.model.OverviewChart;
import com.project.sf.admin.overview.model.OverviewWidget;

import java.util.Map;

public interface AdminOverviewService {
  OverviewWidget loadOverviewWidgetData();

  Map<String, OverviewChart> loadAllChartDatas();

  OverviewChart loadNewReserveChartData(int range);
}
