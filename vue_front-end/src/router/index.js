import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../components/HomePage.vue';
import FormPage from '../components/FormPage.vue';
import GuidePage from '../components/GuidePage.vue';

const routes = [
    { path: '/', name: 'HomePage', component: HomePage },
    { path: '/form', name: 'FormPage', component: FormPage },
    { path: '/guide', name: 'GuidePage', component: GuidePage },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
