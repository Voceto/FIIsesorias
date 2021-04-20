const app = new Vue({

                    el: '#listaalumnos',
                    data:{
                        alumnos:[],
                        },

                    methods:{
                        listar:function(){
                            axios.post('/listaalumnos').then(response=>(this.universidades=response.data));
                        },
                        elegirUniv:function(){
                            this.inscripcion=false;
                            axios.post('/getAreaAcademica',{nombre:this.horarioRequest.universidad}).then(response=>(this.areasAca=response.data));
                            this.areaf=true;
                            this.verHorarios=false;
                            this.horarioRequest.areaAca="";
                            },
                        elegirAreaAcademica:function(){
                            this.inscripcion=false;
                            axios.post('/getCursos',{nombre:this.horarioRequest.areaAca}).then(response=>(this.cursos=response.data));
                            this.cursof=true;
                            this.horarioRequest.curso="";
                            this.verHorarios=false;
                        },
                        buscarHorarios:function(){
                            this.inscripcion=false;
                            axios.post('/horarios_disp',this.horarioRequest).then(response =>(this.horarios = response.data));
                            this.verHorarios=true;
                        },
                                    datosUsuario: function(event){

                                                                    axios.post('/datos_usuario',{id:localStorage.getItem("usuario_id")}).then(response =>(this.datos_usuario = response.data));
                                                                    this.informacion=false;
                                                                    this.team = false;
                                                                    this.contacto=false;
                                                                    this.usuario=true;
                                                                     },
                                 guardarCurso:function(){
                                        localStorage.setItem("horario_id",this.horario_id);
                                        this.inscripcion=true;
                                 },

                              },

});