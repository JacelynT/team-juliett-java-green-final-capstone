<template>
  <div id="account-container">
    <!--<div class="reading-overview"> -->
        <img id="chart" src="../assets/placeholderchart.png" />
        <list-of-child id="list-of-child"/>
<!--    </div> -->
      <reading-log-history v-bind:logs="retrieveLogs" id="reading-log"/>
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
    this.$store.commit('SET_SELECTED_CHILD', '');
    ReadingTrackerService.bookLogs()
    .then(response => {
      this.$store.commit('SET_FAMILY_LOGS', response.data);
    })
  },
  computed: {
  retrieveLogs(){
    return this.$store.state.familyLogs.slice(0,10);
  }
  }
}
</script>

<style scoped>
#account-container {
  margin: 0 10em;
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

}

#reading-log {
  grid-area: reading-log;
}
/* .reading-overview {
    display: flex;
    flex-direction: row;
} */
</style>