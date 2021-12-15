<template>
  <div v-on:click="selectChildId" id="child-container">
    <router-link v-bind:to="{name: 'child-page'}">
      <img v-bind:src="require('../assets/' + child.icon)" alt="" />
      <h3 id="child-name">{{ child.name }}</h3>
    </router-link>
  </div>
</template>

<script>
import ReadingTrackerService from '../services/ReadingTrackerService.js';
export default {
  name: "child",
  props: ["child"],
  data() {
    return {
      
    }
  },
  methods: {
    selectChildId(){
      ReadingTrackerService.activeBooks(this.child.childId)
      .then(response => {
        this.activeBooks = response.data;
        this.$store.commit('SET_ACTIVE_BOOKS', response.data);
      }),
      this.$store.commit('SET_SELECTED_CHILD_ID', this.child.childId);
    }
  }
};
</script>

<style scoped>
a{
  /* for routerlink (child name) */
  text-decoration: none;
  color: rgba(0, 0, 0, 0.75);
}

img {
  filter: invert(1);
  height: 100px;
  width: 100px;
  padding: 20px;
  border-radius: 5%;
  margin-bottom: 10px;
  
}
#child-name {
  font-family: 'Varela Round', sans-serif;
  font-weight: bold;
  text-align: center;
  color:  white;
 
}
#child-container {
  background-color: #0A7D8F;
  display: inline-block;
  padding: 25px;
  border-radius: 5%;
   border-bottom: 5px solid #CE401C;
}
</style>