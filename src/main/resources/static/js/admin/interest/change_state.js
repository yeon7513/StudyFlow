const handleChangeState = (target, targetNo, url) => {
  const newState = target.checked;

  const formData = new FormData();
  formData.append("isActive", newState);

  fetch(`/admin/management/interest/${url}/update/${targetNo}/state`, {
    method: "POST",
    body: formData,
  })
  .then(res => res.json())
  .then(result => {
    if (result.success) {
      target.checked = newState;
      const panelItem = target.closest(".panel-item");

      const checkboxLabel = panelItem.querySelector(".form-check-label");
      checkboxLabel.textContent = newState ? '활성' : '비활성';

      const updatedAtEl = panelItem.querySelector(".updated-at");
      updatedAtEl.textContent = result.updatedAt;

    } else {
      alert(result.message);
    }
  })
  .catch((err) => console.log(err));

};

export {handleChangeState};
