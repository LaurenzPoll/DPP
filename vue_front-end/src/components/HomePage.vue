<template>
  <div class="homepage">
    <!-- 工具简介部分 -->
    <section class="intro">
      <h1>Dpp Quick Scan Tool</h1>
      <p>Welcome to the DPP Quick Scan Tool! This tool is designed to help LFP battery companies quickly assess their readiness for DPP compliance.</p >
      <p>With a streamlined scanning process, you can get a gap analysis that identifies specific areas for improvement.</p >
    </section>

    <!-- 导航菜单 -->
    <nav class="navigation">
      <ul>
        <li><router-link to="/updateForm">Input form</router-link></li>
        <li><router-link to="/quickscan-results">view the quick scan results</router-link></li>

      </ul>
    </nav>
  </div>
</template>

<script>
export default {
  name: 'HomePage'
};
</script>

<style scoped>
.homepage {
  text-align: center;
  padding: 20px;
}

.intro {
  margin: 20px 0;
}

.navigation ul {
  list-style-type: none;
  padding: 0;
}

.navigation li {
  display: inline;
  margin: 0 15px;
}

.navigation a {
  text-decoration: none;
  color: #007BFF;
  font-weight: bold;
}

.navigation a:hover {
  text-decoration: underline;
}
</style>