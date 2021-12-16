<template>
  <div class="home">
    <div class="hero-image">
      <div id="hero-text-background">
        <div class="hero-text">
          <h1>Let's Read Together</h1>
          <h3>Accelerate your child's reading skills with Bookaroo, and give them the joy of reading for a lifetime.</h3>
          <button>
            <router-link id="register" v-bind:to="{ name: 'register' }"
              >Get Started!</router-link
            >
          </button>
        </div>
      </div>
    </div>
    <section class="bottom-info">
      <div id="box-1">
        <h2><i class="fas fa-smile-beam"></i> Welcome to Bookaroo</h2>
        <p>
          Reading is proven to help with the process of cognitive development
          for kids of all ages. We want to help your family make reading time
          fun and organized. Bookaroo is designed to help your family establish
          a reading routine so your kids can grow and thrive. Create an account
          today!
        </p>
      </div>
      <div id="box-2">
        <h2><i class="fas fa-book-reader"></i> Best Children's Books</h2>
        <!-- <img src="../assets/children-reading-books-scaled.jpg" alt=""> -->
        <p>
          We know your schedule is busy, so we gathered a list of the top 25
          Children's Books for you. Use this list to jumpstart your collection,
          or discover a new family favorite. Then you can easily add it to your
          Bookaroo account so your kids can start reading!
        </p>
        <div id="link-box">
          <a
            href="https://www.rd.com/list/the-best-childrens-books-ever-written/"
            >The 25 Best Children's Book Ever Written</a
          >
        </div>
      </div>
      <div id="box-3">
        <h2><i class="fas fa-question-circle"></i> Why Bookaroo?</h2>
        <p>
          Bookaroo helps you vizualize your kids reading progress with charts,
          activity and detailed information at-a-glance. Use Bookaroo to get
          quick insights about your child's reading activity so they can met
          their goals and grow!
        </p>
        <!-- <img src="../assets/clipart3483410.png" alt=""> -->
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
  background-position: 50% 100%;
  position: relative;
  height: 75vh;
  width: 100%;
}
#hero-text-background {
  background-color: white;
}
.hero-text {
  text-align: left;
  position: absolute;
  top: 40%;
  left: 23%;
  transform: translate(-50%, -50%);
  font-family: "Varela Round", sans-serif;
  background-color: rgba(255, 255, 255, 0.40);
  padding: 2.5em;
  /* border-radius: 2rem; */
}

h3 {
  max-width: 560px;
  margin: 15px 0;
}

h1 {
  font-family: "Varela Round", sans-serif;
  font-weight: bold;
  font-size: 56px;
  color: #0a7d8f;
  /* -webkit-text-stroke: .25px #e0d8c3;
   -webkit-text-fill-color: #CE401C; */
}

button {
  background-color: #ce401c;
  border: none;
  border-radius: 2rem;
  color: #e0d8c3;
  padding: 15px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 20px;
  font-family: "Varela Round", sans-serif;
  font-weight: normal;
  margin: 5px 0;
}

.bottom-info {
  font-family: "Noto Serif", Georgia, serif;
  font-size: 18px;
  /* font-weight: bold; */
  color: #333;
  padding: 2%;
  display: grid;
  grid-area: information-grid;
  grid-template-columns: 1fr 1fr 1fr;
  gap: 3em;
  grid-template-areas: "box-1 box-2 box-3";
}

.bottom-info > div {
  border: 3px solid #065125;
  /* border-radius: 1rem; */
  margin: 1em;
  box-shadow: 0px 2px 6px 1px slategrey;
}

h2 {
  font-family: "Varela Round", sans-serif;
  font-size: 36px;
  color: #065125;
  font-weight: bold;
  border-bottom: 3px solid #065125;
  margin-bottom: 3rem;
}
#link-box {
  text-align: left;
}
a {
  color: #065125;
}

#box-1 {
  grid-area: box-1;
  padding: 3rem;
  /* color: white; */
}

#box-2 {
  grid-area: box-2;
  /* display: inline-flex;
  justify-content: center; */
  padding: 3rem;
  /* color: white; */
}

#box-3 {
  grid-area: box-3;
  padding: 3rem;
}

#register {
  background-color: #ce401c;
  border: none;
  color: white;
  text-decoration: none;
}
</style>
