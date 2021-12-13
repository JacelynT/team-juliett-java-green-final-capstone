<template>
  <div id="footer-container">&#169; {{copyText}} </div>
</template>

<script>
export default {
    name: 'main-footer',
    data() {
        return {
            copyText: 'Bookaroo, 2021. All rights reserved.'
        }
    }

}
</script>

<style scoped>
#footer-container{
    margin: 2rem 0 0 2rem;
    color: #065125;
}
</style>