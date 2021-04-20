const app= new Vue({
    el:'#paypal_confi',
    data:{
        paypal:{},
        pago: false,
    },
    methods:{
        confirmar: function(event){
            axios.post("/registroCompraPaypal",this.paypal).then(response=>(this.pago=response.data));
            localStorage.setItem("pago","true");
        },
    }
});