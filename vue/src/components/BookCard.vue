<template>
  <div>
    <div class="card" >
      <div v-on:click="isClicked = !isClicked">
      <img
        class="card-img-top"
        v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'"
        alt=""
      />
      <div class="card-body">
        <h5 class="card-title">Harry Potter and the Prisoner of Azkaban</h5>
        <p class="card-text">45 mins.</p>
        </div>
        <div v-on:click.stop="" v-show="isClicked">
          <hr />
          <select class="form lead" name="minutes-read" id="minutes-read" v-model="bookLog.minutes">
            <option value="" selected="selected" disabled>add minutes</option>
            <option value="10">10 min</option>
            <option value="20">20 min</option>
            <option value="30">30 min</option>
            <option value="40">40 min</option>
            <option value="50">50 min</option>
            <option value="60">60 min</option>
          </select>
          <button v-on:click="submitTime" class="btn btn-outline-dark">Submit Time</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "book-card",
  props: [ 'book' ],
  data() {
    return {
      isClicked: false,
      bookLog: {
        date: new Date().toLocaleDateString('en-US'),
        isbn: this.book.isbn,
        minutes: '',
        childId: this.$store.state.selectedChildId
      },
    };
  },
  methods: {
    submitTime(){
      this.isClicked = false;
      //send post method containing bookLog
    }
  }
    
};
</script>

<style scoped>
.card {
  width: 180px;
  box-shadow: 0 4px 8px 0 #d3d3d3;
}

.card-img-top {
  padding: 8px;
}

.card-body {
  padding-top: 5px;
}
.card-title {
  font-size: 18px;
}

.card-text {
  font-size: 18px;
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
