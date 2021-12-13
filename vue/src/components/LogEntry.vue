<template>
  <div id="log-entry-container">
    <div id="log-container">
     
    <img id="icon" :src="require('../assets/'+logEntry.icon)" alt="face icon" />
   
    <p id="title" class="log-info">{{ logEntry.title }}</p> 
    
    <p id="minutes" class="log-info">{{ logEntry.minutes }} min</p>
    
    <p id="date" class="log-info">{{ logEntry.date }}</p>
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
.log-info{
  margin-bottom: 0px;
}
img {
  opacity: .5;
  height: 30px;
  width: auto;
}

#log-container {
  padding: .5rem;
  margin-bottom: .5rem;
  border-radius: .25rem;
  border: solid 5px #E2532F;
  color: #E2532F;
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
