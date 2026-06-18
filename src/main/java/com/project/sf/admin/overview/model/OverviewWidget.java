package com.project.sf.admin.overview.model;

public class OverviewWidget {
  int newReserve; // 신규 예약자 수
  int totalReserve; // 누적 예약자 수
  String topKeyword; // 누적 1위 관심 분야 키워드
  int topKeywordCount; // 누적 1위 관심 분야 선택 수
  int waitingInquiry; // 답변 대기 중인 문의글 수

  // Map 타입으로 지정하지 않고 필드를 따로 둔 이유

  // 참고
  // https://mangkyu.tistory.com/164

  // [참고 사이트의 마지막 댓글]
  // Map을 사용하더라도 Map<String, Object> 같이 무식하게 모든 타입을 받는경우,
  // 서비스레이어에서 당장은 내가 만들었으니까 어떤 타입이 들어올지 알겠죠.
  // 하지만 기능추가나 유지보수 하는 입장에서 어떤 타입이 들어왔는지 체크해봐야하고,
  // 심지어 put 연발에 타입을 바꿔버리는 경우도 있다보니 이것때문에 시간낭비하는게 많아지고 있어서
  // 진짜 어쩔수 없이 Map을 쓸꺼면 Map.of() 같이 불변성을 유지하는 타입으로 쓰라고 이야기합니다.
  // 응답 객체로 보낼때는 Map을 사용해도 됩니다.
  // 로직의 가장 마지막이기 때문에 변경될일이 없거든요.

  // 여기서 든 생각.
  // 어차피 이러나 저러나 형변환을 하고 Map을 까대기 해야한다면
  // View에서 하는 것보다 서비스쪽에서 하는게 낫다고 생각함.
  // 지금 형태로는 "컬럼명": "실제값"이 2개지만,
  // "실제값": "누적수" 형태로 가져오면 딱 1줄이다.
  // 근데 key와 value를 전부 풀어헤치는 것보다 value만 가져와서 쓰면 될 것 같다고 생각함.
  // -> 간단하니까!


  // GETTER, SETTER
  public int getNewReserve() {
    return newReserve;
  }

  public void setNewReserve(int newReserve) {
    this.newReserve = newReserve;
  }

  public int getTotalReserve() {
    return totalReserve;
  }

  public void setTotalReserve(int totalReserve) {
    this.totalReserve = totalReserve;
  }

  public String getTopKeyword() {
    return topKeyword;
  }

  public void setTopKeyword(String topKeyword) {
    this.topKeyword = topKeyword;
  }

  public int getTopKeywordCount() {
    return topKeywordCount;
  }

  public void setTopKeywordCount(int topKeywordCount) {
    this.topKeywordCount = topKeywordCount;
  }

  public int getWaitingInquiry() {
    return waitingInquiry;
  }

  public void setWaitingInquiry(int waitingInquiry) {
    this.waitingInquiry = waitingInquiry;
  }
}
