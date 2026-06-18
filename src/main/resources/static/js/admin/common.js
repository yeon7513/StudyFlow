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
  const header = document.querySelector("#dashboard-wrap header");

  if (localStorage.getItem('sidebarState') === 'shrink') {
    sidebar.classList.add('shrink');
    header.classList.add('shrink');
  }

  const handleToggleSidebar = () => {
    sidebar.classList.toggle("shrink");
    header.classList.toggle("shrink");

    if (sidebar.classList.contains('shrink')) {
      localStorage.setItem('sidebarState', 'shrink');
    } else {
      localStorage.setItem('sidebarState', 'visible');
    }
  };

  toggleSidebarButton.addEventListener("click", handleToggleSidebar);

});
