<template>
  <div>
    <canvas id="children-chart"></canvas>
  </div>
</template>

<script>
import Chart from 'chart.js';
import childrenChartData from '../services/children-data.js';

export default {
  name: 'ChildrenChart',
  data() {
    return {
      childrenChartData: childrenChartData
    }
  },
   mounted() {
    const ctx = document.getElementById('children-chart');
    console.log(ctx);
    new Chart(ctx, this.childrenChartData);
  }
}


</script>