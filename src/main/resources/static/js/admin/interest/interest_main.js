import {handleRenderPanel} from "./toggle_panel.js";

// 탭 메뉴 변경
const tabButtons = document.querySelectorAll('.tab-button');
const tabPanel = document.getElementById('tab-panel');

tabButtons.forEach(button => {
  button.addEventListener('click', () => {
    const targetUrl = button.dataset.url;

    // 이미 활성화 된 탭이면 실행 종료
    if (button.classList.contains('active-tab')) {
      return;
    }

    handleRenderPanel(targetUrl, tabPanel, tabButtons, button);

    // 키워드 탭에서 새로고침 시, 카테고리 탭으로 강제 새로고침 됨.
    // 이걸 방지하기 위해 LocalStorage를 사용함.
    localStorage.setItem('lastTab', targetUrl);
  })
});

// -----------------------------------------------------------------------

// 새로고침 시 마지막으로 보고 있던 탭으로 변경
const lastTab = localStorage.getItem('lastTab');
const lastTabButton = document.querySelector(`.tab-button[data-url="${lastTab}"]`);

if (lastTab && lastTabButton) {
  // 로컬 스토리지에 저장되어있고, 해당하는 탭 버튼을 찾았을 경우, 강제 클릭
  lastTabButton.click();
} else {
  // 아니면 카테고리 탭으로...
  tabButtons[0].click();
}
