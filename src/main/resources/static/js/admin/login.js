const loginForm = document.getElementById("login-form");

const handleSubmitLogin = (e) => {
  e.preventDefault();

  const id = loginForm.id.value;
  const pw = loginForm.pw.value;

  const formData = new FormData();

  formData.append("id", id);
  formData.append("pw", pw);

  fetch("/admin/auth/login", {
    method: "POST",
    body: formData,
  })
  .then((res) => res.text())
  .then((result) => {
    console.log(result);
    if (result === "true") {
      location.href = "/admin_dashboard";
    } else {
      alert("아이디와 비밀번호가 일치하지 않습니다.");

    }
  })
  .catch((err) => alert("서버와의 통신이 실패했습니다."));
};

loginForm.addEventListener("submit", (e) => handleSubmitLogin(e));
