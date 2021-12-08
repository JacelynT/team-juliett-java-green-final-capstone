<template>
  <div>
            <router-link id="home-logo" v-bind:to="{ name: 'home' }">
                <div>
                    <img src="../assets/placeholder_logo.png"/>
                </div>
                </router-link>    
     

      <div id="nav">
      
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout &nbsp;|&nbsp;</router-link>
      <router-link v-bind:to="{ name: 'account' }">Account</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'book-list', params:{child_id:1}}">BookList</router-link>
    </div>


  </div>
</template>

<script>
export default {
    name: "app-header",
    data() {
        return {

        }
    }

}
</script>

<style scoped>



</style>