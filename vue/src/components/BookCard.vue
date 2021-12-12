<template>
  <div>
    <div class="card">
      <div v-on:click="isClicked = !isClicked">
        <img
          class="card-img-top"
          v-bind:src="
            'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'
          "
          alt=""
        />
        <div class="card-body">
          <h5 class="card-title">{{ book.title }}</h5>
          <p class="card-text">{{book.minutes}} minutes</p>
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
      isClicked: false,
      bookLog: {
        date: new Date().toLocaleDateString("en-US"),
        isbn: this.book.isbn || '',
        minutes: "",
        childId: this.$store.state.selectedChildId,
      },
    };
  },
  methods: {
    submitTime() {
      this.isClicked = false;
      ReadingTrackerService.postBookLog(this.bookLog).then(() => {
          ReadingTrackerService.bookLogs().then((response) => {
            this.$store.commit("SET_FAMILY_LOGS", response.data);
          });
        });
      },
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
  height: 150px;
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
