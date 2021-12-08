<template>
  <div id="account-container">
    <span class="reading_overview">
        <img src="../assets/placeholderchart.png" />
        <span id="placeholder">
             <reading-log-form />
        </span>
    </span>
   <reading-log-form />
      <list-children />
  </div>
</template>

<script>
import ListChildren from '../components/ListChildren.vue';
import ReadingLogForm from "../components/ReadingLogForm.vue";

export default {
    name: 'account',
  components: { ListChildren },
  ReadingLogForm

}
</script>

<style>

span {
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
}
</style>