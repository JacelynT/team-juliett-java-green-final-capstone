<template>
  <div id="account-container">
      <list-children />
  </div>
</template>

<script>
import ListChildren from '../components/ListChildren.vue'

export default {
    name: 'account',
  components: { ListChildren },

}
</script>

<style>
#account-container{
}
</style>