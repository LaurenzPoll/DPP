import { createRouter, createWebHistory } from 'vue-router'; // 确保正确引入 Vue Router

import HomePage from '../components/HomePage.vue';
import Form from '../components/Form.vue';
import QuickScanResults from '../components/QuickScanResults.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: HomePage
  },
  {
    path: '/form',
    name: 'Form',
    component: Form
  },
  {
    path: '/quickscan-results',
    name: 'QuickScanResults',
    component: QuickScanResults
  }
];

const router = createRouter({
  history: createWebHistory(), // 创建 Web 历史记录
  routes
});

export default router;