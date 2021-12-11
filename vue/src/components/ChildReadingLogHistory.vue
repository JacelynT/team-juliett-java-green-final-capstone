<template>
  <div id="reading-log-container">
    <log-entry
      v-for="logEntry in childLogEntries"
      v-bind:key="logEntry.id"
      v-bind:logEntry="logEntry"
    />
  </div>
</template>

<script>
import LogEntry from "./LogEntry.vue";
export default {
  name: "child-reading-log-history",
  components: { LogEntry },
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
#reading-log-container {
  border: solid 2px gray;
  border-radius: 1em;
  overflow: auto;
  padding: 20px;
}
</style>