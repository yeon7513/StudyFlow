const handleRenderPanel = (url, tabPanel, tabButtons, targetButton) => {
  // 기존 내용 초기화 (패널 & 버튼 클래스)
  tabPanel.innerHTML = '';
  tabButtons.forEach(button => button.classList.remove('active-tab'));

  targetButton.classList.add('active-tab');

  fetch(`/admin/management/interest/${url}`)
  .then(res => res.text())
  .then(result => {
    tabPanel.innerHTML = result;
  })
  .catch(err => console.log(err));
}

export {handleRenderPanel};
