if(!localStorage.getItem("sesion")){
    localStorage.setItem("sesion","no iniciada");
}
const app = new Vue({

                    el: '#loginp',
                    data:{
                        contador:0,
                        informacion:true,
                        team:false,
                        contacto:false,
                        sesion: localStorage.getItem("sesion"),
                        id_usuario:0,
                        asuserRequest:{},
                        },
                    methods:{
                                ingresar: function(event){
                                axios.post('/validarp',this.asuserRequest).then(response =>(this.sesion = response.data));
                                axios.post('/loginp',this.asuserRequest).then(response =>(this.id_usuario = response.data));


                                 },
                                 guardarId:function(event){
                                    localStorage.setItem("sesion",this.sesion);
                                    localStorage.setItem("asesor_id",this.id_usuario.toString());
                                 }

                              }
});