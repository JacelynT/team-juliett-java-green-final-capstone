<template>
  <div id="child-page">
    <child-header />
    <child-reading-log-history />
    <h2 class="display-5">Books I'm Reading</h2>
    <div id="active-book-container">
      <book-card class="book-card" v-for="book in activeBooks" v-bind:book="book" v-bind:key="book.id"/>
    </div>
    <hr />
    <h2 class="display-5">Family Library</h2>
      <div id="library-container">
      <small-book class="library-book" v-for="book in library" v-bind:key="book.id" v-bind:isbn="book.isbn">
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
      activeBooks: [],
      library: [],
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
      this.$store.commit('SET_SELECTED_CHILD_ID', 0);

      ReadingTrackerService.library()
      .then(response => {
        this.$store.commit('SET_FAMILY_LIBRARY', response.data);
        this.library = this.$store.state.familyLibrary;

      ReadingTrackerService.activeBooks(this.$store.state.selectedChildId)
      .then(response => {
        this.activeBooks = response.data;
      })
      })
    }
  
};
</script>

<style scoped>
#child-page{
  width: 90%;
  margin: auto;
}
book-card{
  padding: 20px;
}
img {
  border-radius: 1rem;
}

#active-book-container {
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
  align-items: flex-start;
  gap: 15px;
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