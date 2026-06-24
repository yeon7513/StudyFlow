import {handleChangeState} from '../change_state.js';
import {handleLoadKeywordDetail, handleLoadKeywordModify} from './keyword_render.js';
import {handleSubmitModifiedKeywordInfo} from './keyword_modify.js';

// 키워드 활성 상태 변경
const tabPanel = document.getElementById('tab-panel');

// 키워드 상태 변경 & 키워드 상세 정보 확장 (아코디언)
tabPanel.addEventListener('change', (e) => {
  const target = e.target;

  // 키워드 상태 변경
  const keywordState = target.closest('input[name="keywordState"]')

  if (keywordState) {
    const keywordNo = keywordState.dataset.keywordNo;
    handleChangeState(keywordState, keywordNo, 'keyword')
  }

  if (target.matches(".detail-toggle-checkbox")) {
    const keywordNo = target.dataset.keywordNo;

    const panelItem = target.closest(".panel-item");
    const keywordExpandBox = panelItem.querySelector(".keyword-expand-box");
    const textOpen = panelItem.querySelector(".text-open");
    const textClose = panelItem.querySelector(".text-close");

    if (target.checked) {
      // 다른 확장 박스는 선택해제하기
      const otherToggles = document.querySelectorAll(".detail-toggle-checkbox:checked");

      otherToggles.forEach(toggle => {
        if (toggle !== target) {
          toggle.checked = false;

          const otherPanelItem = toggle.closest(".panel-item");
          const otherKeywordExpandBox = otherPanelItem.querySelector(".keyword-expand-box");
          const otherTextOpen = otherPanelItem.querySelector(".text-open");
          const otherTextClose = otherPanelItem.querySelector(".text-close");

          otherKeywordExpandBox.style.display = 'none';
          otherTextOpen.style.display = 'block';
          otherTextClose.style.display = 'none';
          otherKeywordExpandBox.innerHTML = '';
        }
      })


      handleLoadKeywordDetail(keywordNo, keywordExpandBox);
      keywordExpandBox.style.display = 'block';
      textOpen.style.display = 'none';
      textClose.style.display = 'block';
    } else {
      keywordExpandBox.innerHTML = '';
      textOpen.style.display = 'block';
      textClose.style.display = 'none';
      keywordExpandBox.style.display = 'none';
    }
  }
});

tabPanel.addEventListener('click', async (e) => {
  const target = e.target;
  const panelItem = target.closest(".panel-item");

  if (!panelItem) {
    return;
  }

  const keywordExpandBox = panelItem.querySelector(".keyword-expand-box");
  const keywordNo = panelItem.querySelector('.detail-toggle-checkbox').dataset.keywordNo

  // 수정 모드로 전환
  const changeModifyButton = target.closest(".change-modify");
  if (changeModifyButton) {
    handleLoadKeywordModify(keywordNo, keywordExpandBox);
  }

  // 수정 완료 시 서버 전송
  const submitModifyButton = target.closest(".submit-modify");
  if (submitModifyButton) {
    e.preventDefault();

    const result = await handleSubmitModifiedKeywordInfo(keywordNo, keywordExpandBox);

    if (result.success) {
      // 목록 리스트도 같이 업데이트
      const selectBox = keywordExpandBox.querySelector('select[name="cateNo"]');
      const newCategoryName = selectBox.options[selectBox.selectedIndex].text;
      const newKeywordName = result.newKeywordName;

      const panelItem = target.closest(".panel-item");
      panelItem.querySelector(".category-name").textContent = newCategoryName;
      panelItem.querySelector(".keyword-name").textContent = newKeywordName;

      handleLoadKeywordDetail(keywordNo, keywordExpandBox);
    } else {
      alert(result.message);
    }

    return;
  }

  // 수정 모드에서 조회 모드로 전환 -> 수정 취소 시
  const cancelModifyButton = target.closest(".cancel-modify");
  if (cancelModifyButton) {
    if (confirm("키워드 수정을 취소하시겠습니까?")) {
      handleLoadKeywordDetail(keywordNo, keywordExpandBox);
    }
  }
})
