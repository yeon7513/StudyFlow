import {handleClickEditCategoryName} from './category_modify.js';
import {handleChangeState} from '../change_state.js';

// ----------------------------------------------------------------------

// 새로고침 시 탭 메뉴를 고정시키려고하다보니,
// 이벤트 핸들러가 또 날아가는 버그가 발생함.
// 탭 패널에 이벤트 위임을 해서 해당 요소를 찾는 로직으로 변경함.
const tabPanel = document.getElementById('tab-panel');

tabPanel.addEventListener('click', (e) => {
  const target = e.target;

  // 카테고리명 변경
  const categoryName = target.closest(".category-name")

  if (categoryName) {
    const name = categoryName.dataset.categoryName;
    const no = categoryName.dataset.categoryNo;

    handleClickEditCategoryName(categoryName, name, no);
  }

  // 카테고리 상태 변경
  const categoryState = target.closest('input[name="categoryState"]')

  if (categoryState) {
    const no = categoryState.dataset.categoryNo;
    handleChangeState(categoryState, no, 'category')
  }
})

const openRegisterCategoryModalButton = document.getElementById('register-category');
const modal = document.getElementById("modal");
const cancelModalButton = document.getElementById("cancel-modal");

const handleShowModal = () => {
  modal.style.display = "block";

  const body = modal.closest("body");
  body.style.overflow = "hidden";
};

// 모달 닫기
const handleHideModal = () => {
  modal.style.display = "none";

  const body = modal.closest("body");
  body.style.overflow = "auto";
};

modal.addEventListener("click", handleHideModal);
cancelModalButton.addEventListener("click", handleHideModal);

openRegisterCategoryModalButton.addEventListener('click', handleShowModal);
