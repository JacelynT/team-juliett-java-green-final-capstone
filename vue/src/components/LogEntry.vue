<template>
  <div id="log-entry-container">
    <div id="log-container">
      <img
        id="icon"
        :src="require('../assets/' + logEntry.icon)"
        alt="face icon"
      />

      <p id="title" class="log-info">{{ logEntry.title }}</p>

      <p id="minutes" class="log-info">{{ logEntry.minutes }} min</p>

      <p id="date" class="log-info">{{ logEntry.date }}</p>
    </div>
  </div>
</template>


<script>
export default {
  name: "log-entry",
  props: ["logEntry"],
  data() {
    return {};
  },
};
</script>

<style scoped>
.log-info {
  margin-bottom: 0px;
}
img {
  filter: invert(.45);
  height: 30px;
  width: auto;
}
#log-container {
  padding: 0.5rem;
  margin-bottom: 0.25rem;
  border-bottom: solid 1px #CE401C;
  color: #333;
  display: grid;
  grid-template-columns: 1fr 6.5fr 2fr 2fr;
  grid-template-areas: "child-icon title minutes date";
  justify-items: start;
  align-items: center;
  row-gap: 1px;
  column-gap: 10px;
}
/* #log-container {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  gap: 10px 30px;
  flex-grow: 2;
  margin: 0 10px;
} */
#icon {
  grid-area: child-icon;
}

#title {
  grid-area: title;
}

#minutes {
  grid-area: minutes;
}

#date {
  grid-area: date;
  justify-self: end;
  padding: 0px 10px;
}
/* #log-container {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  flex-wrap: wrap;
  padding: 5px;
} */
/* .log-info {
  margin: 0px 10px;
} */
</style>
