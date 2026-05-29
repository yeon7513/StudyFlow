// 모달 연결
const modal = document.getElementById("modal");
const cancelModalButton = document.getElementById("cancel-modal");

const postNo = document.getElementById("postNo");
const postAction = document.getElementById("postAction");
const title = document.querySelector("#modal .title > h3");

const handleShowModal = (action) => {
  postAction.value = action;

  if (action === "edit") {
    title.textContent = "게시글 수정";
  } else {
    title.textContent = "게시글 삭제";
  }

  // input 초기화
  handleClearError();
  passwordField.value = "";
  passwordField.focus();

  modal.style.display = "block";
};

// 모달 닫기
const handleHideModal = () => {
  modal.style.display = "none";
};

modal.addEventListener("click", handleHideModal);
cancelModalButton.addEventListener("click", handleHideModal);

// -----------------------------------------------------

// 이벤트 버블링 해제
const modalForm = modal.querySelector("form");

modalForm.addEventListener("click", (e) => {
  e.stopPropagation();
});

// -----------------------------------------------------

// input 유효성 검사
const passwordField = modalForm.querySelector("#password");

// 에러 시 스타일 & 메시지 적용
const handleShowError = (message) => {
  passwordField.classList.add("error-password");

  let errorText = document.getElementById("error-message");

  if (!errorText) {
    errorText = document.createElement("p");
    errorText.id = "error-message";
    passwordField.parentNode.insertBefore(errorText, passwordField.nextSibling);
  }

  errorText.textContent = message;
};

// 에러 스타일 & 메시지 삭제
const handleClearError = () => {
  passwordField.classList.remove("error-password");

  const errorText = document.getElementById("error-message");

  if (errorText) {
    errorText.remove();
  }
};

passwordField.addEventListener("input", handleClearError);

// -----------------------------------------------------

// 게시글 수정용 모달
const modifyButton = document.getElementById("modify");

const handleModifyPost = () => {
  handleShowModal("modify");
};

if (modifyButton) {
  modifyButton.addEventListener("click", handleModifyPost);
}

// -----------------------------------------------------

// 게시글 삭제용 모달
const deleteButton = document.getElementById("delete");

const handleDeletePost = () => {
  handleShowModal("delete");
};

deleteButton.addEventListener("click", handleDeletePost);

// -----------------------------------------------------

// 검증 서버 전송
const handleSubmitVerify = (e) => {
  e.preventDefault();

  const form = e.target;

  const no = form.postNo.value;
  const postPw = form.postPw.value.trim();
  const action = form.action.value;

  if (!postPw) {
    handleShowError("비밀번호를 입력해주세요.");
    passwordField.focus();
    return;
  }

  const formData = new FormData();

  formData.append("no", no);
  formData.append("postPw", postPw);

  try {
    fetch("/qna/verify", {
      method: "POST",
      body: formData,
    })
      .then((res) => res.text())
      .then((result) => {
        if (result === "true") {
          // 수정
          if (action === "modify") {
            handleHideModal();
            location.href = `/qna/modify/${no}`;

            // 삭제
          } else if (action === "delete") {
            if (confirm("정말 이 게시글을 삭제하시겠습니까?")) {
              location.href = `/qna/delete/${no}`;
            }
          }
        } else {
          handleShowError("비밀번호가 일치하지 않습니다.");
          passwordField.value = "";
          passwordField.focus();
        }
      });
  } catch (error) {}
};

modalForm.addEventListener("submit", handleSubmitVerify);
