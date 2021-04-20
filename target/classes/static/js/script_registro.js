const app = new Vue({
                el:'#contra',
                data:{
                    confirmado: false,
                    buton: false,
                    confir: "",
                    contrase:"",
                },
                methods:{
                    confirmame: function(){
                        if(this.contrase === this.confir){
                            this.confirmado = true;
                        }else{
                        this.confirmado = false;
                        this.buton = true;
                        }

                    },
                    boton: function(){
                      this.buton = true;

                    },

                }
});