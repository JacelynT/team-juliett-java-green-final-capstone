<template>
  <div>
      <child v-for="child in children" v-bind:key="child.childId" v-bind:name="child.name" />
  </div>
</template>

<script>
import Child from '../components/Child.vue'
export default {
    name: 'list-children',
    components: {
        Child
    },
    data(){
        return{
            children: [
                {
                    childId: 1,
                    name: 'Anna',
                    minutes: 37,
                    bookMinutes: [
                        ['9780060207052', 20],
                        ['9780399208539', 45]
                    ]
                }
            ]
        }
    }

}
</script>

<style scoped>


</style>
