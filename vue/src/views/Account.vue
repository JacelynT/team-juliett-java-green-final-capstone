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
import ReadingTrackerService from '../services/ReadingTrackerService.js';

export default {
    name: 'account',
  components: { 
    ReadingLogHistory,
    ListOfChild 
    },
    created(){
      this.$store.commit('SET_SELECTED_CHILD_ID', 0);
      ReadingTrackerService.library()
      .then(response => {
        this.$store.commit('SET_FAMILY_LIBRARY', response.data);
      })
    }

}
</script>

<style>

span {
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
}
</style>