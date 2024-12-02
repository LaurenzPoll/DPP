import { createRouter, createWebHistory } from 'vue-router';

import HomePage from '../components/HomePage.vue';
import Form from '../components/Form.vue';
import QuickScanResults from '../components/QuickScanResults.vue';


// 如果需要使用环境变量，使用 import.meta.env 替代 process.env
// 例如，Vite 支持以 `VITE_` 为前缀的环境变量
console.log(import.meta.env.VITE_APP_NAME); // 示例：访问 VITE_APP_NAME 环境变量

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
    history: createWebHistory(import.meta.env.BASE_URL), // 使用 import.meta.env.BASE_URL
    routes
});

export default router;