<template>
  <div id="app">
    <app-header />
    <router-view />
    <app-footer />
  </div>
</template>

<script>
import AppHeader from "./components/AppHeader.vue";
import AppFooter from "./components/AppFooter.vue";

export default {
  data() {
    return {
      book: {
        isbn: "9780007158447",
        minutes: 45,
        childId: 1,
        date: "11-05-2021",
      },
    };
  },
  components: {
    AppHeader,
    AppFooter,
  },
};
</script>

<style>
html {
  font-family: sans-serif;
}
</style>
