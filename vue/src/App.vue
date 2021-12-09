<template>
  <div id="app">
  <Header></Header>
    <router-view />
    <book-card></book-card>
  <Footer></Footer>
  </div>
</template>

<script>
import Header from './components/Header.vue';
import Footer from './components/Footer.vue';
import BookCard from './components/BookCard.vue';

export default {
  components: {
    Header,
    Footer,
    BookCard
  }

};
</script>

<style>
html {
  font-family: sans-serif;
}
</style>
