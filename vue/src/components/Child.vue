<template>
  <div v-on:click="selectChildId(child.childId)" id="child-container">
    <router-link v-bind:to="{name: 'child-page'}" v-bind:child="child">
      <img :src="require('../assets/' + child.icon)" />
      <h3 id="child-name">{{ child.name }}</h3>
    </router-link>
  </div>
</template>

<script>
export default {
  name: "child",
  props: ["child"],
  methods: {
    selectChildId(childId){
      this.$store.commit('SET_SELECTED_CHILD_ID', childId);
    },
    // getChildIcon(icon) {
    //   return ('../assets/' + icon);
    // }
  }
};
</script>

<style scoped>
img {
  height: 150px;
  width: auto;
}
#child-name {
  text-align: center;
}
#child-container {
  display: inline-block;
  padding: 25px;
}
</style>