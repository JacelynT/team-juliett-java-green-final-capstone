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

      
      <div>
        <router-link id="account" v-bind:to="{ name: 'account' }">Account</router-link>
      </div>
      <div id="login"><router-link id="login" v-bind:to="{ name: 'login' }">Login</router-link></div>
      <div id="register"><router-link id="register" v-bind:to="{ name: 'register' }">Register</router-link></div>
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
  /* border-bottom: solid 5px #E0D8C3; */
  display: flex;
  align-items: center;
  flex-direction: row;
  justify-content: space-between;
  width: 100vw;
  padding: 0px 30px;
}
#logo {
  height: 10vh;
  /* border: solid 2px rgba(0, 0, 0, 0.5); */
  border-radius: 10%;
  margin: 1rem 1rem 1rem 0px;
}
#empty-space {
  width: 45%
}
#nav {
  font-family: "Noto Serif", Georgia, serif;
 
  display: inline-flex;
  justify-content: right;
  color: #e0d8c3;
  padding-right: 30px;
  gap: 25px;
}
#nav > div:not(#register){
  margin: 1px;
  padding: 15px;
   background-color: #0D97AC;
}

#add-book, #reading-history {
  padding: 3px;
}

#account, #login {
  color: #e0d8c3;
  text-decoration: none;
}

#register {
  margin: 1px;
  padding: 15px;
  background-color: #dda033;
  color: #e0d8c3;
  text-decoration: none;
}
</style>>

