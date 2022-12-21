<template>
    <div class="sidebar">
        <div class="text">
            <h4 class="d-flex justify-content-center text-light font-weight-bold" style="font-family:monospace">"E-KTP APP"</h4>
        </div>
        <div class="">
          <div id="texto" class="side">
              <router-link to="/Home" class="linked"><div class="home" >"Home"</div></router-link>
              <router-link to="/addKK" class="linked"><div class="home" >"Add Kaka"</div></router-link>
              <hr>
              <router-link to="/" class="linked"><div class="out" >"Sign out"</div></router-link>
          </div>
    </div>

  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
.sidebar {
    margin-left:5px;
    border-radius:10px 10px 0px 0px ;
    position: fixed;
    width: 200px;
    height: 98%;
    background-color: #DDFFBC;
    box-shadow: 5px 6px 5px 1px rgba(0, 0, 0, 0.1);
    
}
.text {
    padding: 20px 0px 20px 0px;
    background-color:#91C788 ;
    border-radius: 10px 10px 1px 25px;

}
#texto {
    text-align: center;
    text-decoration: none;
    padding: 10px;
    font-family: monospace;
    font-weight: bold;
    font-size: x-large;
}
.out:hover {
    margin-top: 1rem;
    border-radius: 20px;
    padding: 8px 0px 8px 0px;
    background-color: white;
}
.home {
    margin-top: 1rem;
    border-radius: 20px;
    padding: 8px 0px 8px 0px;
}
.home:hover{
    margin-top: 1rem;
    border-radius: 20px;
    padding: 8px 0px 8px 0px;
    background-color: white;
}
.router-link-active .home,
.router-link-exact-active .home {
    margin-top: 1rem;
    border-radius: 20px;
    padding: 8px 0px 8px 0px;
    background-color: white;
}

.linked {
    text-decoration: none;
}



</style>