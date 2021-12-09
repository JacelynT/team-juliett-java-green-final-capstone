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
    <h2>Library</h2>
      <div id="library-container">
      <div class="library-book" v-for="book in library" v-bind:key="book.id">
        <img v-bind:src="
          'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'
        " alt="">
        </div>
      </div>
  </div>
</template>

<script>
import ReadingLogForm from "../components/ReadingLogForm.vue";
//import ChildHeader from "../components/ChildHeader.vue";
// import ReadingTrackerService from "../services/ReadingTrackerService.js"

export default {
  data() {
    return {
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
        },
      ],
      library: [
        {
          isbn: "9780007158447",
          title: "The Cat in the Hat",
          author: "Dr. Seuss",
          minutes: 0,
        },
        {
          isbn: "9780375810886",
          title: "Green Eggs and Ham",
          author: "Dr. Seuss",
          minutes: 0,
        },
        {
          isbn: "9780439554923",
          title: "Harry Potter and the Prisoner of Azkaban",
          author: "J.K. Rowling",
          minutes: 0,
        },
        {
          isbn: "9780439708180",
          title: "Harry Potter and the Sorcerer's Stone",
          author: "J.K. Rowling",
          minutes: 0,
        },
        {
          isbn: "9781728234939",
          title: "How to Catch a Unicorn",
          author: "Adam Wallace",
          minutes: 0,
        },
        {
          isbn: "9780007413577",
          title: "Oh, the Places You'll Go",
          author: "Dr. Seuss",
          minutes: 0,
        },
        {
          isbn: "9780670016617",
          title: "The Last Kids on Earth",
          author: "Max Brallier",
          minutes: 0,
        },
        {
          isbn: "9780140371567",
          title: "James and the Giant Peach",
          author: "Roald Dahl",
          minutes: 0,
        },
        {
          isbn: "9780440840404",
          title: "The BFG",
          author: "Roald Dahl",
          minutes: 0,
        },
        {
          isbn: "9780439064873",
          title: "Harry Potter and the Chamber of Secrets",
          author: "J.K. Rowling",
          minutes: 0,
        },
      ],
    };
  },
  components: {
    //ChildHeader,
    ReadingLogForm,
  },
  name: "child-page",
  // created() {
  //   ReadingTrackerService.activeBooks(childId: 1 )
  // }
};
</script>

<style scoped>
img {
  border-radius: 1rem;
}
#current-book-container, #library-container {
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
}
.current-book, .library-book {
  text-align: center;
  padding: 1em 1em;
}

h2 {
  padding: 1em 1em;
}
</style>