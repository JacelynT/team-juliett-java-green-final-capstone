<template>
  <div id="list-children-container">
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
                    minutes: 65,
                    bookMinutes: [
                        ['9780060207052', 20],
                        ['9780399208539', 45]
                    ]
                },
                {
                    childId: 2,
                    name: 'David',
                    minutes: 40,
                    bookMinutes: [
                        ['9780060207052', 10],
                        ['9780399208539', 30]
                    ]
                },
                {
                    childId: 3,
                    name: 'Emily',
                    minutes: 50,
                    bookMinutes: [
                        ['9780060207052', 45],
                        ['9780399208539', 5]
                    ]
                }
            ]
        }
    }

}
</script>

<style scoped>
#list-children-container{
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    flex-wrap: wrap;
    margin-top: 50%;
}

</style>
