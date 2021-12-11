<template>
  <div id="account-container">
    <!--<div class="reading-overview"> -->
        <img id="chart" src="../assets/placeholderchart.png" />
        <list-of-child id="list-of-child"/>
<!--    </div> -->
      <reading-log-history id="reading-log"/>
  </div>
</template>

<script>
import ReadingLogHistory from '../components/ReadingLogHistory.vue';
import ListOfChild from '../components/ListOfChild.vue';
import ReadingTrackerService from '../services/ReadingTrackerService';

export default {
    name: 'account',
    components: { 
    ReadingLogHistory,
    ListOfChild 
  },
  created(){
    ReadingTrackerService.bookLogs()
    .then(response => {
      this.$store.commit('SET_FAMILY_LOGS', response.data);
    }
    )
  }


}
</script>

<style scoped>
#account-container {
  display: grid;
  grid-template-columns: 1fr 2fr;
  grid-template-areas: 
    "chart list-of-child "
    "reading-log reading-log";
}

#chart {
  grid-area: chart;
}

#list-of-child {
  grid-area: list-of-child;
  display: flex;
  justify-content: space-between;

}

#reading-log {
  grid-area: reading-log;
}
/* .reading-overview {
    display: flex;
    flex-direction: row;
} */
</style>