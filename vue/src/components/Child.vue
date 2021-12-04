<template>
  <div>
      <img src="../assets/face-icon.jpg" alt="face icon">
      <h3>{{name}}</h3>
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
}
</style>