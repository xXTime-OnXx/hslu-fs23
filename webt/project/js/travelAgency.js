Vue.createApp({
    data() {
        return {
             travelplan: {
                firstname: '',
                lastname: '',
                email: '',
                destination: '',
                startDate: Date.now(),
                endDate: Date.now()
             }
        }
    }
}).mount('#app');