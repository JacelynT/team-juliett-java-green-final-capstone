<template>
  <div>
    <div class="card">
      <img
        src="http://covers.openlibrary.org/b/isbn/9780439554923-M.jpg"
        alt=""
        class="card-image"
      />
      <div class="card-content-container">
        <p>Active Book Title</p>
        <p>Total Book Minutes</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "book-card",
};
</script>

<style scoped>
.card {
    width: 320px;

  box-shadow: 0 4px 8px 0 #d3d3d3;

}

.card-image {
  

}

.card-content-container {

  text-align: center;
  font-size: 0.9em;
  padding: 2px 16px;
  background: #ff0000;
}

/* .card-content-container > p:first-of-type {
  margin-top: 50px;
}

.card-content-container > p:last-of-type {
  margin-bottom: 0px;
} */
</style>>
