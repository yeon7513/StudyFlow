// 키워드 상세 정보 조회 (프래그먼트를 받아와 화면에 렌더링)
const handleLoadKeywordDetail = (targetNo, renderBox) => {
  fetch(`/admin/management/interest/keyword/detail/${targetNo}`)
  .then((res) => res.text())
  .then((result) => {
    renderBox.innerHTML = result;
  })
  .catch((err) => {
    console.log("서버 통신 에러", err);
    renderBox.innerHTML = `<p class="error-message">데이터를 불러오지 못했습니다.</p>`;
  });
};


// 키워드 수정 모드 전환 (수정용 프래그먼트를 받아와 전환)
const handleLoadKeywordModify = (targetNo, renderBox) => {
  fetch(`/admin/management/interest/keyword/modify/${targetNo}`)
  .then((res) => res.text())
  .then((result) => {
    renderBox.innerHTML = result;
  })
  .catch((err) => console.log(err));
};


export {handleLoadKeywordDetail, handleLoadKeywordModify};
