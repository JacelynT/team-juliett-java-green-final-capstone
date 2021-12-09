<template>
  <div>
    <div id="header">
      <router-link id="home-logo" v-bind:to="{ name: 'home' }">
        <div>
          <img id="logo" src="../assets/placeholder_logo.png" />
        </div>
      </router-link>
      <div id="empty-space"></div>
      <nav id="nav">
        <router-link
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
        >
          Logout &nbsp;|&nbsp;</router-link
        >

        <div>Add Book</div>
        <div>&nbsp;|&nbsp;</div>
        <div>Reading History</div>
        <div>&nbsp;|&nbsp;</div>
        <div>
          <router-link v-bind:to="{ name: 'account' }">Account</router-link>
        </div>
      </nav>
    </div>
  </div>
</template>

<script>
export default {
    name: 'header',
    data() {
        return {};
    },
};
</script>

<style scoped>

</style>>

