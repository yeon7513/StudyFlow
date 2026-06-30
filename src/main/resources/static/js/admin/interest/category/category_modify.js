// 인라인 수정을 위해 카테고리명을 클릭하면 form으로 변경
const handleClickEditCategoryName = (target, categoryName, categoryNo) => {

  // 폼이 존재하면 이벤트 핸들러 실행 X
  if (target.querySelector('.category-edit-form')) {
    return;
  }

  // e.stopPropagation();

  // 다른 카테고리명을 클릭했을 때는 다시 복구
  const otherEditForms = document.querySelectorAll('.category-edit-form');
  otherEditForms.forEach(form => {
    handleCancelEditCategoryName(form);
  });

  target.innerHTML = '';

  // 폼 생성
  const form = document.createElement('form');
  form.className = 'category-edit-form input-group input-group-sm';
  form.dataset.categoryNo = categoryNo;

  // 인풋 생성
  const input = document.createElement('input');
  input.type = 'text';
  input.value = categoryName;
  input.name = 'name';
  input.className = 'form-control';

  // 버튼 - 서브밋
  const submitButton = document.createElement('button');
  submitButton.type = 'submit';
  submitButton.className = 'btn btn-outline-primary';
  submitButton.innerHTML = '<i class="fa-solid fa-check"></i>';

  // 버튼 - 취소
  const cancelButton = document.createElement('button');
  cancelButton.type = 'button';
  cancelButton.className = 'btn btn-outline-secondary';
  cancelButton.innerHTML = '<i class="fa-solid fa-xmark"></i>';

  // form 이벤트 버블링 해제 & 서브밋 핸들러 등록
  form.addEventListener('click', (e) => e.stopPropagation());
  form.addEventListener('submit', handleSubmitEditedCategoryName);

  // 수정 취소 버튼 핸들러
  cancelButton.addEventListener('click', (e) => {
    e.stopPropagation();
    if (confirm("수정을 취소하시겠습니까?")) {
      handleCancelEditCategoryName(form);
    }
  });

  form.appendChild(input);
  form.appendChild(submitButton);
  form.appendChild(cancelButton);

  target.appendChild(form);

  input.focus();
}

// -------------------------------------------------------------------

// 수정된 카테고리명 전송 핸들러
const handleSubmitEditedCategoryName = (e) => {
  e.preventDefault();

  const form = e.target;
  const categoryNo = form.dataset.categoryNo;
  const newCategoryName = form.name.value;

  const formData = new FormData();

  formData.append('name', newCategoryName);

  fetch(`/admin/management/interest/category/update/${categoryNo}/name`, {
    method: 'POST',
    body: formData,
  }).then(res => res.json())
  .then(result => {
    if (result.success) {
      const parentEl = form.parentElement;
      parentEl.dataset.categoryName = newCategoryName;
      parentEl.dataset.categoryNo = categoryNo;
      parentEl.innerHTML = `${newCategoryName} <i class="fa-regular fa-pen-to-square ms-2 text-primary"></i>`;
      parentEl.addEventListener('click', (e) => handleClickEditCategoryName(e, newCategoryName, categoryNo));

      const updatedAtEl = parentEl.closest(".panel-item").querySelector(".updated-at");
      updatedAtEl.textContent = result.updatedAt;

    } else {
      alert(result.message);
      handleCancelEditCategoryName(form);
    }
  }).catch(err => {
    alert("서버와 통신에 실패했습니다.");
    console.error("서버 통신 오류", err);
  });

}

// -------------------------------------------------------------------

// 수정 모드 종료 핸들러
const handleCancelEditCategoryName = (form) => {
  const parentEl = form.parentElement;
  const originCategoryName = parentEl.dataset.categoryName;
  parentEl.innerHTML = `${originCategoryName} <i class="fa-regular fa-pen-to-square ms-2 text-primary"></i>`;
}

// -------------------------------------------------------------------

export {handleClickEditCategoryName, handleSubmitEditedCategoryName, handleCancelEditCategoryName};
