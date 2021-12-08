<template>
  <div >
    <form id="reading-log-form-container">
      <select class="form" name="book-select" id="book-select">
        <option
          v-for="option in bookOptions"
          v-bind:key="option.id"
          v-bind:value="option.value"
        >
          {{ option.text }}
        </option>
      </select>
      <select class="form" name="minutes-read" id="minutes-read">
        <option value="10">10 min</option>
        <option value="10">20 min</option>
        <option value="10">30 min</option>
        <option value="10">40 min</option>
        <option value="10">50 min</option>
        <option value="10">60 min</option>
      </select>
      <input class= "form" type="date">
    </form>
  </div>
</template>

<script>
export default {
  name: "reading-log-form",
  data() {
    return {
      newLog: {},
      bookOptions: [
        {
          text: "Harry Potter and the Sorcerer's Stone",
          value: "9780439708180",
        },
        {
          text: "How to Catch a Unicorn",
          value: "9781728234939",
        },
        {
          text: "Oh, the Places You'll Go",
          value: "9780007413577",
        },
      ],
    };
  },
};
</script>

<style scoped>
#reading-log-form-container{
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  flex-wrap: wrap;
  padding: 5px;
}

</style>