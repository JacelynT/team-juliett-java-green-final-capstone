<template>
  <div id="child-page">
    <child-header />
    <child-reading-log-history />
    <h2 class="display-5">Books I'm Reading</h2>
    <div id="active-book-container">
      <book-card class="book-card" v-for="book in retrieveActiveBooks" v-bind:book="book" v-bind:key="book.id"/>
    </div>
    <hr />
    <h2 class="display-5">Family Library</h2>
      <div id="library-container">
      <small-book class="library-book" v-for="book in retrieveLibrary" v-bind:key="book.id" v-bind:isbn="book.isbn">
      </small-book>
      </div>
  </div>
</template>

<script>
import BookCard from '../components/BookCard.vue';
import ChildHeader from '../components/ChildHeader.vue';
import ChildReadingLogHistory from '../components/ChildReadingLogHistory.vue';
import SmallBook from '../components/SmallBook.vue';
import ReadingTrackerService from "../services/ReadingTrackerService.js"

export default {
  data() {
    return {
    };
  },
  components: {
    SmallBook,
    BookCard,
    ChildReadingLogHistory,
    ChildHeader
  },
  name: "child-page",
  created(){
      ReadingTrackerService.library()
      .then(response => {
        this.$store.commit('SET_FAMILY_LIBRARY', response.data);
      }),
      ReadingTrackerService.activeBooks(this.retrieveChildId)
      .then(response => {
        this.activeBooks = response.data;
        this.$store.commit('SET_ACTIVE_BOOKS', response.data);
      }),
      ReadingTrackerService.bookLogs()
      .then(response => {
        this.$store.commit('SET_FAMILY_LOGS', response.data);
      })
  },
  computed: {
    retrieveLibrary(){
      return this.$store.state.familyLibrary;
    },
    retrieveActiveBooks(){
      return this.$store.state.activeBooks;
    },
    retrieveChildId(){
      return this.$store.state.selectedChildId;
    }
  }
};
</script>

<style scoped>
#child-page{
  width: 90%;
  margin: auto;
}
img {
  border-radius: 1rem;
}
book-card{
  margin: 50px;
}
#active-book-container {
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
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
.active-book{
  margin: 1rem;
}
.active-book, .library-book {
  text-align: center;
  padding: 1em 1em;
}

hr {
  width: 95%;
}

h2 {
  padding: 1em 0em;
}
</style>