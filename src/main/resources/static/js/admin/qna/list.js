// 상세 조회용 핸들러
const handleRenderDetail = (data) => {};

// ---------------------------------------------------------------------

// 상세 데이터 불러오기
const loadDetailButtons = document.querySelectorAll(".load-detail-btn");

const handleLoadDetail = (postNo) => {
  fetch(`/admin/management/qna/detail/${postNo}`)
    .then((res) => res.json())
    .then((result) => handleRenderDetail(result))
    .catch((err) => console.log(err));
};

loadDetailButtons.forEach((button) => {
  const postNo = button.dataset.postNo;

  button.addEventListener("click", () => handleLoadDetail(postNo));
});
