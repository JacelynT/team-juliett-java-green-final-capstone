<template>
  <div id="booklist-container">
    <book v-for="book in bookList" v-bind:key="book.id" v-bind:book="book" />
  </div>
</template>

<script>
import Book from "../components/Book.vue";
export default {
  components: { Book },
  data() {
    return {
      bookList: [
        {
          isbn: "9780007158447",
          title: "The Cat in the Hat",
          minutes: 40,
          date: "12/5/2021",
        },
        {
          isbn: "9780007158447",
          title: "The Cat in the Hat",
          minutes: 20,
          date: "12/7/2021",
        },
      ],
    };
  },
};
</script>

<style scoped>
#booklist-container{
  border: solid 2px gray;
  border-radius: 1em;
  overflow: auto;
  margin: 20px;
}

</style>