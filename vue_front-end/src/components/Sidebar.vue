<template>
  <div class="sidebar">
    <ul>
      <li><router-link to="/form">Form Page</router-link></li>
      <li><router-link to="/guide">Guide Page</router-link></li>
      <li><router-link to="/information">Information Page</router-link></li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'Sidebar',
};
</script>

<style scoped>
.sidebar {
  width: 200px;
  background-color: #f0f0f0;
  padding: 20px;
  height: 100vh;
}

.sidebar ul {
  list-style-type: none;
  padding: 0;
}

.sidebar li {
  margin-bottom: 10px;
}

.sidebar a {
  text-decoration: none;
  color: #333;
}

.sidebar a:hover {
  color: #007BFF;
}
</style>