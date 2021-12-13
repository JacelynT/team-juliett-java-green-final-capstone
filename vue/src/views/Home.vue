<template>
  <div class="home">
    <div class="hero-image">
      <div class="hero-text">
        <h1>Reading is the BEST!</h1>
        <button>Get Started!</button>
      </div>
    </div>
    <section class= "bottom-info">
      <div id="info-paragraphs">
      <p>
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc sed velit dignissim sodales ut eu sem. Elementum pulvinar etiam non quam lacus suspendisse. Morbi leo urna molestie at elementum eu facilisis. Senectus et netus et malesuada fames ac turpis egestas sed. Ullamcorper morbi tincidunt ornare massa eget egestas purus viverra. Pharetra convallis posuere morbi leo urna. Duis at consectetur lorem donec massa sapien. Tempus iaculis urna id volutpat lacus laoreet non curabitur gravida. Pharetra sit amet aliquam id diam maecenas ultricies mi. Sed euismod nisi porta lorem. Mauris pellentesque pulvinar pellentesque habitant morbi. Consectetur adipiscing elit ut aliquam purus sit. </p>

      </div>
      <div id="second-info">
<p>
Morbi tincidunt ornare massa eget egestas purus viverra. Volutpat lacus laoreet non curabitur gravida arcu ac tortor dignissim. Dolor sit amet consectetur adipiscing elit ut aliquam purus sit. Sit amet nulla facilisi morbi. Lacus laoreet non curabitur gravida arcu ac. Natoque penatibus et magnis dis. Bibendum arcu vitae elementum curabitur. Consequat id porta nibh venenatis cras sed. Amet porttitor eget dolor morbi. Facilisi cras fermentum odio eu feugiat pretium nibh ipsum. Orci phasellus egestas tellus rutrum tellus pellentesque eu tincidunt. Duis tristique sollicitudin nibh sit amet commodo nulla facilisi. Egestas dui id ornare arcu odio ut sem. Nibh venenatis cras sed felis eget velit aliquet. Tristique et egestas quis ipsum suspendisse.
      </p>

      </div>


    </section>
    
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
    height: 70vh;
    width: 100vw;
}

.hero-text{
 text-align: left;
  position: absolute;
  top: 15%;
  left: 25%;
  transform: translate(-50%, -50%);
  font-family: 'Varela Round', sans-serif;
}
h1 {
  font-family: 'Varela Round', sans-serif;
  font-weight: bolder;
  color:  #e2532f;
}

button {
    background-color: #dda033;
    border: none;
    color:#e0d8c3;
    padding: 5px 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 2em;
    font-family: "Noto Serif", Georgia, serif;
    font-weight: normal;
}

.bottom-info {
  background-color: #e0d8c3;
  font-family: "Noto Serif", Georgia, serif;
  font-size: 10px;
  color: #065123;
  padding: 20px;
}
</style>
