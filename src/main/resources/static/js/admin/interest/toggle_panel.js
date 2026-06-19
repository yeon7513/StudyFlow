const tabPanel = document.getElementById('tab-panel');
const tabButtons = document.querySelectorAll('.tab-button');

// ----------------------------------------------------------------------

// 카테고리 패널 렌더링
const loadCategoryPanelButton = document.getElementById('load-category-panel');

const handleRenderPanel = (url, targetButton) => {
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

tabButtons.forEach(button => {
  button.addEventListener('click', () => {
    const targetUrl = button.dataset.url;

    // 이미 활성화 된 탭이면 실행 종료
    if (button.classList.contains('active-tab')) {
      return;
    }

    handleRenderPanel(targetUrl, button);
  })
});
