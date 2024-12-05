<template>
  <div class="quick-scan-result">
    <!-- 顶部标识行 -->
    <header class="header">
      <span class="title">DPP</span>
    </header>

    <!-- 导航栏 -->
    <nav class="navigation">
      <ul>
        <li>Battery Base Information</li>
        <li>Battery Recycle and Reuse</li>
        <li>Battery Safety and Sustainability</li>
      </ul>
    </nav>

    <!-- 内容区域 -->
    <section class="content">
      <div class="text-area">
        <textarea v-model="textAreaValue" placeholder="Enter additional information..."></textarea>
        <div class="icons">
          <i @click="refreshData" class="icon-refresh">🔄</i>
          <i @click="clearText" class="icon-delete">❌</i>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  name: 'QuickScanResults'
};
</script>

<style scoped>
.text-area {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.text-area textarea {
  width: 80%;
  height: 100px;
  padding: 10px;
  border-radius: 5px;
  border: 1px solid #ccc;
}

.icons {
  display: flex;
  gap: 10px;
}

.icon-refresh, .icon-delete {
  cursor: pointer;
  font-size: 1.5em;
}
</style>