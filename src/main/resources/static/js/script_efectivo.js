
const app = new Vue({
    el: "#efectivo",
    data: {
        efectivo: {nombre:"",dni:0,monto:0.0},
        pago: false,
        costo:localStorage.getItem("monto"),
    },
    methods: {
        pagocompleto: function (event) {
            axios.post("/registarpagoefectivo", this.efectivo).then(response => (this.pago = response.data));
            console.log("codigo zip: #######");
            localStorage.setItem("pago", "true");
        },
        pagoabortado: function (event) {
            localStorage.setItem("pago", "false");
        },
    },
    mounted: function () {
                console.log(this.costo);
                this.efectivo.monto = this.costo;
            },
});