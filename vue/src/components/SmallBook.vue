<template>
  <div>
      <img v-bind:src="
        'http://covers.openlibrary.org/b/isbn/' + '9781728234939' + '-M.jpg'
      " alt="">
  </div>
</template>

<script>
export default {
    name: 'small-book',
    props: ['isbn'],
    data(){
        return{
            
        }
    }

}
</script>

<style scoped>
img{
  height: 180px;
  width: 120px;
  border-radius: 5%;
}
</style>