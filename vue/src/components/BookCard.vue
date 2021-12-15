<template>
  <div>
    <div v-on:click="deleteActiveBook" class="card" v-show="showBook">
      <i class="far fa-minus-square"></i>
      <div v-on:click="isClicked = !isClicked">
        <img
          class="card-img-top"
          v-bind:src="
            'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'
          "
          alt=""
        />
        <div class="card-body">
          <h5 class="card-title">{{ currentBook.title }}</h5>
          <p class="card-text">{{ currentBook.minutes }} minutes</p>
        </div>
        <div class="card-form" v-on:click.stop="" v-show="isClicked">
          <hr />
          <select
            class="form lead"
            name="minutes-read"
            id="minutes-read"
            v-model="bookLog.minutes"
          >
            <option value="" selected="selected" disabled>add minutes</option>
            <option value="10">10 min</option>
            <option value="20">20 min</option>
            <option value="30">30 min</option>
            <option value="40">40 min</option>
            <option value="50">50 min</option>
            <option value="60">60 min</option>
          </select>
          <button v-on:click="submitTime" class="btn btn-outline-dark">
            Log Minutes
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ReadingTrackerService from "../services/ReadingTrackerService.js";
export default {
  name: "book-card",
  props: ["book"],
  data() {
    return {
      currentBook: this.book,
      showBook: true,
      isClicked: false,
      bookLog: {
        date: new Date().toLocaleDateString("en-US"),
        isbn: this.book.isbn || '',
        minutes: "",
        childId: this.$store.state.selectedChildId,
      },
      activeBook: {
        isbn: this.book.isbn,
        childId: this.$store.state.selectedChildId
      }
    };
  },
  methods: {
    submitTime() {
      this.isClicked = false;
      if(this.bookLog.minutes == "" || this.bookLogMinutes == 0){
        alert('Oops.. Make sure you choose how much time you want to log!');
      } else {
        ReadingTrackerService.postBookLog(this.bookLog).then(() => {
          ReadingTrackerService.bookLogs().then((response) => {
            this.$store.commit("SET_FAMILY_LOGS", response.data);
          });
        });
      }},
      deleteActiveBook() {
        if(event.target.tagName == 'svg' || event.target.tagName == 'path'){
          ReadingTrackerService.deleteActiveBook(this.activeBook).then(
            this.showBook = false,
            ReadingTrackerService.activeBooks(this.$store.state.selectedChildId)
              .then(response => {
                this.$store.commit('SET_ACTIVE_BOOKS', response.data);
              })
          );
        }
      }
      
    },
  computed: {
    // retrieveChildId() {
    //   return this.$store.state.selectedChildId;
    // },
  },
};
</script>

<style scoped>
img {
  height: 250px;
}

.card {
  width: 180px;
  box-shadow: 0 4px 8px 0 #d3d3d3;
}

.card-img-top {
  padding: 8px;
}

.card-body {
  padding-top: 5px;
  padding-left: 8px;
  height: 135px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.card-title {
  font-size: 18px;
}

.card-text {
  font-size: 18px;
}

hr {
  margin: 0 8px 16px 8px;
}

.card-form {
  padding: 0 8px 0 8px;
}

.btn {
  margin: 15px;
}
.form {
  width: 100%;
}

.fa-minus-square {
  /* opacity: 65%; */
  top: -10px;
  left: -15px;
  height: 30px;
  width: 30px;
  position: absolute;
  font-size: 5px;
  color: #0A7D8F;
  background-color: white;
  border-radius: 15%;
}

/* .card-content-container {
  text-align: center;
  font-size: 0.9em;
  padding: 2px 16px;
  background: #ff0000;
} */

/* .card-content-container > p:first-of-type {
  margin-top: 50px;
}

.card-content-container > p:last-of-type {
  margin-bottom: 0px;
} */
</style>>