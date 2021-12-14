<template>
  <div>
    <body>
      <div>
      <!--  <child  /> -->
        <div>
          <div id="child-name">{{ child.name }}</div>
          <div id="total-minutes">
            Total Minutes: {{ child.minutes }} + minutes
          </div>
          <div id="past-week">Past Week: {{ child.minutes }}</div>
          <div id="past-week-log">{{ child.logEntry }}</div>
        </div>
      </div>
    </body>
  </div>
</template>

<script>
//import Child from "../components/Child.vue";

export default {
  name: "child-header",
  components: {
   // Child,
  },
  props: ["child"],
  data() {
    return {
    
    };
  },
};
</script>

<style scoped>
</style>