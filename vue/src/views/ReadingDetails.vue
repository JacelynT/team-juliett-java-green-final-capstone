<template>
  <div>
  <!-- <child-header /> -->
    <reading-log-form />
    <h2>Books I'm Reading</h2>
    <div id="current-book-container">
      <div class="current-book" v-for="book in currentBooks" v-bind:key="book.id">
        <img v-bind:src="
          'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'
        " alt="">
        <h3>{{book.title}}</h3>
        <h4>{{book.minutes}} min</h4>
      </div>
    </div>
  </div>
</template>

<script>
import ReadingLogForm from "../components/ReadingLogForm.vue";
//import ChildHeader from "../components/ChildHeader.vue";
// import ReadingTrackerService from "../services/ReadingTrackerService.js"

export default {
  data(){
    return{
      currentBooks: [
        {
          isbn: "9780375810886",
          title: "Green Eggs and Ham",
          author: "Dr. Seuss",
          minutes: 10,
        },
        {
          isbn: "9780670016617",
          title: "The Last Kids on Earth",
          author: "Max Brallier",
          minutes: 50,
        },
        {
          isbn: "9781728234939",
          title: "How to Catch a Unicorn",
          author: "Adam Wallace",
          minutes: 30,
        }
      ]
    }
  },
  components: {
    //ChildHeader,
    ReadingLogForm,

  },
  name: "reading-details",
  // created() {
  //   ReadingTrackerService.activeBooks(childId: 1 )
  // }
};
</script>

<style scoped>
img{
  border-radius: 1rem;
}
#current-book-container{
display: flex;
flex-direction: row;
justify-content: space-around;
align-items: center;
}
.current-book{
  text-align: center;
  padding: 0em 1em;
}
h2{
  padding: 1em 1em;
}
</style>