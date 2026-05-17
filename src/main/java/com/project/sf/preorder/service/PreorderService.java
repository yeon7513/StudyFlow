package com.project.sf.preorder.service;

import java.util.List;
import com.project.sf.trend.Category;

public interface PreorderService {

  void registerReserve();

  List<Category> loadKeywords();

}
