import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "@/views/HomeView";
import MateView from "@/views/MateView";
import MemberView from "@/views/MemberView";

Vue.use(VueRouter);

const routes = [
    {
        path: "/",
        name: "main",
        component: HomeView,
    },
    {
        path: "/mate",
        name: "mate",
        component: MateView,
        redirect: "/mate/list",
        children: [
            {
                path: "list",
                name: "matelist",
                component: () => import("@/components/mate/MateList"),
            },
            {
                path: "write",
                name: "matewrite",
                // beforeEnter: onlyAuthUser,
                component: () =>
                    import(
                        /* webpackChunkName: "mate" */ "@/components/mate/MateWrite"
                    ),
            },
            {
                path: "detail/:mateno",
                name: "matedetail",
                // beforeEnter: onlyAuthUser,
                component: () =>
                    import(
                        /* webpackChunkName: "mate" */ "@/components/mate/MateDetail"
                    ),
            },
            {
                path: "modify/:mateno",
                name: "matemodify",
                // beforeEnter: onlyAuthUser,
                component: () =>
                    import(
                        /* webpackChunkName: "mate" */ "@/components/mate/MateModify"
                    ),
            },
            {
                path: "delete/:mateno",
                name: "matedelete",
                component: () =>
                    import(
                        /* webpackChunkName: "mate" */ "@/components/mate/MateDelete"
                    ),
            },
        ],
    },
    {
        path: "/member",
        name: "member",
        component: MemberView,
        children: [
            {
                path: "login",
                name: "login",
                component: () => import("@/components/member/TheLogin"),
            },
            {
                path: "register",
                name: "register",
                component: () => import("@/components/member/TheRegister"),
            },
        ],
    },
    // {
    //     path: "/about",
    //     name: "about",
    //     // route level code-splitting
    //     // this generates a separate chunk (about.[hash].js) for this route
    //     // which is lazy-loaded when the route is visited.
    //     component: () =>
    //         import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
    // },
];

const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes,
});

export default router;
