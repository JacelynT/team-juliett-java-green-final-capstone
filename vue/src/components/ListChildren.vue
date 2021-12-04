<template>
  <div id="list-children-container">
    <child v-for="child in children" v-bind:key="child.childId" v-bind:child="child" />
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
                    minutes: 80,
                    bookMinutes: new Map([
                        ['9780060207052', 20],
                        ['9780060006983', 15],
                        ['9780399208539', 45]
                    ])
                },
                {
                    childId: 2,
                    name: 'David',
                    minutes: 40,
                    bookMinutes: new Map([
                        ['9780060207052', 10],
                        ['9780399208539', 30]
                    ])
                },
                {
                    childId: 3,
                    name: 'Emily',
                    minutes: 105,
                    bookMinutes: new Map([
                        ['9780060207052', 45],
                        ['9780399208539', 5],
                        ['9780449810866', 55]
                    ])
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
    margin: 5%;
    padding: 15px;
}
</style>
