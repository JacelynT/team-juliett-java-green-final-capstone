<template>
<div>
  <div id="list-child-container">
    <child v-for="child in children" v-bind:key="child.childId" v-bind:child="child" />
     <div id="add-child-container">
       <i class="fas fa-plus-square"></i>
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
    gap: 1em;
}

.fa-plus-square {
    height: 150px;
    width: 150px;
    border-radius: 5%;
   
    padding: 20px;
    margin-bottom: 10px;
    color: #0d97ac;

}

.reading_overview {
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
}

h3 {
    text-align: center;
    font-family: 'Varela Round', sans-serif;
    font-weight: bold;
    color:  #0d97ac;
}
</style>