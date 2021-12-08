<template>
  <div id="app">
    <app-header />
    <child-header />
    <router-view />
    <app-footer />
  </div>
</template>

<script>
import AppHeader from './components/AppHeader.vue'
import AppFooter from './components/AppFooter.vue'
import ChildHeader from './components/ChildHeader.vue'

export default {


components: {
  AppHeader,
  AppFooter,
  ChildHeader
}

}
</script>

<style>
html{
  font-family: sans-serif;
}
</style>
