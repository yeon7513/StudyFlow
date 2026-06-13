const searchForm = document.getElementById("search-form");
const selectedFilter = document.getElementById("selected-filter");
const resetSearchFilterBtn = document.getElementById("reset-search-filter-btn");

// ----------------------------------------------------------------------
// 필터 추가
const handleRenderSelectedFilterOptions = () => {
  if (!selectedFilter) {
    return;
  }

  const activeFilters = [];

  // 체크박스 필터 처리
  const checkedOptions = searchForm.querySelectorAll("input[type='checkbox']:checked");
  checkedOptions.forEach((option) => {
    // 전체 옵션이거나 값이 없으면 통과
    if (option.value === 'all' || option.value === '') {
      return;
    }

    const optionTitle = option.closest('.filter').querySelector(".option-title").textContent.trim();

    const label = option.nextElementSibling;
    if (label) {
      activeFilters.push({
        text: `${optionTitle}: ${label.textContent.trim()}`,
        type: 'checkbox',
        targetId: option.id,
      });
    }
  });

  // 날짜 필터 처리
  const startDate = searchForm.querySelector("input[name='startDate']").value;
  const endDate = searchForm.querySelector("input[name='endDate']").value;
  if (startDate || endDate) {
    const optionTitle = startDate.closest('.filter').querySelector(".option-title").textContent.trim();
    const dateRange = `${optionTitle}: ${startDate || '제한없음'} ~ ${endDate || '제한없음'}`;
    activeFilters.push({
      text: dateRange,
      type: 'date',
    });
  }

  // 상세 검색 필터 처리
  const keywordField = searchForm.querySelector("input[name='keyword']");
  if (keywordField && keywordField.value.trim() !== '') {
    const searchKey = searchForm.querySelector("select[name='search']");
    const searchKeyText = searchKey.options[searchKey.selectedIndex].text;

    activeFilters.push({
      text: `${searchKeyText}: ${keywordField.value.trim()}`,
      type: 'keyword',
    });
  }

  // 화면 렌더링
  if (activeFilters.length > 0) {
    selectedFilter.innerHTML = activeFilters.map(filter =>
      `<li>
        <span class="badge" data-type="${filter.type}" data-target-id="${filter.targetId || ''}">
          ${filter.text} <i class="fa-solid fa-xmark"></i>
        </span>
      </li>`,
    ).join('');
  } else {
    selectedFilter.innerHTML = '<li><span class="no-selected-filter">선택된 필터가 없습니다.</span></li>';
  }
}

// DOM 로드 시 실행
document.addEventListener('DOMContentLoaded', handleRenderSelectedFilterOptions);

// ----------------------------------------------------------------------
// 선택된 필터 개별 삭제
const handleRemoveFilter = (e) => {
  const badge = e.target.closest('.badge');

  if (!badge) {
    return;
  }

  const type = badge.dataset.type;

  if (type === 'checkbox') {
    const targetId = badge.dataset.targetId;
    document.getElementById(targetId).checked = false;
  } else if (type === 'date') {
    document.querySelector("input[name='startDate']").value = '';
    document.querySelector("input[name='endDate']").value = '';
  } else if (type === 'keyword') {
    document.querySelector("input[name='keyword']").value = '';
  }

  searchForm.dispatchEvent(new Event('submit', {cancelable: true}));
}

selectedFilter.addEventListener("click", handleRemoveFilter);

// ----------------------------------------------------------------------
// 필터 초기화
const handleResetFilters = () => {
  // window.location.pathname => 쿼리스트링을 제외한 순수한 현재 페이지 경로
  // 즉, 선택된 필터 옵션을 전부 초기화
  window.location.href = window.location.pathname;
}

resetSearchFilterBtn.addEventListener("click", handleResetFilters);

// ----------------------------------------------------------------------
// 검색 서브밋 시 브라우저 주소줄 정리
const handleSubmitSearchForm = (e) => {
  e.preventDefault();

  const form = e.target;

  const formData = new FormData(form);
  const params = new URLSearchParams();

  const keyword = formData.get('keyword');
  const isKeywordEmpty = !keyword || keyword.trim() === '';

  for (const [key, value] of formData.entries()) {
    if (value.trim() !== "") {
      if (key === "search" && isKeywordEmpty) {
        continue;
      }
      params.append(key, value);
    }
  }

  const actionUrl = form.getAttribute('action') || window.location.pathname;
  const baseUrl = actionUrl.split('?')[0];

  window.location.href = baseUrl + '?' + params.toString();
};

searchForm.addEventListener("submit", handleSubmitSearchForm);



