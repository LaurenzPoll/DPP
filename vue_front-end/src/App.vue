<template>
  <div id="app" class="app-layout">

    <Sidebar />
   
    <div class="main-content">
      <router-view /> 
    </div>
  </div>
</template>

<script>
import Sidebar from './components/Sidebar.vue';

export default {
  name: 'App',
  components: {
    Sidebar,
  },
};
</script>

<style>
.app-layout {
  display: flex;
  height: 100vh;
}

.main-content {
  flex: 1;
  padding: 20px;
  margin-left: 200px; 
}
</style>
