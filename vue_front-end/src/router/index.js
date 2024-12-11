import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../components/HomePage.vue';
import QuickScanResults from '../components/QuickScanResults.vue';
import UpdateForm from "@/components/UpdateForm.vue";

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
        path: '/updateForm',
        name: 'UpdateForm',
        component: UpdateForm
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
