<template>
  <div id="book-container">
    <h3 class="book-info">{{ book.title }}</h3>
    <h3 class="book-info">{{ book.minutes }} min</h3>
    <h3 class="book-info">{{ book.date }}</h3>
  </div>
</template>


<script>
export default {
  name: "book",
  props: ['book'],
  data() {
    return {
      
    };
  },
   
 };
</script>

<style scoped>
img {
  height: 150px;
  width: auto;
  border-radius: 1em;
}
#book-container {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  flex-wrap: wrap;
  padding: 5px;
}
.book-info{
  margin: 0px 10px;
}
</style>

created() {
     ReadingTrackerService.book().then((response) => {
       this.book = response.data;
     });
   },

 book: {
         isbn: "9780007158447",
         title: "The Cat in the Hat",
         minutes: 40,
         date: "12/5/2021",
       },