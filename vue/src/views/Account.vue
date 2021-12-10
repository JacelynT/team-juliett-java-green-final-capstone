<template>
  <div id="account-container">
    <span class="reading_overview">
        <img src="../assets/placeholderchart.png" />
        <span id="placeholder">
             <reading-log-history />
        </span>
    </span>
      <list-of-child />
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
#account-container {
  display: grid;
 
}

span {
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
}
</style>