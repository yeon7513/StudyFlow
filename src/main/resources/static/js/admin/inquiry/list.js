// 상세 조회용 핸들러
const inquiryDetail = document.getElementById("inquiry-detail");

const handleRenderDetail = (data) => {
  inquiryDetail.innerHTML = data;
};

// ---------------------------------------------------------------------

// 상세 데이터 불러오기
const loadDetailButtons = document.querySelectorAll(".load-detail-btn");

const handleLoadDetail = (postNo) => {
  fetch(`/admin/management/inquiry/detail/${postNo}`)
  .then((res) => res.text())
  .then((result) => handleRenderDetail(result))
  .catch((err) => console.log(err));
};

loadDetailButtons.forEach((button) => {
  const postNo = button.dataset.postNo;

  button.addEventListener("click", () => handleLoadDetail(postNo));
});

// ---------------------------------------------------------------------

// 답변 등록
// 프래그먼트가 재렌더링 될 때마다 이벤트 핸들러가 없어짐..
// 이럴 때 상위 요소에 이벤트를 위임해 해당 요소에 핸들러를 등록함
// -> 이벤트 위임(Event Delegation)

const handleSubmitReply = (e) => {
  const replyRegisterButton = e.target.closest("#reply-register-button");

  if (!replyRegisterButton) {
    return
  }

  const targetNo = replyRegisterButton.dataset.targetNo;
  const answeredText = document.getElementById("answered-text").value;

  if (!answeredText.trim()) {
    alert("답변 내용을 입력해주세요.");
    return;
  }

  if (!confirm("답변을 등록하시겠습니까?")) {
    return;
  }

  const formData = new FormData();
  formData.append("answeredText", answeredText);

  fetch(`/admin/management/inquiry/register_reply/${targetNo}`, {
    method: "POST",
    body: formData,
  })
  .then((res) => res.text())
  .then((result) => {
    console.log("result: ", result);

    if (result === "true") {
      alert("답변이 등록되었습니다.");
      location.reload();
    } else if (result === "false") {
      alert("답변 등록에 실패했습니다.")
    }
  })
  .catch((err) => console.log("서버 통신 에러: ", err));
}

inquiryDetail.addEventListener("click", (e) => handleSubmitReply(e));
