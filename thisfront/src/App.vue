<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'App',
  components: {
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale; 
  color: #2c3e50;
}

.top{
    background-color: hsl(111, 36%, 66%);
    padding: 20px 0px 5px 30px;
    border-radius:10px 10px 0px 0px ;
    font-size:larger;
    font-family: monospace;
}  

.down {
    background-color: #91C788;
    padding: 8px;
    border-radius:0px 0px 10px 10px ;
}

</style>
