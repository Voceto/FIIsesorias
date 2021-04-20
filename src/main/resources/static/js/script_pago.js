if(!localStorage.getItem("pago")){
    localStorage.setItem("pago","false");
}
if(!localStorage.getItem("usuario_id")){
    localStorage.setItem("usuario_id","-1");
}
if(!localStorage.getItem("sesion")){
    localStorage.setItem("sesion","no iniciada");
}
if(!localStorage.getItem("horario_id")){
    localStorage.setItem("horario_id","-1");
}

const app = new Vue({
    el: '#pagos',
    data:{
        pago:localStorage.getItem("pago"),
        asesoriaRequest:{usuario_id:localStorage.getItem("usuario_id"),horario_id:localStorage.getItem("horario_id")},
        respuesta:" ",
    },
    methods:{
        registrarAsesoria:function(){
             axios.post('/registrarAsesoria',this.asesoriaRequest).then(response =>(this.respuesta = response.data));
             localStorage.setItem("pago","false");
        }

    }


})