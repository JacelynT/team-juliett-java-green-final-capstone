<template>
  <div class="home">
    <div class="hero-image">
      <div class="hero-text">
        <h1>Reading is the BEST!</h1>
        <button>Get Started!</button>
      </div>
    </div>
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
  </div>
</template>

<script>

export default {
  name: "home"
};
</script>

<style scoped>
/* div {
  background-color: #E0D8C3;
} */
.hero-image{
    background-image:  url("../assets/boy-reading-books.jpg");
    background-repeat: no-repeat;
    background-size: cover;
    position: relative;
    height: 60vh;
    width: 100vw;
}

.hero-text{
 text-align: left;
  position: absolute;
  top: 15%;
  left: 25%;
  transform: translate(-50%, -50%);
  color: #677E52;
  font-family: 'Varela Round', sans-serif;
}
h1 {
  font-family: 'Varela Round', sans-serif;
  font-weight: bolder;
  color:  #065125;
}

button {
    background-color: #dda033;
    border: none;
    color:#0d97ac;
    padding: 5px 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 2em;
    font-family: "Noto Serif", Georgia, serif;
    font-weight: normal;
}
</style>
