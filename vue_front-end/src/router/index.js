import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../components/HomePage.vue';
import QuickScanResults from '../components/QuickScanResults.vue';
import inputForm from '../components/inputForm.vue';

const routes = [
    {
        path: '/',
        name: 'Home',
        component: HomePage
    },

    {
        path: '/quickscan-results',
        name: 'QuickScanResults',
        component: QuickScanResults
    },
    {
        path: '/inputForm',
        name: 'inputForm',
        component: inputForm
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
