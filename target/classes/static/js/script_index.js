if(!localStorage.getItem("sesion")){
    localStorage.setItem("sesion","no iniciada");
}
if(!localStorage.getItem("usuario_id")){
    localStorage.setItem("usuario_id","-1");
}
const app = new Vue({

                    el: '#index',
                    data:{
                        informacion:true,
                        team:false,
                        contacto:false,
                        usuario:false,
                        mis_asesorias:false,
                        usuario_id:localStorage.getItem("usuario_id"),
                        sesion : localStorage.getItem("sesion"),
                        usuarRquest:{},
                        datos_usuario:{ nombre:' ',apellido:' ',dni:0,telefono:0,nombre_universidad:'',email:'',username:''},
                        asesores:[],
                        asesorias:[],
                        },
                    methods:{    verInfo:function(){
                                        this.informacion=true;
                                        this.team = false;
                                        this.contacto=false;
                                        this.usuario=false;
                                        this.mis_asesorias=false;
                                        },
                                 cerrarSesion:function(){
                                       localStorage.setItem("sesion","no iniciada");
                                       this.sesion="no iniciada";
                                       this.usuario=false;
                                       this.mis_asesorias=false;
                                       },
                                 verTeam:function(){
                                        axios.get('/getTeam').then(response=>(this.asesores=response.data));
                                        this.informacion=false;
                                        this.team = true;
                                        this.contacto=false;
                                        this.usuario=false;
                                        this.mis_asesorias=false;
                                        },
                                 verContacto:function(){
                                        this.informacion=false;
                                        this.team = false;
                                        this.contacto=true;
                                        this.usuario=false;
                                        this.mis_asesorias=false;
                                        },
                                    datosUsuario: function(event){

                                                                    axios.post('/datos_usuario',{id:localStorage.getItem("usuario_id")}).then(response =>(this.datos_usuario = response.data));
                                                                    this.informacion=false;
                                                                    this.team = false;
                                                                    this.contacto=false;
                                                                    this.usuario=true;
                                                                    this.mis_asesorias=false;
                                                                     },
                                    verAsesorias:function(event){
                                            axios.post('/datosAsesorias',{id:localStorage.getItem("usuario_id")}).then(response=>(this.asesorias=response.data));
                                                                                                                this.informacion=false;
                                                                                                                this.team = false;
                                                                                                                this.contacto=false;
                                                                                                                this.usuario=false;
                                                                                                                this.mis_asesorias=true;

                                    },
                              }
});
