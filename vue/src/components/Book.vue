<template>
  <div id="book-container">
      <img
      v-if="book.isbn"
      v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-L.jpg'"
    />
      <h2>{{book.title}}</h2>
      <h2>{{book.minutes}} min</h2>
      <h2>{{book.date}}</h2>
  </div>
</template>


<script>
import ReadingTrackerService from '../services/ReadingTrackerService.js';
export default {
    name: 'book',
    data() {
        return{  
            book: {
            isbn: '9780007158447',
            title: 'The Cat in the Hat',
            minutes: 40,
            date: "12/5/2021"
    }}
    },
    created(){
        ReadingTrackerService.book()
        .then(response => {
            this.book = response.data;
        })
    }
}
</script>

<style scoped>
img{
    height: 150px;
    width: auto;
    border-radius: 1em;
}
#book-container{
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    flex-wrap: wrap;
    padding: 25px;
}
</style>