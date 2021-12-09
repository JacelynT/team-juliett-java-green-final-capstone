<template>
  <div>
    <h2 class="display-5">Books I'm Reading</h2>
    <div id="current-book-container">
      <div class="current-book" v-for="book in currentBooks" v-bind:key="book.id">
        <img v-bind:src="
          'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'
        " alt="">
        <h3>{{book.title}}</h3>
        <h4>{{book.minutes}} min</h4>
      </div>
    </div>
    <hr>
    <h2 class="display-5">Family Library</h2>
      <div id="library-container">
      <small-book class="library-book" v-for="book in library" v-bind:key="book.id" v-bind:isbn="book.isbn">
      </small-book>
      </div>
  </div>
</template>

<script>
import SmallBook from '../components/SmallBook.vue';
// import ReadingTrackerService from "../services/ReadingTrackerService.js"

export default {
  data() {
    return {
      currentBooks: [],
      library: [],
    };
  },
  components: {
    SmallBook
  },
  name: "child-page",
  created(){
    this.library = this.$store.state.familyLibrary;
  }
};
</script>

<style scoped>
img {
  border-radius: 1rem;
}
#current-book-container {
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
}
#library-container {
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
  margin: 0px 25px;
}
.current-book, .library-book {
  text-align: center;
  padding: 1em 1em;
}

h2 {
  padding: 1em 1em;
}
</style>