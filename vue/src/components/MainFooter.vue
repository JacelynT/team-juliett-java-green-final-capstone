<template>
    <div id="footer-container">
      <span>&#169; {{ copyText }}</span>
      <img class="social" src="../assets/twitter.png" />
      <img class="social" src="../assets/facebook.png" />
      <img class="social" src="../assets/instagram.png" />
    </div>
</template>

<script>
export default {
  name: "main-footer",
  data() {
    return {
      copyText: "Bookaroo, 2021. All rights reserved. ",
    };
  },
};
</script>

<style scoped>
#footer-container {
  text-align: center;
  margin: 2rem 0 0 2rem;
  color: #065125;
}

.social {
  max-height: 27px;
  margin-left: 3px;
  margin-right: 3px;
  margin-bottom: 4px;
  padding: 3px;
  filter: grayscale(100%);
}
</style>