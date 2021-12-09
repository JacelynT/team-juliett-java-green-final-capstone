<template>
  <div id="reading-log-container">
    <log-entry
      v-for="book in readingLogHistory"
      v-bind:key="book.id"
      v-bind:book="book"
    />
  </div>
</template>

<script>
import LogEntry from "./LogEntry.vue";
export default {
  name: "reading-log-history",
  components: { LogEntry },
  data() {
    return {
      bookList: [
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
    };
  },
};
</script>

<style scoped>
#reading-log-container {
  border: solid 2px gray;
  border-radius: 1em;
  overflow: auto;
  margin: 20px;
}
</style>