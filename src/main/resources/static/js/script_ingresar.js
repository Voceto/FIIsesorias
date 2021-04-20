if(!localStorage.getItem("sesion")){
    localStorage.setItem("sesion","no iniciada");
}
const app = new Vue({

                    el: '#ingresar',
                    data:{
                        contador:0,
                        informacion:true,
                        team:false,
                        contacto:false,
                        sesion: localStorage.getItem("sesion"),
                        id_usuario:0,
                        usuarioRequest:{},
                        },
                    methods:{
                                ingresar: function(event){
                                axios.post('/validar',this.usuarioRequest).then(response =>(this.sesion = response.data));
                                axios.post('/ingresar',this.usuarioRequest).then(response =>(this.id_usuario = response.data));


                                 },
                                 guardarId:function(event){
                                    localStorage.setItem("sesion",this.sesion);
                                    localStorage.setItem("usuario_id",this.id_usuario.toString());
                                 }

                              }
});