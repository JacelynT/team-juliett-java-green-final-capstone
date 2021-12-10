<template>
  <div>
    <h2 class="display-5">Books I'm Reading</h2>
    <div id="current-book-container">
      <book-card class="book-card" v-for="book in currentBooks" v-bind:book="book" v-bind:key="book.id"/>
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
import BookCard from '../components/BookCard.vue';
import SmallBook from '../components/SmallBook.vue';
// import ReadingTrackerService from "../services/ReadingTrackerService.js"

export default {
  data() {
    return {
      currentBooks: [
        {"isbn":"9780375810886","title":"Green Eggs and Ham","author":"Dr. Seuss","minutes":0,"active":true},{"isbn":"9780439554923","title":"Harry Potter and the Prisoner of Azkaban","author":"J.K. Rowling","minutes":0,"active":true},{"isbn":"9781728234939","title":"How to Catch a Unicorn","author":"Adam Wallace","minutes":0,"active":true},
      ],
      library: [],
    };
  },
  components: {
    SmallBook,
    BookCard
  },
  name: "child-page",
  created(){
    this.library = this.$store.state.familyLibrary;
  }
};
</script>

<style scoped>
book-card{
  padding: 20px;
}
img {
  border-radius: 1rem;
}
#current-book-container {
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
  justify-content: space-evenly;
  align-items: flex-start;
  margin-bottom: 75px;
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