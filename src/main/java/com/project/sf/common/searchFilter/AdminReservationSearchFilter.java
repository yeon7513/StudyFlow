package com.project.sf.common.searchFilter;

import java.util.List;

// 검색용 필터 옵션 렌더링 DTO
// 타임리프에서 하드코딩하기에는 HTML이 길어져서 가독성이 떨어짐
// 스프링 쪽에서 필터 옵션을 만들어 타임리프에 렌더링하는 게 깔끔해 보인다.
public class AdminReservationSearchFilter {

  // 예약 상태
  private final List<SearchFilterOption> reserveStates = List.of(
    new SearchFilterOption("예약중", "active", true),
    new SearchFilterOption("예약 취소", "canceled"),
    new SearchFilterOption("전체", "all")
  );

  // 지역
  private final List<SearchFilterOption> regions = List.of(
    new SearchFilterOption("전체", "", true),
    new SearchFilterOption("서울/인천", "서울/인천"),
    new SearchFilterOption("경기", "경기"),
    new SearchFilterOption("강원", "강원"),
    new SearchFilterOption("충북", "충북"),
    new SearchFilterOption("충남", "충남"),
    new SearchFilterOption("대전/세종", "대전/세종"),
    new SearchFilterOption("전북", "전북"),
    new SearchFilterOption("전남", "전남"),
    new SearchFilterOption("광주", "광주"),
    new SearchFilterOption("경북", "경북"),
    new SearchFilterOption("경남", "경남"),
    new SearchFilterOption("대구/부산", "대구/부산"),
    new SearchFilterOption("제주", "제주")
  );

  // 유입경로
  private final List<SearchFilterOption> inflows = List.of(
    new SearchFilterOption("전체", "", true),
    new SearchFilterOption("커뮤니티", "커뮤니티"),
    new SearchFilterOption("페이스북", "페이스북"),
    new SearchFilterOption("인스타그램", "인스타그램"),
    new SearchFilterOption("지인 추천", "지인 추천"),
    new SearchFilterOption("블로그 검색", "블로그 검색"),
    new SearchFilterOption("기타", "기타")
  );

  // 취소 사유
  private final List<SearchFilterOption> canceledReasons = List.of(
    new SearchFilterOption("전체", "", true),
    new SearchFilterOption("단순 변심", "단순 변심"),
    new SearchFilterOption("일정 변경", "일정 변경"),
    new SearchFilterOption("기타", "기타")
  );

  // 상세 검색
  private final List<SearchFilterOption> keywordSearch = List.of(
    new SearchFilterOption("예약 번호", "rsvNo", true),
    new SearchFilterOption("이메일", "email"),
    new SearchFilterOption("예약자명", "name"),
    new SearchFilterOption("아이피", "userIp")
  );

  // getters
  public List<SearchFilterOption> getReserveStates() {
    return reserveStates;
  }

  public List<SearchFilterOption> getRegions() {
    return regions;
  }

  public List<SearchFilterOption> getInflows() {
    return inflows;
  }

  public List<SearchFilterOption> getCanceledReasons() {
    return canceledReasons;
  }

  public List<SearchFilterOption> getKeywordSearch() {
    return keywordSearch;
  }

}
