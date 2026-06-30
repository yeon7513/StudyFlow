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


// 수정 서브밋 핸들러
const handleSubmitModify = (e, targetForm, targetId) => {
  e.preventDefault();

  const isRoleChecked = targetForm.querySelectorAll("input[name='roles']:checked");

  if (isRoleChecked.length === 0) {
    if (!confirm("선택된 권한이 없습니다. 계속 하시겠습니까?")) {
      return;
    }
  }

  const formData = new FormData(targetForm);

  fetch(`/admin/management/operator/modify/${targetId}`, {
    method: "POST",
    body: formData,
  })
  .then(res => res.json())
  .then(result => {
    if (result.success) {
      // 클라이언트 업데이트 (목록 리스트 & 수정 폼)
      const item = targetForm.closest(".accordion-item");

      // 수정일 업데이트
      const updatedAtEl = item.querySelector(`.updated_at_${targetId}`);
      updatedAtEl.textContent = result.updatedAt;

      // 체크된 권한들로 뱃지 업데이트
      const rolesEl = item.querySelector(`.roles_${targetId}`);
      rolesEl.innerHTML = "";

      const roleCheckboxes = targetForm.querySelectorAll("input[name='roles']:checked");

      if (isRoleChecked.length === 0) {
        rolesEl.innerHTML = '<span class="badge fw-normal bg-secondary">권한 없음</span>';
      } else {
        roleCheckboxes.forEach(checkbox => {
          const labelText = checkbox.nextElementSibling.textContent.trim();
          const badgeClass = (checkbox.value === 'ROLE_SUPER') ? 'bg-danger' : 'bg-primary';

          rolesEl.innerHTML += `<span class="badge fw-normal ${badgeClass}">${labelText}</span>`
        });
      }


      // 활성 상태 업데이트
      const stateEl = item.querySelector(`.state_${targetId}`);
      const isActvie = targetForm.querySelector(`input[name='active']`).checked;

      stateEl.innerHTML = '';
      if (isActvie) {
        stateEl.innerHTML = '<span class="badge bg-success fs-6 fw-normal">활성</span>'
      } else {
        stateEl.innerHTML = '<span class="badge bg-secondary fs-6 fw-normal">비활성</span>'
      }

    } else {
      alert(result.message);
    }
  })
  .catch((err) => {
    alert("서버 통신에 실패했습니다.");
    console.log(err);
  });

}

const modifyButtons = document.querySelectorAll(".modify-button");

modifyButtons.forEach(button => {
  button.addEventListener("click", (e) => {
    const targetForm = e.target.closest(".modify-form");
    const targetId = targetForm.dataset.targetId;

    handleSubmitModify(e, targetForm, targetId);
  })
})
