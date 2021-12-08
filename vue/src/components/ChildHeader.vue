<template>
  <div>
    <child v-bind:key="child.childId" v-bind:child="child" />
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
        child: { childId: 1, name: "Gordon", minutes: 60, bookMinutes: null }
    };
  },
};
</script>

<style>

</style>