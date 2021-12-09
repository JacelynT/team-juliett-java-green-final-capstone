<template>
  <div id="footer-container">&#169; {{copyText}} </div>
</template>

<script>
export default {
    name: 'main-footer',
    data() {
        return {
            copyText: 'Reading Tracker App, 2021. All rights reserved.'
        }
    }

}
</script>

<style scoped>
#footer-container{
    margin-top: 2rem;
}
</style>