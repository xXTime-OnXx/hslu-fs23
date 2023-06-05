function formatDate(date) {
    return date.toISOString().split('T')[0];
}

Vue.createApp({
    data() {
        return {
             travelplan: {
                firstname: undefined,
                lastname: undefined,
                email: undefined,
                destination: undefined,
                startDate: undefined,
                endDate: undefined
             }
        }
    },
    methods: {
        validEmail() {
            if (!this.travelplan.email) {
                return false;
            }
            return this.travelplan.email.match(/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/);
        },
        validStartDate() {
            if (!this.travelplan.startDate) {
                return false;
            }
            const validDate = new Date();
            validDate.setHours(0, 0, 0, 0);
            validDate.setDate(validDate.getDate() + 7);
            const startDate = new Date(this.travelplan.startDate);
            return startDate >= validDate;
        },
        validEndDate() {
            if (!this.travelplan.endDate) {
                return false;
            }
            const startDate = new Date(this.travelplan.startDate);
            const endDate = new Date(this.travelplan.endDate);
            return endDate > startDate;
        },
        validForm() {
            console.log('form validator');
            return false;
        }
    },
    mounted() {
        const defaultDate = new Date();
        defaultDate.setDate(defaultDate.getDate() + 7);
        this.travelplan.startDate = formatDate(defaultDate);

        defaultDate.setDate(defaultDate.getDate() + 1);
        this.travelplan.endDate = formatDate(defaultDate);
    }
}).mount('#app');