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
  name: 'App',
  components: {
    MainHeader,
    MainFooter,
  }


};
</script>

<style>
#app{
  width: 90%;

  margin-bottom: 2rem;

}
html {
  font-family: sans-serif;
}
</style>
