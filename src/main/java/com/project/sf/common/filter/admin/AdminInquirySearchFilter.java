package com.project.sf.common.filter.admin;

import com.project.sf.common.enums.inquiry.AnswerStateEnum;
import com.project.sf.common.enums.inquiry.InquiryCategoryEnum;
import com.project.sf.common.enums.inquiry.InquirySearchEnum;
import com.project.sf.common.filter.SelectOption;

import java.util.ArrayList;
import java.util.List;

// 문의 관리 검색 필터

public class AdminInquirySearchFilter {

  private final List<SelectOption> answerStates;
  private final List<SelectOption> inquirySearch;
  private final List<SelectOption> categories;

  public AdminInquirySearchFilter() {
    this.answerStates = new ArrayList<>();
    this.categories = new ArrayList<>();
    this.inquirySearch = new ArrayList<>();

    for (AnswerStateEnum answerState : AnswerStateEnum.values()) {
      if (answerState == AnswerStateEnum.WAITING) {
        this.answerStates.add(SelectOption.selected(answerState.getLabel(), answerState.getValue()));
      } else {
        this.answerStates.add(SelectOption.of(answerState.getLabel(), answerState.getValue()));
      }
    }

    for (InquiryCategoryEnum category : InquiryCategoryEnum.values()) {
      this.categories.add(SelectOption.of(category.getLabel(), category.getValue()));
    }

    for (InquirySearchEnum inquirySearch : InquirySearchEnum.values()) {
      this.inquirySearch.add(SelectOption.of(inquirySearch.getLabel(), inquirySearch.getValue()));
    }

  }

  public List<SelectOption> getAnswerStates() {
    return answerStates;
  }

  public List<SelectOption> getCategories() {
    return categories;
  }

  public List<SelectOption> getInquirySearch() {
    return inquirySearch;
  }

}

