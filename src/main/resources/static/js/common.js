// 각 페이지마다 렌더링 될 때 이벤트 핸들러 적용
document.addEventListener("DOMContentLoaded", () => {
  // 브라우저의 주소(URL 경로)를 가져옴
  const path = window.location.pathname;

  // 사전예약 페이지(/reservation)를 벗어났다면,
  if (!path.includes("/reservation")) {
    // 예약자 정보 세션을 지움
    sessionStorage.removeItem("user-info");
  }
});
