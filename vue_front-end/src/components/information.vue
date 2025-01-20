<template>
  <div class="content">
    <h1>Digital Product Passport Quickscan</h1>
    <p>A tool to help companies assess their compliance with upcoming EU Digital Product Passport (DPP) regulations for the battery sector.</p>

    <div class="section">
      <h2>Key Features</h2>
      <ul>
        <li><strong>Quick Compliance Assessment</strong> – Identify gaps in DPP requirements.</li>
        <li><strong>Actionable Insights</strong> – Generate reports with basic recommendations for required and/or voluntary data.</li>
        <li><strong>User-Friendly</strong> – Simple and intuitive design.</li>
        <li><strong>Secure Data Handling</strong> – No data is stored on our side.</li>
      </ul>
    </div>

    <div class="section">
      <h2>How It Works</h2>
      <ul>
        <li>Users inputs available battery data.</li>
        <li>Tool analyzes compliance gaps.</li>
        <li>Generates a structured report.</li>
      </ul>
    </div>

    <div class="section">
      <h2>Scope</h2>
      <ul>
        <li><strong>Included:</strong> gap analysis, basic reporting.</li>
        <li><strong>Not Included:</strong> ERP integration (future scope), re-use of previously filled in form</li>
      </ul>
    </div>

    <div class="section">
      <h2>Technology</h2>
      <ul>
        <li><strong>Frontend:</strong> Vue.js</li>
        <li><strong>Backend:</strong> Java Spring Boot</li>
      </ul>
    </div>

    <div class="section">
      <h2>Why Use This Tool?</h2>
      <ul>
        <li>Save time with automated compliance checks.</li>
        <li>Understand exactly what’s missing for DPP readiness.</li>
        <li>Stay ahead of EU regulations and industry standards.</li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'GuidePage',
};
</script>

<style scoped>
.content {
  padding: 20px;
}
</style>