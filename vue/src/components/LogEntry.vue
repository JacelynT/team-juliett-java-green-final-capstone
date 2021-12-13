<template>
  <div id="log-entry-container">
    <span id="log-container">
     
    <img id="icon" :src="require('../assets/'+logEntry.icon)" alt="face icon" />
   
    <p id="title" class="log-info">{{ logEntry.title }}</p> 
    
    <p id="minutes" class="log-info">{{ logEntry.minutes }} min</p>
    
    <p id="date" class="log-info">{{ logEntry.date }}</p>
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
  opacity: 50%;
  height: 30px;
  width: auto;
}

#log-container {
  color: #065125;
  display: grid;
  grid-template-columns: 1.5fr 6fr 2fr 2fr;
  grid-template-areas: "child-icon title minutes date";
  justify-items: start;
  align-items: center;
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
  justify-self: end;
  padding: 0px 10px;
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
