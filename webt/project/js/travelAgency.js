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
            },
            plane: {
                image: new Image(),
                x: 5,
                y: 20
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
        animatePlane() {
            const ctx = document.getElementById("canvas").getContext("2d");

            // Start point
            ctx.beginPath()
            ctx.arc(6, 20 + 32, 5, 0, 2 * Math.PI);
            ctx.fill();

            // Destination point
            ctx.beginPath()
            ctx.arc(225, 20 + 32, 5, 0, 2 * Math.PI);
            ctx.fill();

            // Move plane
            prevX = this.plane.x;
            prevY = this.plane.y;
            ctx.clearRect(this.plane.x, this.plane.y, 64, 64);
            if (this.plane.x < 225) {
                this.plane.x += 1;
            }
            if (this.plane.x < 60) {
                this.plane.y -= 0.5;
            }
            if (this.plane.x > 170 && this.plane.x < 225) {
                this.plane.y += 0.5;
            }

            // Add route after plane
            ctx.strokeStyle = "grey";
            ctx.drawImage(this.plane.image, this.plane.x, this.plane.y, 64, 64);
            ctx.beginPath()
            ctx.moveTo(prevX, prevY + 32);
            ctx.lineTo(this.plane.x, this.plane.y + 32);
            ctx.stroke();

            // restart animation
            if (this.plane.x > 224) {
                setTimeout(() => {
                    ctx.clearRect(0, 0, 300, 74);
                    this.plane.x = 5;
                    this.plane.y = 20;
                }, 1000);
            }
            setTimeout(() => {
                this.animatePlane();
            }, 50);
        }
    },
    mounted() {
        const defaultDate = new Date();
        defaultDate.setDate(defaultDate.getDate() + 7);
        this.travelplan.startDate = formatDate(defaultDate);

        defaultDate.setDate(defaultDate.getDate() + 1);
        this.travelplan.endDate = formatDate(defaultDate);

        this.plane.image.src = "./img/plane.png";
        this.animatePlane();
    }
}).mount('#app');