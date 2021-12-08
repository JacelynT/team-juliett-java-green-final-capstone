<template>
<div>
  
  <div id="list-children-container">
    <child v-for="child in children" v-bind:key="child.childId" v-bind:child="child" />
    <div>
       <img id="plus-circle" src="../assets/plus-circle-solid.png"/>
       <h3>Add Child</h3>
    </div>
  </div>
    
  </div>
</template>

<script>
import Child from '../components/Child.vue';
import ReadingTrackerService from '../services/ReadingTrackerService.js';
export default {
    name: 'list-children',
    components: {
        Child
    },
    data(){
        return{
            children: [
                
            ]
        }
    },
    created(){
        ReadingTrackerService.account()
        .then(response => {
            this.children = response.data;
        })
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
    align-items: center;
}

#plus-circle {
    height: 150px;
    width: auto;
    border-radius: 50%;
}

.reading_overview {
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
}

h3 {
    text-align: center;
}
</style>