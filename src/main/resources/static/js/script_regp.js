const app = new Vue({
                el:'#registro',
                data:{
                    profe:{},
                    aux: false,
                    confir:'',

                },
                methods:{
                    registrar:function(event){
                     axios.post("/registrop",this.profe).then(response => (this.aux = response.data));
                    },


                }
});