// 모달 띄우기 (스프링에 모달에 들어갈 프래그먼트를 요청)
const handleLoadVerifyModalContent = (action, no) => {
  fetch('/inquiry/verify', {
    method: "GET",
  })
  .then((res) => res.text())
  .then((result) => {
    const modalContent = document.getElementById('modal-content');
    modalContent.innerHTML = result;

    const postNo = modalContent.querySelector("#post-no");
    postNo.value = no;

    const postAction = modalContent.querySelector("#post-action");
    postAction.value = action;

    // 모달 열기
    const modalEl = document.getElementById('common-modal');
    const bsModal = bootstrap.Modal.getOrCreateInstance(modalEl);
    bsModal.show();

    // input 초기화 및 포커스
    const postPwInput = modalContent.querySelector("#password");
    postPwInput.value = "";
    postPwInput.focus();
  })
}

const modifyButton = document.getElementById("modify");
const deleteButton = document.getElementById("delete");

modifyButton?.addEventListener("click", () => {
  const postNo = modifyButton.dataset.postNo;
  handleLoadVerifyModalContent("modify", postNo);
});
deleteButton?.addEventListener("click", () => {
  const postNo = deleteButton.dataset.postNo;
  handleLoadVerifyModalContent("delete", postNo);
});

// -----------------------------------------------------

// 비밀번호 불일치 표시
const handleShowError = (inputElement) => {
  inputElement.classList.add("is-invalid");
  inputElement.value = "";
  inputElement.focus();
};

// 에러 초기화
const handleClearError = (inputElement) => {
  inputElement.classList.remove("is-invalid");
};

// -----------------------------------------------------

// 검증 서버 전송
const handleSubmitVerify = (e) => {
  e.preventDefault();

  const form = e.target;

  const no = form.postNo.value;
  const postPw = form.postPw.value.trim();
  const action = form.postAction.value;

  const formData = new FormData();

  formData.append("no", no);
  formData.append("postPw", postPw);

  fetch("/inquiry/verify", {
    method: "POST",
    body: formData,
  })
  .then((res) => res.text())
  .then((result) => {
    if (result === "true") {
      // 부트스트랩 모달 가져오기
      const modalEl = document.getElementById('common-modal');
      const bsModal = bootstrap.Modal.getInstance(modalEl);

      if (bsModal) {
        bsModal.hide();
      }

      // 수정
      if (action === "modify") {
        location.replace(`/inquiry/modify/${no}`);

        // 삭제
      } else if (action === "delete") {
        if (confirm("정말 이 게시글을 삭제하시겠습니까?")) {
          location.replace(`/inquiry/delete/${no}`);
        }
      }
    } else {
      handleShowError(form.postPw);
      form.postPw.addEventListener("input", () => handleClearError(form.postPw));
    }
  });
};

// 모달 안의 내용은 동적으로 생성되기 때문에 이벤트를 위임
document.addEventListener("submit", (e) => {
  if (e.target.id === "password-verify-form") {
    e.preventDefault();
    handleSubmitVerify(e);
  }
});
