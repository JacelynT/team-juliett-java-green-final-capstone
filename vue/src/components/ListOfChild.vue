<template>
<div>
  <div id="list-child-container">
    <child v-for="child in children" v-bind:key="child.childId" v-bind:child="child" />
     <div v-on:click="toggleAddChild = !toggleAddChild" id="add-child-container">
       <i class="fas fa-plus-square"></i>
       <h3 v-show="!toggleAddChild" >Add Child</h3>
       <div id="add-child-input">
            <input v-on:click.stop="" v-show="toggleAddChild" v-model="newChild.name" type="text" placeholder="Name">
            <button v-on:click="addChild" v-show="toggleAddChild"><i class="far fa-check-square"></i></button>
       </div>
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
            children: [ ],
            toggleAddChild: false,
            newChild: { },
        }
    },
    created(){
        ReadingTrackerService.account()
        .then(response => {
            this.children = response.data;
        })
    },
    methods: {
        addChild(){
            ReadingTrackerService.addChild(this.newChild);
            this.toggleAddChild = !this.toggleAddChild;
            this.newChild = {};
        }
    }

}
</script>

<style scoped>
#add-child-input{
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}
#list-child-container{
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    align-items: center;
    justify-content: flex-start;
    padding: 2rem;
    gap: 4em;
}

.fa-plus-square {
    /* filter: invert(1); */
    height: 150px;
    width: 150px;
    border-radius: 5%;
    padding: 20px;
    margin-bottom: 10px;
    color: white;
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
    color:  white;
}

#add-child-container {
  background-color: #0D97AC;
  display: inline-block;
  padding: 25px;
  border-radius: 5%;
  border-bottom: 5px solid #E2532F;
}
button{
    border-radius: 15%;
}
input{
    border-radius: .25rem;
    display: block;
    max-width: 110px;
    font-family: 'Varela Round', sans-serif;
}
</style>