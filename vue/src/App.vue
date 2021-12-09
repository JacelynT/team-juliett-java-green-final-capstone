<template>
  <div id="app">
    <main-header />
    <router-view />
    <book-card />
    <main-footer />
  </div>
</template>

<script>
import BookCard from './components/BookCard.vue';
import MainFooter from './components/MainFooter.vue';
import MainHeader from './components/MainHeader.vue';



export default {
  components: {
    MainHeader,
    MainFooter,
    BookCard,
  }


};
</script>

<style>
html {
  font-family: sans-serif;
}
</style>
