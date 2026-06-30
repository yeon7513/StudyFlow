// 외부 자바스크립트 파일에서 타임리프 값을 사용하려면
// HTML의 <script> 태그 속성에 th:inline="javascript"에서 변수를 /*[[ ${변수} ]]*/ 주석 문법으로 선언하고
// <script src="외부 JS 파일">을 밑에 작성하면 타임리프 값을 사용할 수 있다고 함.
// -> 변수를 받을 때 타임리프 주석(/*[[ ... ]]*/)과 기본값을 함께 작성
// --> 이렇게 해야 타임리프가 없는 일반 환경에서 JS 파일을 열었을 때 구문 오류가 없다고 함.

// 참고
// https://maenco.tistory.com/entry/Thymeleaf-JavaScript-Inlining-%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8-%EC%9D%B8%EB%9D%BC%EC%9D%B8
// https://velog.io/@tilkoas35/JavaScript%EC%97%90%EC%84%9C-%ED%83%80%EC%9E%84%EB%A6%AC%ED%94%84-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0
// https://kloong.tistory.com/entry/Spring-Boot-Thymeleaf-14-%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8-%EC%9D%B8%EB%9D%BC%EC%9D%B8Javascript-Inline


// 데이터가 없을 때 띄우는 플러그인
const noDataPlugin = {
  id: 'noDataText',
  afterDraw(chart) {
    const {datasets} = chart.data;
    // 모든 데이터셋의 데이터 길이가 0인지 확인
    const hasData = datasets.some(dataset => dataset.data.length > 0);

    if (!hasData) {
      const {ctx, chartArea: {left, top, right, bottom}} = chart;
      const centerX = left + (right - left) / 2;
      const centerY = top + (bottom - top) / 2;

      ctx.save();
      ctx.textAlign = 'center';
      ctx.textBaseline = 'middle';
      ctx.font = '16px A2Z';
      ctx.fillStyle = '#333';
      ctx.fillText('표시할 데이터가 없습니다.', centerX, centerY);
      ctx.restore();
    }
  },
};

// -------------------------------------------------------------

// 신규 예약자 - 선 그래프
const newReserveChart = document.getElementById("new-reserve-chart").getContext("2d");
const newReserveChartInstance = new Chart(newReserveChart, {
  type: "line",
  data: {
    labels: newReserveData.labels,
    datasets: [
      {
        label: "신규 예약자 수",
        data: newReserveData.values,
        borderColor: "#3e95cd",
        fill: true,
      },
    ],
  },
  options: {
    plugins: {
      tooltip: {
        callbacks: {
          label: function (context) {
            const label = context.dataset.label || '';
            const value = context.parsed.y;
            return `${label}: ${value}명`;
          },
        },
      },
    },
    scales: {
      y: {
        beginAtZero: true,
        min: 0,
        ticks: {
          stepSize: 1,
        },
      },
    },
  },
  plugins: [noDataPlugin],
})

const dateRange = document.getElementById("date-range");

const handleChageDateRange = (e) => {
  const range = e.target.value;

  fetch(`/admin_dashboard/chart/new_reserve/${range}`)
  .then((res) => res.json())
  .then((result) => {
    // 새로운 데이터로 다시 값을 세팅
    newReserveChartInstance.data.labels = result.labels;
    newReserveChartInstance.data.datasets[0].data = result.values;
    // 차트 업데이트
    newReserveChartInstance.update();
  }).catch((err) => console.log(err));
}

dateRange.addEventListener("input", handleChageDateRange);

// -------------------------------------------------------------

// 선택된 관심 분야 - 파이 그래프
const keywordChart = document.getElementById("selected-keyword-chart");
new Chart(keywordChart, {
  type: "polarArea",
  data: {
    labels: selectedKeywordData.labels,
    datasets: [
      {
        label: "키워드 선택 수",
        data: selectedKeywordData.values,
        backgroundColor: [
          "#FF6384",
          "#36A2EB",
          "#FFCE56",
          "#4BC0C0",
          "#9966FF",
          "#FF9F40",
        ],
        hoverBackgroundColor: [
          "#FF6384",
        ],
      },
    ],
  },
  options: {
    plugins: {
      tooltip: {
        callbacks: {
          label: function (context) {
            const label = context.dataset.label || '';
            const value = context.raw;
            return `${label}: ${value.toLocaleString()}명`;
          },
        },
      },
    },
  },
  plugins: [noDataPlugin],
})

// -------------------------------------------------------------

// 유입 경로 - 도넛 그래프
const inflowChart = document.getElementById("inflow-chart");
new Chart(inflowChart, {
  type: "doughnut",
  data: {
    labels: inflowData.labels,
    datasets: [
      {
        label: "해당 경로 유입 수",
        data: inflowData.values,
        backgroundColor: [
          "#FF6384",
          "#36A2EB",
          "#FFCE56",
          "#4BC0C0",
          "#9966FF",
          "#FF9F40",
        ],
        hoverBackgroundColor: [
          "#FF6384",
        ],
      },
    ],
  },
  options: {
    plugins: {
      tooltip: {
        callbacks: {
          label: function (context) {
            const label = context.dataset.label || '';
            const value = context.raw;
            return `${label}: ${value.toLocaleString()}명`;
          },
        },
      },
    },
  },
  plugins: [noDataPlugin],
})


// -------------------------------------------------------------

// 지역 - 가로 막대 그래프
const regionChart = document.getElementById("region-chart");
new Chart(regionChart, {
  type: "bar",
  data: {
    labels: regionData.labels,
    datasets: [
      {
        label: "지역별 예약자 수",
        data: regionData.values,
      },
    ],
  },
  options: {
    indexAxis: "y",
    scales: {
      x: {
        beginAtZero: true,
        min: 0,
        ticks: {
          stepSize: 1,
        },
      },
    },
    plugins: {
      tooltip: {
        callbacks: {
          label: function (context) {
            const label = context.dataset.label || '';
            const value = context.parsed.x;
            return `${label}: ${value.toLocaleString()}명`;
          },
        },
      },
    },
  },
  plugins: [noDataPlugin],
})


// -------------------------------------------------------------

// 문의글 카테고리 - 세로 막대 그래프
const inquiryCategoryChart = document.getElementById("inquiry-category-chart");
new Chart(inquiryCategoryChart, {
  type: "bar",
  data: {
    labels: inquiryCategoryData.labels,
    datasets: [
      {
        label: "문의 건수",
        data: inquiryCategoryData.values,
      },
    ],
  },
  options: {
    indexAxis: "x",
    plugins: {
      tooltip: {
        callbacks: {
          label: function (context) {
            const label = context.dataset.label || '';
            const value = context.parsed.y;
            return `${label}: ${value.toLocaleString()}건`;
          },
        },
      },
    },
  },
  plugins: [noDataPlugin],
})
