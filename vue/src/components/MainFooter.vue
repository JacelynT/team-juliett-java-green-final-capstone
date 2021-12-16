<template>
  <div id="footer-container">
    <span>&#169; {{ copyText }} 
      </span>
      <span><i class="fab fa-twitter-square"></i> 
    <i class="fab fa-facebook-square"></i>
    <i class="fab fa-instagram-square"></i></span>
   
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
  color: #065125;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  gap: 25px;
  
}

.fa-twitter-square{
  font-size: 35px;
  padding: 5px;
 }

.fa-facebook-square{
  font-size: 35px;
  padding: 5px;
 }
 .fa-instagram-square{
  font-size: 35px;
  padding: 5px;
 }

</style>