<template>
  <div>
    <child-header />
    <reading-log-form />
    <book-list />
  </div>
</template>

<script>
import BookList from "../components/BookList.vue";  //needs moved to parent
import ReadingLogForm from "../components/ReadingLogForm.vue";
import ChildHeader from "../components/ChildHeader.vue";
// import ReadingTrackerService from "../services/ReadingTrackerService.js"

export default {
  data(){
    return{
    }
  },
  components: {
    BookList,
    ChildHeader,
    ReadingLogForm,

  },
  name: "reading-details",
  // created() {
  //   ReadingTrackerService.activeBooks(childId: 1 )
  // }
};
</script>

<style>
</style>