<template>
  <div v-on:click="addActiveBook" id="small-book-container">
    <i class="fas fa-plus"></i>
    
    <img
      v-bind:src="'http://covers.openlibrary.org/b/isbn/' + isbn + '-M.jpg'"
      alt=""
    />
  </div>
</template>

<script>
import ReadingTrackerService from '../services/ReadingTrackerService.js';
export default {
  name: "small-book",
  props: ['isbn', 'childId'],
  data(){
    return {
      activeBook: {
        childId: this.childId,
        isbn: this.isbn
      }
    };
  },
  methods: {
    addActiveBook(){
      ReadingTrackerService.addActiveBook(this.activeBook);
      ReadingTrackerService.activeBooks(this.$store.state.selectedChildId)
      .then(response => {
        this.$store.commit('SET_ACTIVE_BOOKS', response.data);
      });
    }
  },
};
</script>

<style scoped>
#small-book-container {
  position: relative;
  opacity: 70%;
}

#small-book-container:hover {
  opacity: 100%;
}

.fa-plus {
  /* opacity: 65%; */
  top: 80px;
  left: 56px;
  height: 50px;
  width: 50px;
  position: absolute;
  font-size: 10px;
  color: rgb(149, 56, 255);

}

/* .fa-plus:hover {
  opacity: 100%;
} */

img {
  height: 180px;
  width: 130px;
  border: solid 2px whitesmoke;
  border-radius: 5%;
  box-shadow: 0px 2px 10px 1px slategrey;
}
</style>