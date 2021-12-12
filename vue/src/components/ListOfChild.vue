<template>
<div>
  
  <div id="list-child-container">
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
    name: 'list-of-child',
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
#list-child-container{
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    align-items: center;
    justify-content: space-around;
    padding: 2rem;
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