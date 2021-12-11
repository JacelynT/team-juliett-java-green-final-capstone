<template>
  <div>
    <span id="log-container">
     
    <img id="child-icon" src="../assets/face-icon.jpg" alt="face icon" />
   
    <h3 id="title" class="log-info lead">{{ logEntry.title }}</h3> 
    
    <h3 id="minutes" class="log-info lead">{{ logEntry.minutes }} min</h3>
    
    <h3 id="date" class="log-info lead">{{ logEntry.date }}</h3>
 </span>
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
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-areas: child-icon title minutes date;
  row-gap: 5px;
  column-gap: 10px;
}
/* #log-container {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  gap: 10px 30px;
  flex-grow: 2;
  margin: 0 10px;
} */
#icon {
  grid-area: child-icon;
 
}

#title {
  grid-area: title;

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
