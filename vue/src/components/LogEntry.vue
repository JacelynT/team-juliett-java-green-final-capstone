<template>
  <div>
    <div id="log-container">
    <img id="icon" src="../assets/face-icon.jpg" alt="face icon" />
    <h3 id="title" class="log-info lead">{{ logEntry.title }}</h3>
    <h3 id="minutes" class="log-info lead">{{ logEntry.minutes }} min</h3>
    <h3 id="date" class="log-info lead">{{ logEntry.date }}</h3>
 </div>
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
  
  display: grid;
  grid-template-rows: 1fr;
  grid-template-columns: 4, 1fr;
  grid-template-areas: icon title minutes date;
  row-gap: 5px;
  column-gap: 10px;
}
/* #log-container {
  display: flex;
  flex-direction: row;
  align-items: center;
} */
#icon {
  grid-area: icon;
  text-align: left;
}

#title {
  grid-area: title;
  text-align: left;
}

#minutes {
  grid-area: minutes;
  }

#date {
  grid-area: date;
}
/* #log-container {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  flex-wrap: wrap;
  padding: 5px;
} */
/* .log-info {
  margin: 0px 10px;
} */
</style>
