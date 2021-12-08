<template>
  <div id="booklist-container">
      <book-list />
  </div>
</template>

<script>

import BookList from '../components/BookList.vue'

export default {
    name: 'book-list',
  components: { BookList },

}
</script>

<style>

</style>