const app = new Vue({
                el:'#tarjet',
                data:{
                    TarjetaRequest: {
                        id_usuario : localStorage.getItem("usuario_id"),
                    },
                    confirm: false,
                    PagoTarRequest: {
                        id_tar:0,
                    },
                    TarjetaRequest2:{
                        nro_tar:0,
                    },
                    pago: false,

                },
                methods:{
                    post1: function(event){
                        axios.post('/pagartarjeta',this.TarjetaRequest).then(response =>(this.confirm = response.data));
                        //axios.post('/obtenerid',this.TarjetaRequest2).then(response =>(this.PagoTarRequest.id_tar = response.data));

                    },
                    post2: function(event){
                        axios.post('/realizarpago',this.PagoTarRequest).then(response =>(this.pago = response.data));

                    },
                    post3:function(){
                        localStorage.setItem("pago","true");
                    }


                }
});