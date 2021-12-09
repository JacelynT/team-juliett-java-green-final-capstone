<template>
  <div id="log-container">
    <img src="../assets/face-icon.jpg" alt="face icon" />
    <h3 class="log-info lead">{{ logEntry.title }}</h3>
    <h3 class="log-info lead">{{ logEntry.minutes }} min</h3>
    <h3 class="log-info lead">{{ logEntry.date }}</h3>
  </div>
</template>


<script>
export default {
  name: "log-entry",
  props: ['logEntry'],
  data() {
    return {
      
    };
  },
   
 };
</script>

<style scoped>
img {
  height: 25px;
  width: auto;
  border-radius: 1em;
}
#log-container {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  flex-wrap: wrap;
  padding: 5px;
}
.log-info {
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