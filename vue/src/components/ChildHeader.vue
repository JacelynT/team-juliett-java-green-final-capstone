<template>
  <div>
      <child v-bind:key="child.childId" v-bind:child="child" />
    

  </div>
</template>

<script>
import Child from '../components/Child.vue';


export default {
    name: 'child-header',
    components: {
        Child
      
    },
    data() {

    }
    
}
</script>

<style>
child {
    display: flex;
    justify-content: center;
}
</style>