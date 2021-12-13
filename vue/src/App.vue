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
  font-family: 'Varela Round';
  font-weight: bold;
  letter-spacing: .1em;
  margin-bottom: 2rem;
  overflow-x: hidden;
}
</style>
