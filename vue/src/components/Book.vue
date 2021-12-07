<template>
  <div id="book-container">
      <img
      v-if="book.isbn"
      v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-L.jpg'"
    />
      <h2> {{book.title}} </h2>
      <h3> {{book.author}} </h3>
  </div>
</template>

<script>
export default {
    name: 'book',
    data() {
        return{  
            book: {
            isbn: '9780007158447',
            title: 'The Cat in the Hat',
            author: 'Dr. Seuss'
    }}
    }
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
    padding: 25px;
}
</style>