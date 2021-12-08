<template>
  <div id="app">
    <app-header />
    <router-view />
    <app-footer />
  </div>
</template>

<script>
import AppHeader from './components/AppHeader.vue'
import AppFooter from './components/AppFooter.vue'


export default {


components: {
  AppHeader,
  AppFooter
  
}

}
</script>

<style>
html {
  font-family: sans-serif;
}
</style>
