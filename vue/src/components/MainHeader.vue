<template>
  <div id='main-header'>

    <link href="https://fonts.googleapis.com/css?family=Noto+Serif|Varela+Round" rel="stylesheet">
    <router-link id="home-logo" v-bind:to="{ name: 'home' }">
      <div>
        <img id="logo" src="../assets/bookaroo-transparent.png" />
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

      <!-- <div id="add-book">Add Book</div>
      <div>&nbsp;|&nbsp;</div>
      <div id="reading-history">Reading History</div>
      <div>&nbsp;|&nbsp;</div>  -->
      <div>
        <router-link v-bind:to="{ name: 'account' }">Account</router-link>
      </div>
    </nav>

  </div>
</template>

<script>
export default {
  name: 'main-header',
};
</script>

<style scoped>
#main-header{
  border-bottom: solid 5px #E0D8C3;
  display: flex;
  align-items: center;
  flex-direction: row;
  justify-content: space-between;
  width: 100vw;
  padding: 0px 30px;
}
#logo {
  height: 15vh;
  /* border: solid 2px rgba(0, 0, 0, 0.5); */
  border-radius: 10%;
  margin: 1rem 1rem 1rem 0px;
}
#empty-space {
  width: 45%
}
#nav {
  font-family: 'Varela Round', sans-serif;
  padding-right: 30px;
}
#nav > div {
  margin: 1px
}

#add-book, #reading-history {
  padding: 3px;
}
</style>>

