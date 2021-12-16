<template>
  <div>
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
    <div id="add-book-form" v-show="showAddBookForm">
      <h2 id="book-form-title">Add a Book to the Library</h2>
      <div id="book-form-fields">
        <input v-model="newBook.title" id="title" type="text" placeholder="Title" />
        <input v-model="newBook.author" id="author" type="text" placeholder="Author" />
        <input v-model="newBook.isbn" id="isbn" type="text" placeholder="ISBN" />
        <input v-on:click.prevent="addBookToLibrary" id="submit" type="submit">
      </div>
    </div>
  </div>
</template>

<script>
import SmallBook from "../components/SmallBook.vue";
import ReadingTrackerService from "../services/ReadingTrackerService.js"

export default {
     components: {
    SmallBook
  },
  data() {
    return {
      showAddBookForm: false,
      currentChild: {},
      newBook: {
        title: '',
        author: '',
        isbn: ''
      }
    };
  },
  name: "child-page",
  created() {
    ReadingTrackerService.library().then((response) => {
      this.$store.commit("SET_FAMILY_LIBRARY", response.data);
      ReadingTrackerService.activeBooks(this.$store.state.selectedChildId).then(
        (response) => {
          this.activeBooks = response.data;
          this.$store.commit("SET_ACTIVE_BOOKS", response.data);
          ReadingTrackerService.bookLogs().then((response) => {
            this.$store.commit("SET_FAMILY_LOGS", response.data);
            ReadingTrackerService.getChild(
              this.$store.state.selectedChildId
            ).then((response) => {
              this.currentChild = response.data;
            });
          });
        }
      );
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
    addBookToLibrary() {
      if(this.newBook.title != '' && this.newBook.author != '' && this.newBook.isbn != ''){
        ReadingTrackerService.addBook(this.newBook).then(
          ReadingTrackerService.library
        );
        this.newbook = {};
        this.showAddBookForm = false;
      }
    },
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
  color: #0A7D8F;
  background-color: white;
  border-radius: 15%;
}
#book-form-fields {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  flex-wrap: wrap;
  margin: 1rem;
}
#book-form-fields > * {
  margin: 1rem;
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
#library-container {
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
  /* margin: 0px 25px; */
  margin-left: 7%;
  grid-area: library;
  gap: 0 20px;
}

.library-book {
  text-align: center;
  padding: 1em 1em;
}

h2 {
  padding: 0.5rem;
  color: white;
  background-color: #0A7D8F;
  border-radius: 0.1em;
  border-bottom: 5px solid #065125;
  max-height: 60px;
}
</style>