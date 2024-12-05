<template>
  <div class="sidebar">
    <ul>
      <li>
        <router-link to="/">Home Page</router-link>
      </li>
      <li>
        <router-link to="/form">Form Page</router-link>
      </li>
      <li>
        <router-link to="/guide">Guide Page</router-link>
      </li>
      <li>
        <router-link to="/information">Information Page</router-link>
      </li>
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
  position: fixed; /* 固定侧边栏在页面左侧 */
  top: 0;
  left: 0;
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