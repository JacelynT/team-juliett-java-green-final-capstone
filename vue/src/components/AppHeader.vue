<template>
  <div>
      <div id="header">
    <router-link id="home-logo" v-bind:to="{ name: 'home' }">
      <div>
        <img id="logo" src="../assets/placeholder_logo.png" />
      </div>
    </router-link>
    <nav id="nav">
        
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout &nbsp;|&nbsp;</router-link
      >
      <span>Add Book</span>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'account' }">Account</router-link
      >
      
     
    </nav>
    </div>
  </div>
</template>

<script>
export default {
  name: "app-header",
  data() {
    return {};
  },
};
</script>

<style scoped>
#logo {
  height: 18vh;
}

#header {
    display: flex;
    align-items: center;
    flex-direction: row;
   justify-content: space-between;
  
  
}


#nav {
    flex: 0 1 35%;
    
  
}


</style>