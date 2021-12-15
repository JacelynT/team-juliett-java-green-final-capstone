export const childrenChartData = {
    type: "line",
    data: {
      labels: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
      datasets: [
        {
          label: "Gordon",
          data: [60, 30, 20, 20, 40, 20, 70],
          backgroundColor: "rgba(54,73,93,.5)",
          borderColor: "#36495d",
          borderWidth: 3
        },
        {
          label: "Autumn",
          data: [20, 20, 20, 20, 20, 20, 40],
          backgroundColor: "rgba(71, 183,132,.5)",
          borderColor: "#47b784",
          borderWidth: 3
        }
      ]
    },
    options: {
      responsive: true,
      lineTension: 1,
      scales: {
        yAxes: [
          {
            ticks: {
              beginAtZero: true,
              padding: 25
            }
          }
        ]
      }
    }
  };
  
  export default childrenChartData;