<template>
  <div>
    <body>
      <div id="header-container">
        <child v-bind:child="child" />
       
      
        <div id="minutes-container">
          <span>
        <div id="total-minutes">
            Total Minutes: 
            <div>{{ child.minutes }} minutes</div>
          </div>
          </span>
          
          <div id="past-week-log">{{ child.logEntry }}</div>
          </div>
      </div>
    </body>
  </div>
</template>

<script>
import Child from "../components/Child.vue";

export default {
  name: "child-header",
  components: {
   Child,
  },
  props: ["child"],
  data() {
    return {
      
    };
  },
  computed: {
    childLogEntries(){
        return this.$store.state.familyLogs.filter((log) => {
            return log.childId === this.$store.state.selectedChildId 
            ? log 
            : false;
        })
        .slice(0,5);
    }
  }
};
</script>

<style scoped>
#header-container {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  gap: 25px;
  /* border: 2px solid #CE401C; */
  border-radius: 2%;
}

#total-minutes, #past-week {
  color: #DDA033;
  font-weight: bold;
  font-family: "Varela Round", sans-serif;
}

#minutes-container {
  display: flex;
  flex-direction: column;
  justify-content: center;  
}

</style>