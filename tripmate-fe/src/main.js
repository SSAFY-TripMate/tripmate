import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

import "@/api/lib/fontAwesomeIcon.js";
import "@/api/lib/vueBootstrap.js";
import "@/api/lib/datepickerUi.js";
import "@/api/lib/vueFileAgent.js";

Vue.config.productionTip = false;

new Vue({
    router,
    store,
    render: (h) => h(App),
}).$mount("#app");
