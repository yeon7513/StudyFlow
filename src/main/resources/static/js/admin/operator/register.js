// [권한 체크박스의 상태 변화 감지]
document.addEventListener("change", (e) => {
  const target = e.target;

  // 상태가 변한 요소가 "최고 관리자" 체크박스라면,
  if (target.classList.contains("super-check")) {
    // 해당 체크박스가 속한 role-group을 찾기
    const group = target.closest(".role-group");
    // role-group에 속한 하위 권한 체크박스(sub-check) 찾기
    const subCheckboxes = group.querySelectorAll(".sub-check");

    // 최고 관리자 체크 여부에 따라 상태 변경
    subCheckboxes.forEach(checkbox => {
      // 즉, 다른 권한은 모두 disabled
      checkbox.disabled = target.checked;

      // 최고 관리자로 체크 시 sub-check는 모두 체크 해제
      if (target.checked) {
        checkbox.checked = false;
      }
    });
  }

});

// ---------------------------------------------

// 뒤로가기 방지
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
    location.replace("/admin/management/operator/list");
  }
});

// 작성 취소 시 폼 초기화
const cancelButton = document.getElementById("cancel-register");

cancelButton.addEventListener("click", () => {
  const form = cancelButton.closest("form");

  if (confirm("운영자 등록을 취소하시겠습니까? 작성한 내용은 저장되지 않습니다.")) {
    form.reset();
    location.replace("/admin/management/operator/list");
  }
});

// -----------------------------------------------------------

const idInput = document.querySelector('input[name="id"]');
const resultText = document.getElementById('id-check-result');

// 사용 가능 아이디 검증
let isIdChecked = false;

const checkIdButton = document.getElementById("check-id");

const handleCheckId = () => {
  const id = idInput.value.trim();

  if (!id) {
    alert("아이디를 먼저 입력해주세요.");
    document.querySelector('input[name="id"]').focus();
    return;
  }

  resultText.classList.remove('d-none');
  resultText.className = 'form-text mt-1 text-primary';
  resultText.innerText = '확인 중...';

  fetch(`/admin/management/operator/check_id/${id}`)
  .then(res => res.text())
  .then(result => {
    if (result === 'true') {
      resultText.className = 'form-text mt-1 text-success';
      resultText.innerText = '사용 가능한 아이디입니다.';
      isIdChecked = true;
    } else {
      resultText.className = 'form-text mt-1 text-danger';
      resultText.innerText = '이미 사용 중인 아이디입니다.';
      isIdChecked = false;
    }
  })
  .catch(err => {
    console.log(err);
    resultText.className = 'form-text mt-1 text-danger';
    resultText.innerHTML = '서버 통신 중 오류가 발생했습니다.'
    isIdChecked = false;
  })
}

checkIdButton.addEventListener("click", handleCheckId);

// ----------------------------------------------------------
// 아이디 입력창 상태 감지
idInput.addEventListener("input", () => {
  isIdChecked = false;
  resultText.classList.add('d-none');
});

// ----------------------------------------------------------
// 폼 전송 시 아이디 중복 확인 체크
const handleSubmitRegister = () => {
  if (!isIdChecked) {
    alert("아이디 중복 확인을 먼저 완료해주세요.");
    idInput.focus();

    return false;
  }

  return true;
}




