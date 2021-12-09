<template>
  <div id="small-book-container">
      <img v-bind:src="
        'http://covers.openlibrary.org/b/isbn/' + isbn + '-M.jpg'
      " alt="">
      <div class="upper-right">add</div>
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
#small-book-container{
  position: relative;
  text-align: center;
}
.upper-right{
  position: absolute;
  padding: 0px 5px;
  top: 22px;
  left: 100px;
  color: black;
  background-color: white;
  border-radius: 50%;
  text-align: center;
  font-weight: bold;
}
img{
  height: 180px;
  width: 130px;
  border-radius: 5%;
}
</style>