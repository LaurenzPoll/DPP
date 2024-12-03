import { createApp } from 'vue';
import App from './App.vue';
import router from './router/index.js'; // 引入刚刚创建的路由配置



createApp(App)
    .use(router) // 使用 Vue Router
    .mount('#app');