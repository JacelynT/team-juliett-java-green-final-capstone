<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout &nbsp;|&nbsp;</router-link>
      <router-link v-bind:to="{ name: 'account' }">Account</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'book-list', params:{child_id:1}}">BookList</router-link>
    </div>
    <router-view />
  </div>
</template>
<style>
html{
  font-family: sans-serif;
}
</style>