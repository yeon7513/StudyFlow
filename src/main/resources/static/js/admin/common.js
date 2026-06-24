document.addEventListener("DOMContentLoaded", () => {
  // 메뉴가 활성화 되었을 때 클래스 적용
  const currentPath = window.location.pathname;

  const menuLinks = document.querySelectorAll("#sidebar > nav > .main-menu li a");

  menuLinks.forEach(link => {
    if (currentPath.includes(link.getAttribute("href"))) {
      link.classList.add("active-menu");
    }
  });

  // 사이드바 접기
  const toggleSidebarButton = document.getElementById("toggle-sidebar-button");
  const sidebar = document.getElementById("sidebar");

  // 초기 상태 로드
  if (localStorage.getItem('sidebarState') === 'shrink') {
    sidebar.classList.add('shrink');
  }

  toggleSidebarButton.addEventListener("click", () => {
    const isShrink = sidebar.classList.toggle("shrink");

    console.log(isShrink);

    // 상태 저장
    localStorage.setItem('sidebarState', isShrink ? 'shrink' : 'visible');
  });
});
