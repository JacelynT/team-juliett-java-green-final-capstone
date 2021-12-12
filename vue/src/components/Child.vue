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
  height: 200px;
  width: auto;
  opacity: 75%;
}
#child-name {
  text-align: center;
}
#child-container {
  display: inline-block;
  padding: 25px;
}
</style>