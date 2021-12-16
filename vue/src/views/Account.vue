<template>
  <div id="account-container">
    <h2 id="chart-tile">Weekly Reading Activity</h2>
    <!--<div class="reading-overview"> -->
    <children-chart id="chart"></children-chart>
    <!-- <img id="chart" src="../assets/placeholderchart.png" /> -->

    <h2 id="my-children-title">My Children</h2>
    <list-of-child id="list-of-child" />
    <!--    </div> -->
    <h2 id="reading-log-title">Weekly Reading Entries</h2>
    <reading-log-history v-bind:logs="retrieveLogs" id="reading-log" />
    
    <library id="library" />
  </div>
</template>

<script>
import ReadingLogHistory from "../components/ReadingLogHistory.vue";
import ListOfChild from "../components/ListOfChild.vue";
import ReadingTrackerService from "../services/ReadingTrackerService";
import ChildrenChart from "../components/ChildrenChart.vue";
import Library from '../components/Library.vue';

export default {
  name: "account",
  components: {
    ReadingLogHistory,
    ListOfChild,
    ChildrenChart,
    Library
  },
  created() {
    this.$store.commit("SET_SELECTED_CHILD_ID", 0);
    ReadingTrackerService.bookLogs().then((response) => {
      this.$store.commit("SET_FAMILY_LOGS", response.data);
    });
  },
  computed: {
    retrieveLogs() {
      return this.$store.state.familyLogs.slice(0, 10);
    },
  },
};
</script>

<style scoped>
#account-container {
  margin: 0 10em;
  display: grid;
  grid-template-columns: 2fr 1fr;
  gap: 2em;
  grid-template-areas:
    "my-children-title library"
    "list-of-child library"
    "chart-title library"
    "chart library"
    "reading-log-title library"
    "reading-log library"
    ". library";
}

h2 {
  padding: 0.5rem;
  color: white;
  background-color: #0A7D8F;
  border-radius: 0.1em;
  border-bottom: 5px solid #065125;;
}
#chart-tile{
  grid-area: chart-title;
}
#my-children-title {
  grid-area: my-children-title;
}
#reading-log-title{
  grid-area: reading-log-title;
}
#library {
  grid-area: library;
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