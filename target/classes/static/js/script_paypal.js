const app = new Vue({
    el: '#paypal',
    data:{
        contador:0,
        sesion: false,
        usuarioRequest:{},
    },
    methods:{
        ingresar: function(event){
            axios.post('/validarPaypal',this.usuarioRequest).then(response=>(this.sesion=response.data));
        },
        comprar: function(event){
            window.location.replace("http://localhost:8080/pagopaypal2.html");
        }

    }


})