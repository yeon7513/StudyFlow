// 사용자가 입력한 정보를 세션이 미리 저장 후 최종 취합 -> DB 전송
const saveButton = document.getElementById("save-user-info");

const saveSelectedKeywords = () => {
  const form = document.getElementById("user-info");

  // 공백 입력 방지
  const email = form.email.value.trim().replace(/\s+/g, "");
  const name = form.name.value.trim().replace(/\s+/g, "");
  const password = form.password.value.trim().replace(/\s+/g, "");
  const phone = form.phone.value.trim().replace(/\s+/g, "");

  // 전체 값이 다 들어왔는지 검증
  if (!email || !name || !password || !phone) {
    alert("모든 항목을 올바르게 입력해주세요. 공백은 포함될 수 없습니다.");
    return;
  }

  // 이메일 정규식
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailRegex.test(email)) {
    alert("올바른 이메일 형식을 입력해주세요.");
    form.email.focus();
    return;
  }

  // 비밀번호 검증
  if (password.length < 4) {
    alert("비밀번호는 최소 4자리 이상이어야 합니다.");
    form.password.focus();
    return;
  }

  // 전화번호 형식 검증
  const phoneRegex = /^010-\d{3,4}-\d{4}$/;
  if (!phoneRegex.test(phone)) {
    alert("전화번호 형식을 확인해주세요. (예: 010-1234-5678)");
    form.phone.focus();
    return;
  }

  const userData = {
    email: email,
    password: password,
    name: name,
    phone: phone,
  };

  // 모든 검증을 통과 후 세션에 입력 정보 저장
  sessionStorage.setItem("user-info", JSON.stringify(userData));
  location.href = "/preorder/select_keywords";
};

saveButton.addEventListener("click", saveSelectedKeywords);
