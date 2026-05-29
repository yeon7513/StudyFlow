// 작성 취소 버튼 핸들러
const cancelButton = document.getElementById("cancel-button");
const handleCancelEdit = () => {
  if (
    confirm("작성을 취소하시겠습니까? 취소 시 작성한 내용은 저장되지 않습니다.")
  ) {
    history.back();
  }
};
cancelButton.addEventListener("click", handleCancelEdit);
