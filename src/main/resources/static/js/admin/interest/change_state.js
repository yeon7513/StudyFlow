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

      const updatedAtEl = target.closest(".panel-item").querySelector(".updated-at");
      updatedAtEl.textContent = result.updatedAt;

    } else {
      alert(result.message);
    }
  })
  .catch((err) => console.log(err));

};

export {handleChangeState};
