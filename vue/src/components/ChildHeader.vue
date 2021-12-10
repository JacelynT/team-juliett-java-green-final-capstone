<template>
  <div>
    <body>
    <child v-bind:key="child.childId" v-bind:child="child" />
    <div id="total-minutes">Total Minutes: {{child.minutes}} + minutes</div>
    <div id="past-week">Past Week: {{child.minutes}}</div>
    <div id="past-week-log">{{child.logEntry}}</div>

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
  props: "child",
  data() {
    return {
      child: {
        childId: '',
        name: '',
        minutes: 60,
        bookMinutes: null,
      },
    };
  },
};
</script>

<style scoped>



</style>