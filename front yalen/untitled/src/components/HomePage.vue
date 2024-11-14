<template>
  <div class="homepage">
    <!-- 工具简介 -->
    <section class="intro">
      <h1>DPP 快速扫描工具</h1>
      <p>欢迎使用DPP快速扫描工具！本工具旨在帮助LFP电池公司快速评估其在DPP合规性方面的准备情况。</p >
      <p>通过简化的扫描流程，您可以获取差距分析，明确需要改进的具体领域。</p >
    </section>

    <!-- 导航菜单 -->
    <nav class="navigation">
      <ul>
        <li><router-link to="/form">填写表单</router-link></li>
        <li><router-link to="/quickscan-results">查看快速扫描结果</router-link></li>
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