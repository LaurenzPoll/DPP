<template>
  <div class="sidebar">
    <ul>
      <li>
        <router-link to="/" class="link" active-class="active">🏠 Home</router-link>
      </li>
      <li>
        <router-link to="/updateform" class="link" active-class="active">📝 Form</router-link>
      </li>
      <li>
        <router-link to="/quickscan-results" class="link" active-class="active">📊 QuickScan results</router-link>
      </li>
      <li>
        <router-link to="/information" class="link" active-class="active">ℹ️ Information</router-link>
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
  width: 180px;
  background-color: #f8f9fa;
  padding: 20px;
  height: 100vh;
  position: fixed;
  top: 0;
  left: 0;
  box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
  border-right: 1px solid #ddd;
}

.sidebar ul {
  list-style-type: none;
  padding: 0;
  margin: 0;
}

.sidebar li {
  margin-bottom: 15px;
}

.sidebar .link {
  text-decoration: none;
  color: #333;
  font-weight: 500;
  display: block;
  padding: 10px 15px;
  border-radius: 4px;
  transition: background-color 0.3s, color 0.3s;
}

.sidebar .link:hover {
  background-color: #e9ecef;
  color: #000;
}

.sidebar .active {
  background-color: #d6d8db;
  color: #000;
  font-weight: 600;
}
</style>
