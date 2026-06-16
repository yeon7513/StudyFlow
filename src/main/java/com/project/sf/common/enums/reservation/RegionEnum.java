package com.project.sf.common.enums.reservation;

// Enum은 "Enumeration"의 약자
// Enumeration은 "열거, 목록, 일람표"라는 뜻을 가지고 있으며,
// 보통 한글로는 "열거형"이라고 부른다.
// 즉, 열거형(enum)은 요소, 멤버라 불리는 명명된 값의 집합을 이루는 자료형이다.
// -> 서로 관련있는 상수들끼리 모아 상수들을 대표할 수 있는 이름으로 타입을 정의하는 것
// -> 간단하게 생각하면 "상수 데이터들의 집합"이다.

// '요일'이나 계절' 또는 주사위'같은 예제를 들자면,
// 요일은 [월, 화, 수, 목, 금, 토, 일] 이고,
// 계절은 [봄, 여름, 가을, 겨울]로 한정되어 있으며,
// 주사위는 [1, 2, 3, 4, 5, 6] 으로만 구성되어 있다.
// 이와 같이 정해져 있는 한정된 데이터 묶음을 열거형 타입인 "Enum"으로 묶어주면
// 보다 구조적으로 프로그래밍 할 수 있다.

// 참고:
// https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EC%97%B4%EA%B1%B0%ED%98%95Enum-%ED%83%80%EC%9E%85-%EB%AC%B8%EB%B2%95-%ED%99%9C%EC%9A%A9-%EC%A0%95%EB%A6%AC
// https://limkydev.tistory.com/66
// https://ywoosang.tistory.com/28
public enum RegionEnum {
  SEOUL_INCHEON("서울/인천", "seoul_incheon"),
  GYEONGGI("경기", "gyeonggi"),
  GANGWON("강원", "gangwon"),
  CHUNGBUK("충북", "chungbuk"),
  CHUNGNAM("충남", "chungnam"),
  DAEJEON_SEJONG("대전/세종", "daejeon_sejong"),
  JEONBUK("전북", "jeonbuk"),
  JEONNAM("전남", "jeonnam"),
  GWANGJU("광주", "gwangju"),
  GYEONGBUK("경북", "gyeongbuk"),
  GYEONGNAM("경남", "gyeongnam"),
  DAEGU_BUSAN("대구/부산", "daegu_busan"),
  JEJU("제주", "jeju");

  private final String label;
  private final String value;

  RegionEnum(String label, String value) {
    this.label = label;
    this.value = value;
  }

  public String getLabel() {
    return label;
  }

  public String getValue() {
    return value;
  }
}
