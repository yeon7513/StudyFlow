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

// -----------------------------------------------------------
// 뒤로가기 방지
// 나중에 소스코드 분석해볼 것..
window.addEventListener("pageshow", function (event) {
  let isBack = false;
  if (event.persisted) {
    isBack = true;
  } else if (window.performance) {
    const navEntries = window.performance.getEntriesByType("navigation");
    if (navEntries.length > 0 && navEntries[0].type === "back_forward") {
      isBack = true;
    } else if (
      window.performance.navigation &&
      window.performance.navigation.type === 2
    ) {
      isBack = true;
    }
  }

  if (isBack) {
    location.replace("/inquiry");
  }
});
