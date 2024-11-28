<template>
  <div class="homepage">
    <Sidebar />
    <div class="content">
      <h1>Welcome to the Home page</h1>
      <p>This is the home page of DPP Quick Scan Tool. </p >
      <p> Please select the page from the left menu to continue.</p >
    </div>
  </div>
</template>

<script>
import Sidebar from './Sidebar.vue';

export default {
  name: 'HomePage',
  components: {
    Sidebar,
  },
};
</script>

<style scoped>
.homepage {
  display: flex;
  height: 100vh;
}

.content {
  flex: 1;
  padding: 20px;
}

.content h1 {
  font-size: 24px;
  margin-bottom: 10px;
}

.content p {
  font-size: 16px;
}
</style>