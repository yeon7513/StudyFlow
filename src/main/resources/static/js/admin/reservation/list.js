const modal = document.getElementById("modal");
const cancelModalButton = document.getElementById("cancel-modal");
const reserveCancel = modal.querySelector(".reserve-cancel");

const handleShowModal = () => {
  modal.style.display = "block";

  const body = modal.closest("body");
  body.style.overflow = "hidden";
};

// 모달 닫기
const handleHideModal = () => {
  const keywords = modal.querySelector("#keywords");
  keywords.innerHTML = "";

  modal.style.display = "none";

  const body = modal.closest("body");
  body.style.overflow = "auto";
};

modal.addEventListener("click", handleHideModal);
cancelModalButton.addEventListener("click", handleHideModal);

const reservationCards = document.querySelectorAll(".reservations li");

const handleLoadReservationDetailByEmail = (rsvNo) => {
  // 각 정보를 모달로 각각 띄우기
  // 모달과 전체 목록 리스트가 같은 html에 있기 때문에
  // 데이터는 json으로 받아온다.
  fetch(`/admin/management/reservation/detail/${rsvNo}`)
  .then((res) => res.json())
  .then((result) => handleRenderDetail(result))
  .catch((error) => console.log(error));
};

reservationCards.forEach((card) => {
  const rsvNo = card.dataset.no;

  card.addEventListener("click", () =>
    handleLoadReservationDetailByEmail(rsvNo),
  );
});

// -----------------------------------------------------

// 받아온 데이터를 모달에 띄우기
const handleRenderDetail = (data) => {
  const basicInfoList = document.querySelector(".basic-info ul");

  const status = modal.querySelector("#status");
  status.textContent = data.canceled ? "예약취소" : "예약중";
  status.className = data.canceled ? "canceled" : "active";

  // 예약자 기본정보 렌더링
  const fieldMap = {
    no: "#no",
    name: "#name",
    email: "#email",
    phone: "#phone",
    region: "#region",
    inflow: "#inflow",
    createdAt: "#created-at",
  };

  Object.entries(fieldMap).forEach(([dataKey, id]) => {
    const el = basicInfoList.querySelector(id);
    if (el) {
      // 값이 null 이거나 undefined 일 경우 빈칸 대신 하이픈 출력
      el.textContent = data[dataKey] ?? "-";
    }
  });

  // 선택한 키워드 렌더링
  const keywords = modal.querySelector("#keywords");

  data.selectedKeywords.forEach((keyword) => {
    const li = document.createElement("li");

    if (keyword.keywordName !== null) {
      li.textContent = `${keyword.keywordName} - ${keyword.studyLevel}`;
    } else {
      li.classList.add("not-selected");
      li.textContent = "선택한 관심 분야가 없습니다.";
    }

    keywords.append(li);
  });

  // 예약 취소 정보가 있을 경우
  const isCanceled = data.canceled;
  const canceledInfo = modal.querySelector(".canceled-info");

  if (isCanceled) {
    const canceledAt = canceledInfo.querySelector("#canceled-at");
    const canceledReason = canceledInfo.querySelector("#canceled-reason");

    if (canceledAt) {
      canceledAt.textContent = data.canceledAt;
    }
    if (canceledReason) {
      canceledReason.textContent = data.canceledReason;
    }

    canceledInfo.style.display = "block";
    reserveCancel.style.display = "none";
  } else {
    canceledInfo.style.display = "none";
    reserveCancel.style.display = "block";
  }

  handleShowModal();
};

// -------------------------------------------------------------

// 예약 취소
const reserveCancelBtn = reserveCancel.querySelector(".reserve-cancel-btn");

const handleCancelReserve = () => {
  console.log("예약 취소 버튼 클릭");
};

reserveCancelBtn.addEventListener("click", handleCancelReserve);
