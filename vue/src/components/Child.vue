<template>
  <div id="child-container">
      <img src="../assets/face-icon.jpg" alt="face icon">
      <h3 id="child-name">{{name}}</h3>
  </div>
</template>

<script>
export default {
    name: 'child',
    props: [
        'name'
    ]
}
</script>

<style scoped>
img{
    height: 150px;
    width: auto;
    border-radius: 50%;
}
#child-name{
    text-align: center;
}
#child-container{
    display: inline-block;
    padding: 10px;
}
</style>