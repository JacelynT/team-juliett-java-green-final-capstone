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
  name: 'App',
  components: {
    MainHeader,
    MainFooter,
    BookCard,
  }


};
</script>

<style>
#app{
  width: 90%;
  margin: auto;
  margin-bottom: 2rem;
}
html {
  font-family: sans-serif;
}
</style>
