
const app=new Vue({
        el:"#efectivo",
        data:{
            efectivo:{},
            pago:false,
        },
        methods:{
            pagocompleto: function(event){
                axios.post("/registarpagoefectivo",this.efectivo).then(response=>(this.pago=response.data));
                console.log("codigo zip: #######");
                localStorage.setItem("pago","true");
            },
            pagoabortado: function(event){
                localStorage.setItem("pago","false");
            }

        }



});