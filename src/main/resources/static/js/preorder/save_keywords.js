// 선택한 키워드를 세션 스토리지에 저장

const saveSelectedKeywords = () => {
  const form = document.getElementById('select-keywords');
  console.log(form.kwdNo.value);

  console.log(form.kwdNo);
};

const saveButton = document.getElementById('save-selected-keyword');

saveButton.addEventListener('click', saveSelectedKeywords);
