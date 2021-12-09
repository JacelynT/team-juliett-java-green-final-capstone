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
  padding: 6px 5px;
  top: 5px;
  right: 5px;
  color: black;
  background-color: white;
  border: solid 2px black;
  border-radius: 50%;
  text-align: center;
  font-weight: bold;
  
  box-shadow: 0px 2px 10px 2px slategrey;
}
img{
  height: 180px;
  width: 130px;
  border: solid 2px whitesmoke;
  border-radius: 5%;
  box-shadow: 0px 2px 10px 5px slategrey;
}
</style>