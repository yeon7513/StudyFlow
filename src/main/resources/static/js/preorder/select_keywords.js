// checkbox 선택 전에 radio 비활성화 하기
const keywordCheckbox = document.querySelectorAll('input[name="kwdNo"]');

const isChecked = (e) => {
  const value = e.target.value;
  const isTargetChecked = e.target.checked;

  // 해당 checkbox의 하위 radio 버튼 찾기
  const targetSelectLevel = document.querySelector(
    `.select-level[data-kwdno="${value}"]`,
  );

  if (targetSelectLevel) {
    const radioButtons = targetSelectLevel.querySelectorAll(
      "input[type='radio']",
    );

    radioButtons.forEach((radio) => {
      if (isTargetChecked) {
        radio.removeAttribute('disabled');
      } else {
        radio.checked = false;
        radio.setAttribute('disabled', 'disabled');
      }
    });
  }
};

keywordCheckbox.forEach((keyword) => {
  keyword.addEventListener('change', isChecked);
});

// ---------------------------------------------------

// 선택한 키워드와 세션에 저장된 예약자 정보를 전송
const registerButton = document.getElementById('register-reserve-btn');

const registerReservation = () => {
  const form = document.getElementById('register-reservation');

  // 선택한 레벨 (라디오)
  const checkedLevels = form.querySelectorAll(
    '.select-level input[type="radio"]:checked',
  );
  const selectedLevels = Array.from(checkedLevels).map((level) => ({
    kwdNo: level.closest('.select-level').dataset.kwdno,
    studyLevel: level.value,
  }));

  // 선택한 키워드 정보
  const selectedKeywordData = { ...selectedLevels };

  // 세션에서 예약자 정보 꺼내오기
  const userInfo = JSON.parse(sessionStorage.getItem('user-info'));

  // 최종 정보 취합
  const resultData = {
    ...userInfo,
    selectedKeywords: selectedKeywordData,
  };

  console.log('resultData: ', resultData);
};

registerButton.addEventListener('click', registerReservation);

// ------------------------------------------------------

// 취소 버튼 (세션 초기화 O)
const cancelButton = document.querySelector('.cancel');
cancelButton.addEventListener('click', () => {
  if (
    confirm('사전 예약을 취소하시겠습니까? 취소 시 입력한 내용이 초기화됩니다.')
  ) {
    sessionStorage.removeItem('user-info');
    location.href = '/';
  } else {
    return;
  }
});
