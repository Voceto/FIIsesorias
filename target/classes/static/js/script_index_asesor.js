if(!localStorage.getItem("sesion")){
    localStorage.setItem("sesion","no iniciada");
}
if(!localStorage.getItem("asesor_id")){
    localStorage.setItem("asesor_id","-1");
}
const app = new Vue({

                    el: '#index',
                    data:{
                        team:false,
                        contacto:false,
                        verhorarios:false,
                        usuario:false,
                        mis_alumnos:false,
                        asesor_id:localStorage.getItem("asesor_id"),
                        sesion : localStorage.getItem("sesion"),
                        usuarRquest:{},
                        datos_usuario:{ nombre:' ',apellido:' ',correo:'',telefono:0},
                        asesores:[],
                        horarios:[],
                        asesorias:[],
                        listaalumnos:[],
                        },
                    methods:{    
                                 cerrarSesion:function(){
                                       localStorage.setItem("sesion","no iniciada");
                                       this.sesion="no iniciada";
                                       this.usuario=false;
                                       this.mis_alumnos=false;
                                       this.verhorarios=false;
                                       },
                                 verTeam:function(){
                                        axios.get('/getTeam').then(response=>(this.asesores=response.data));
                                        this.mis_alumnos=false;
                                        this.verhorarios=false;
                                        this.team = true;
                                        this.contacto=false;
                                        this.usuario=false;
                                       
                                        },
                                 verContacto:function(){
                                        this.mis_alumnos=false;
                                        this.verhorarios=false;
                                        this.team = false;
                                        this.contacto=true;
                                        this.usuario=false;
                                       
                                        },
                                verHorarios:function(event){
                                    axios.post('/cursosAsesor',{id:localStorage.getItem("asesor_id")}).then(response=>(this.horarios=response.data));
                                    this.team = false;
                                    this.contacto=false;
                                    this.usuario=false;
                                    this.verhorarios=true;
                                    this.mis_alumnos=false;
                                    
                                },
                                    datosUsuario: function(event){
                                        axios.post('/datosAsesor',{id:localStorage.getItem("asesor_id")}).then(response =>(this.datos_usuario = response.data));
                                        this.team = false;
                                        this.contacto=false;
                                        this.usuario=true;
                                        this.mis_alumnos=false;
                                        this.verhorarios=false;
                                                                   
                                                                     },
                                verAlumnos:function(event){
                                    axios.post('/listaalumnos',{id:localStorage.getItem("asesor_id")}).then(response => (this.listaalumnos = response.data));
                                    this.team = false;
                                    this.contacto=false;
                                    this.usuario=false;
                                    this.verhorarios=false;
                                    this.mis_alumnos=true;
                                     
                                }
                              }
});
