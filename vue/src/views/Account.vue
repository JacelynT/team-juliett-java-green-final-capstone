<template>
  <div id="account-container">
    <span class="reading_overview">
        <img src="../assets/placeholderchart.png" />
        <list-of-child />
    </span>
      <reading-log-history />
  </div>
</template>

<script>
import ReadingLogHistory from '../components/ReadingLogHistory.vue';
import ListOfChild from '../components/ListOfChild.vue';
//import ReadingTrackerService from '../services/ReadingTrackerService.js';

export default {
    name: 'account',
    components: { 
    ReadingLogHistory,
    ListOfChild 
  },


}
</script>

<style>

span {
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
}
</style>