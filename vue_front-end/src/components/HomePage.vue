<template>
  <div class="homepage">
  
    <section class="intro">
      <h1>Dpp Quick Scan Tool</h1>
      <p>Welcome to the DPP Quick Scan Tool! This tool is designed to help LFP battery companies quickly assess their readiness for DPP compliance.</p >
      <p>With a streamlined scanning process, you can get a gap analysis that identifies specific areas for improvement.</p >
    </section>

   
    <nav class="navigation">
      <ul>

        <li><router-link to="/inputForm">Input form</router-link></li>
        <li><router-link to="/quickscan-results">view the quick scan results</router-link></li>

      </ul>
    </nav>
  </div>
</template>

<script>
export default {
  name: 'HomePage',
};
</script>

<style scoped>
.content {
  padding: 20px;
}
</style>
