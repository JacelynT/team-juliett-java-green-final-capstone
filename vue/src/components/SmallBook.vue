<template>
  <div id="small-book-container">
      <img id="plus-sign" scr="../assets/plus-solid.png" />
      <img v-bind:src="
        'http://covers.openlibrary.org/b/isbn/' + isbn + '-M.jpg'
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
#small-book-container{
  position: relative;
  text-align: center;
}
#plus-sign{
  position: absolute;
  height: 50px;
  width: auto;
  color: rgb(163, 0, 0);
  border: solid 1px whitesmoke;
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