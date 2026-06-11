package com.project.sf.common.searchFilter;

import java.util.List;

// 문의 관리 검색 필터
public class AdminInquirySearchFilter {

  // 답변 상태
  private final List<SearchFilterOption> answerStates = List.of(
    new SearchFilterOption("미답변", "waiting", true),
    new SearchFilterOption("답변완료", "answered"),
    new SearchFilterOption("전체", "all")
  );

  // 상세 검색
  private final List<SearchFilterOption> keywordSearch = List.of(
    new SearchFilterOption("제목+내용", "contents", true),
    new SearchFilterOption("문의글 번호", "postNo"),
    new SearchFilterOption("작성자 아이피", "writerIp")
  );

  // getters
  public List<SearchFilterOption> getAnswerStates() {
    return answerStates;
  }

  public List<SearchFilterOption> getKeywordSearch() {
    return keywordSearch;
  }

}
