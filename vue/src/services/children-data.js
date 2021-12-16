export const childrenChartData = {
    type: "line",
    data: {
      labels: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
      datasets: [
        {
          label: "Gordon",
          data: [60, 30, 20, 20, 40, 20, 70],
          backgroundColor: "rgba(205,64,28,.25)",
          borderColor: "#CE401C",
          borderWidth: 3
          
        },
        {
          label: "Autumn",
          data: [20, 20, 30, 20, 20, 20, 40],
          backgroundColor: "rgba(10,125,143,.25)",
          borderColor: "#0A7D8F",
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