const modal = document.getElementById("modal");
const cancelModalButton = document.getElementById("cancel-modal");

const handleShowModal = () => {
  modal.style.display = "block";
};

// 모달 닫기
const handleHideModal = () => {
  modal.style.display = "none";
};

modal.addEventListener("click", handleHideModal);
cancelModalButton.addEventListener("click", handleHideModal);

const reservationCards = document.querySelectorAll(".reservations li");

const handleLoadReservationDetailByEmail = (rsvNo) => {
  // 각 정보를 모달로 각각 띄우기
  // 모달과 전체 목록 리스트가 같은 html에 있기 때문에
  // 데이터는 json으로 받아온다.
  fetch(`/admin/management/reservation/list/${rsvNo}`)
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
  console.log(data);

  const basicInfoList = document.querySelector(".basic-info ul");

  const status = modal.querySelector("#status");

  status.textContent = data.canceled ? "예약취소" : "예약중";
  status.className = data.canceled ? "canceled" : "active";

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

  const canceledInfo = modal.querySelector(".canceled-info");

  if (data.canceled) {
    canceledInfo.style.display = "block";

    const canceledAt = canceledInfo.querySelector("#canceled-at");
    const canceledReason = canceledInfo.querySelector("#canceled-reason");

    if (canceledAt) {
      canceledAt.textContent = data.canceledAt;
    }
    if (canceledReason) {
      canceledReason.textContent = data.canceledReason;
    }
  } else {
    canceledInfo.style.display = "none";
  }

  handleShowModal();
};
