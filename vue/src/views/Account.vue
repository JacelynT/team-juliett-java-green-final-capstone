<template>
  <div id="account-container">
    <span class="reading_overview">
        <img src="../assets/placeholderchart.png" />
        <span id="placeholder">
             <book-list />
        </span>
    </span>
      <list-children />
  </div>
</template>

<script>
import BookList from '../components/BookList.vue';
import ListChildren from '../components/ListChildren.vue';

export default {
    name: 'account',
  components: { 
    ListChildren,
    BookList 
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