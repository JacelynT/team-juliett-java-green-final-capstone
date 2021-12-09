<template>
  <div id="app">
    <main-header />
    <router-view />
    <main-footer />
  </div>
</template>

<script>
import MainFooter from './components/MainFooter.vue';
import MainHeader from './components/MainHeader.vue';


export default {
  components: {
    MainHeader,
    MainFooter
  }


};
</script>

<style>
html {
  font-family: sans-serif;
}
</style>
