<template>
  <div id="reading-log-container">
    <log-entry
      v-for="logEntry in logs"
      v-bind:key="logEntry.id"
      v-bind:logEntry="logEntry"
    />
  </div>
</template>

<script>
import LogEntry from "./LogEntry.vue";
export default {
  props: ['logs'],
  name: "reading-log-history",
  components: { LogEntry },
  data() {
    return {
    };
  },
};
</script>

<style scoped>
#reading-log-container {
  display: flex;
  border: solid 2px gray;
  border-radius: 1em;
  overflow: auto;
  margin: 20px;
}
</style>