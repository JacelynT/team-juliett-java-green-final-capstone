<template>
  <div id="child-container">
    <router-link v-bind:to="{ name: 'book-list', params: { child_id: 1 } }">
      <img src="../assets/face-icon.jpg" alt="face icon" />
      <h3 id="child-name">{{ child.name }}</h3>
    </router-link>
  </div>
</template>

<script>
export default {
  name: "child",
  props: ["child"],
};
</script>

<style scoped>
img {
  height: 150px;
  width: auto;
  border-radius: 50%;
}
#child-name {
  text-align: center;
}
#child-container {
  display: inline-block;
  padding: 25px;
}
</style>