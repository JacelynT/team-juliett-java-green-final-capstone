<template>
  <div>
      <img v-bind:src="
        'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'
      " alt="">
  </div>
</template>

<script>
export default {
    name: 'book-cover',
    props: ['book'],
    data(){
        return{

        }
    }

}
</script>

<style scoped>
img{
    border-radius: 1em;
}
</style>