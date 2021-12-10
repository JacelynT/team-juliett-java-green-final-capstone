<template>
  <div id="small-book-container">
      <img v-bind:src="
        'http://covers.openlibrary.org/b/isbn/' + isbn + '-M.jpg'
      " alt="">
      <i class="fas fa-plus"></i>
      
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
.fa-plus{
  position: absolute;
  padding: 6px 5px;
  font-size: 50px;
  background: transparent;
  border-radius: 50%;
  color: rgb(185, 36, 36);
  font-weight: bold;
  
}
img{
  height: 180px;
  width: 130px;
  border: solid 2px whitesmoke;
  border-radius: 5%;
  box-shadow: 0px 2px 10px 1px slategrey;
}
</style>