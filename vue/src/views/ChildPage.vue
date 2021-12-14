<template>
  <div id="child-page">
    <child-header /> 
    <child-reading-log-history id="child-header" />
    <h2 id="books-im-reading">Books I'm Reading</h2>
    <div id="active-book-container">
      <book-card
        class="active-book"
        v-for="book in retrieveActiveBooks"
        v-bind:book="book"
        v-bind:key="book.id"
      />
    </div>
    <!-- <hr /> -->
    <h2 id="library-title">Family Library</h2>
    <div id="library-container">
      <small-book
        class="library-book"
        v-for="book in retrieveLibrary"
        v-bind:key="book.id"
        v-bind:isbn="book.isbn"
        v-bind:childId="retrieveChildId"
      >
      </small-book>
      <div v-on:click="showAddBookForm = !showAddBookForm" id="add-book">
        <i class="far fa-plus-square"></i>
      </div>
    </div>
    <h2 id="book-form-title">Add a Book to the Library</h2>
  </div>
</template>

<script>
import BookCard from "../components/BookCard.vue";
import ChildHeader from '../components/ChildHeader.vue';
import ChildReadingLogHistory from "../components/ChildReadingLogHistory.vue";
import SmallBook from "../components/SmallBook.vue";
import ReadingTrackerService from "../services/ReadingTrackerService.js";

export default {
  components: {
    SmallBook,
    BookCard,
    ChildReadingLogHistory,
    ChildHeader
  },
  data() {
    return {
      showAddBookForm: false,
    };
  },
  name: "child-page",
  created() {
    ReadingTrackerService.library().then((response) => {
      this.$store.commit("SET_FAMILY_LIBRARY", response.data);
    }),
      ReadingTrackerService.activeBooks(this.$store.state.selectedChild.childId).then(
        (response) => {
          this.activeBooks = response.data;
          this.$store.commit("SET_ACTIVE_BOOKS", response.data);
        }
      ),
      ReadingTrackerService.bookLogs().then((response) => {
        this.$store.commit("SET_FAMILY_LOGS", response.data);
      });
  },
  computed: {
    retrieveLibrary() {
      return this.$store.state.familyLibrary;
    },
    retrieveActiveBooks() {
      return this.$store.state.activeBooks;
    },
    retrieveChildId() {
      return this.$store.state.selectedChildId;
    },
  },
  methods: {
    addBookForm() {},
  },
};
</script>

<style scoped>
.fa-plus-square {
  /* opacity: 65%; */
  top: 59px;
  left: 38px;
  height: 50px;
  width: 50px;
  position: absolute;
  font-size: 15px;
  color: #0d97ac;
  background-color: white;
  border-radius: 15%;
}
#add-book {
  opacity: 65%;
  position: relative;
  margin: 16px;
  height: 180px;
  width: 130px;
  border: solid 2px whitesmoke;
  border-radius: 5%;
  box-shadow: 0px 2px 10px 1px slategrey;
}
#add-book:hover {
  opacity: 100%;
}
#child-page {
  padding: 2em;
  grid-gap: 1em;
  display: grid;
  grid-template-columns: 1fr 2fr;
  grid-template-areas:
    "child-header active-title"
    "child-header active-books"
    "library-title library-title"
    "library library";
}
#books-im-reading {
  grid-area: active-title;
}
#child-header {
  grid-area: child-header;
}
#library-title {
  grid-area: library-title;
}
img {
  border-radius: 1rem;
}
book-card {
  margin: 50px;
}
#active-book-container {
  grid-area: active-books;
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
  grid-area: library;
}
.active-book {
  margin: 1rem;
}
.active-book,
.library-book {
  text-align: center;
  padding: 1em 1em;
}
h2 {
  padding: 0.5rem;
  color: white;
  background-color: #0d97ac;
  border-radius: 0.1em;
}
hr {
  width: 95%;
}
</style>