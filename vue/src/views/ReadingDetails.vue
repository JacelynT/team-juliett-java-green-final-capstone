<template>
  <div>
    <reading-log-form />
      <book-list />
  </div>
</template>

<script>
import BookList from '../components/BookList.vue';
import ReadingLogForm from '../components/ReadingLogForm.vue';
export default {
  components: { 
    BookList,
    ReadingLogForm 
    },
    name: "reading-details"

}
</script>

<style>

</style>