<template>
  <div id="account-container">
    <div class="reading-overview">
        <img src="../assets/placeholderchart.png" />
        <list-of-child />
    </div>
      <reading-log-history />
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
.reading-overview {
    display: flex;
    flex-direction: row;
}
</style>