<template>
  <div class="home">
    <div class="hero-image">
      <div class="hero-text">
        <h1>Reading is the BEST!</h1>
        <button><router-link id="register" v-bind:to="{ name: 'register' }">Get Started!</router-link></button>
      </div>
    </div>
    <section class="bottom-info">
      <div id="info-paragraphs">
        <h2>User Information</h2>
        <p>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
          eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc sed
          velit dignissim sodales ut eu sem. Elementum pulvinar etiam non quam
          lacus suspendisse. Morbi leo urna molestie at elementum eu facilisis.
          Senectus et netus et malesuada fames ac turpis egestas sed.
          Ullamcorper morbi tincidunt ornare massa eget egestas purus viverra.
          Pharetra convallis posuere morbi leo urna. Duis at consectetur lorem
          donec massa sapien. Tempus iaculis urna id volutpat lacus laoreet non
          curabitur gravida. Pharetra sit amet aliquam id diam maecenas
          ultricies mi. Sed euismod nisi porta lorem. Mauris pellentesque
          pulvinar pellentesque habitant morbi. Consectetur adipiscing elit ut
          aliquam purus sit.
        </p>
      </div>
      <div id="second-info">
        <h2>25 Best Children's Books</h2>
        <img src="../assets/children-reading-books-scaled.jpg" alt="">
        <p>We asked teachers, librarians, and parents and examined bestseller lists to come up with the most beloved books that should be on every child’s shelves.</p>
        <a href="https://www.rd.com/list/the-best-childrens-books-ever-written/">The 25 Best Children's Book Ever Written</a>
      </div>
      <div id="app-reviews">
        <h2>Reviews</h2>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  name: "home",
};
</script>

<style scoped>
.hero-image {
  background-image: url("../assets/boy-reading-books.jpg");
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
  height: 70vh;
  width: 100vw;
}

.hero-text {
  text-align: left;
  position: absolute;
  top: 15%;
  left: 25%;
  transform: translate(-50%, -50%);
  font-family: "Varela Round", sans-serif;
  
}

h1 {
  font-family: "Varela Round", sans-serif;
  font-weight: bold;
  font-size: 56px;
  color: #e2532f;
   /* -webkit-text-stroke: .25px #e0d8c3;
   -webkit-text-fill-color: #e2532f; */
}
img {
  height: 50px;
 
  
}


button {
  background-color: #dda033;
  border: none;
  color: #e0d8c3;
  padding: 5px 10px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 2em;
  font-family: "Noto Serif", Georgia, serif;
  font-weight: normal;
}

.bottom-info {
  background-color: #444444;
  font-family: "Noto Serif", Georgia, serif;
  font-size: 10px;
  padding: 20px;
  display: grid;
  grid-area: information-grid;
  grid-template-columns: 1fr 1fr 1fr;
  gap: 3em;
  grid-template-areas: "info second-info reviews";
  
}

.bottom-info > div {
  padding: 16px;
  background-color: #e0d8c3;
  border: 8px solid #dda033;
  border-radius: 10%;
  margin: 1em;
  
}

h2 {
  font-family: "Varela Round", sans-serif;
  text-align: center;
  font-size: 36px;
  color: #065125;
  font-weight: bold;
}

a {
  color: #065125;
}

#info-paragraphs {
  grid-area: info;

  padding: 1em;
  /* color: white; */
}

#second-info {
  grid-area: second-info;
  /* display: inline-flex;
  justify-content: center; */
  padding: 1em;
  /* color: white; */
}

#app-reviews {
  grid-area: reviews;
  padding: 1em;
}

#register {
    background-color: #dda033;
    border: none;
    color:#e0d8c3;
    text-decoration: none;
}
</style>
