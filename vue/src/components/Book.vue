<template>
  <div id="book-container">
      <img
      v-if="book.isbn"
      v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-L.jpg'"
    />
      <h2> {{book.title}} </h2>
      <h3> {{book.author}} </h3>
  </div>
</template>


<script>
import ReadingTrackerService from '../services/ReadingTrackerService.js';
export default {
    name: 'book',
    data() {
        return{  
            book: []
        }
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
    border-radius: 50%;
}
#child-name{
    text-align: center;
}
#child-container{
    display: inline-block;
    padding: 25px;
}
</style>