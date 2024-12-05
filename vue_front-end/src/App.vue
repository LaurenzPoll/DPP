<template>
  <div id="app" class="app-layout">
    <!-- 左侧侧边栏 -->
    <Sidebar />
    <!-- 右侧内容区域 -->
    <div class="main-content">
      <router-view /> <!-- 动态切换路由内容 -->
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
  margin-left: 200px; /* 确保内容不与侧边栏重叠 */
}
</style>