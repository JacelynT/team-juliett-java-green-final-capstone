<template>
  <div v-on:click="addActiveBook" id="small-book-container">
    <i class="far fa-plus-square"></i>
    
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
      let activeIsbns = [];
      this.$store.state.activeBooks.forEach(element => {
        activeIsbns.push(element.isbn);
      });
      if(activeIsbns.includes(this.activeBook.isbn)){
        alert('Oops.. I think that book is already marked as active')
      } else {
        ReadingTrackerService.addActiveBook(this.activeBook);
      ReadingTrackerService.activeBooks(this.$store.state.selectedChildId)
      .then(response => {
        this.$store.commit('SET_ACTIVE_BOOKS', response.data);
      });
      }
      
    }
  },
};
</script>

<style scoped>
#small-book-container {
  position: relative;
  opacity: 75%;
}

#small-book-container:hover {
  opacity: 100%;
}

.fa-plus-square {
  /* opacity: 65%; */
  top: 5px;
  left: 5px;
  height: 30px;
  width: 30px;
  position: absolute;
  font-size: 5px;
  color: #0D97AC;
  background-color: white;
  border-radius: 15%;
  
  

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