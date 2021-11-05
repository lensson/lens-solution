import { createRouter, createWebHistory } from "vue-router";


import HomeIndex from '@/views/Home';

const routes = [
  {
    path: '/',
    component: HomeIndex,
  },

  { path: '/404', component: () => import('@/views/404') },
  { path: '/500', component: () => import('@/views/500') },
  { path: '/502', component: () => import('@/views/502') },
  { path: '/*', component: () => import('@/views/404') }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
