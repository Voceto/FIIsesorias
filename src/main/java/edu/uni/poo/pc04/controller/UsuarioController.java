package edu.uni.poo.pc04.controller;

import edu.uni.poo.pc04.bean.AsesoriaResponse;
import edu.uni.poo.pc04.bean.HorarioResponse;
import edu.uni.poo.pc04.bean.Usuario;
import edu.uni.poo.pc04.request.IdRequest;
import edu.uni.poo.pc04.request.UsuarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@RestController
public class UsuarioController {
    @Autowired
    JdbcTemplate template;
    @PostMapping("/validar")
    public String inicioSesion(@RequestBody UsuarioRequest r) throws Exception{
        Connection connn = template.getDataSource().getConnection();
        String sql = "SELECT COUNT(*) FROM USUARIO WHERE USERNAME=? AND CONTRASENIA=?";
        PreparedStatement pst = connn.prepareStatement(sql);
        pst.setString(1,r.getUsername());
        pst.setString(2,r.getContrasenia());
        ResultSet rs = pst.executeQuery();
        rs.next();
        Integer cantReg = rs.getInt(1);
        rs.close();
        pst.close();
        connn.close();
        if(cantReg==1){
            return "iniciada";
        }else{
            return "no iniciada";
        }
    }
    @PostMapping("/ingresar")
    public Integer usuarioId(@RequestBody UsuarioRequest r)throws Exception{
        Connection connn = template.getDataSource().getConnection();
        String sql = "SELECT COUNT(*) FROM USUARIO WHERE USERNAME=? AND CONTRASENIA=?";
        String sql2 = "SELECT * FROM USUARIO WHERE USERNAME=? AND CONTRASENIA=?";
        PreparedStatement pst = connn.prepareStatement(sql);
        PreparedStatement pst2 = connn.prepareStatement(sql2);
        pst.setString(1,r.getUsername());
        pst.setString(2,r.getContrasenia());
        pst2.setString(1,r.getUsername());
        pst2.setString(2,r.getContrasenia());
        ResultSet rs = pst.executeQuery();
        rs.next();
        Integer cantReg = rs.getInt(1);
        Integer i=0;
        if(cantReg==1){
            rs = pst2.executeQuery();
            rs.next();
            i = rs.getInt(1);

        }else{
            i= -1;
        }
        rs.close();
        pst.close();
        connn.close();
        return i;
    }
    @PostMapping("/datos_usuario")
    public Usuario datosUsuario(@RequestBody IdRequest s)throws Exception{
        Integer i = Integer.parseInt(s.getId());
        Connection connn = template.getDataSource().getConnection();
        String sql = "SELECT U.NOMBRE,U.APELLIDO,U.DNI,U.TELEFONO,N.NOMBRE,U.EMAIL,U.USERNAME FROM USUARIO U,UNIVERSIDAD N  WHERE U.ID=? AND U.ID_UNIVERSIDAD=N.ID;";
        PreparedStatement pst = connn.prepareStatement(sql);
        pst.setInt(1,i);
        ResultSet rs = pst.executeQuery();
        rs.next();
        Usuario u = new Usuario(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7) );
        rs.close();
        pst.close();
        connn.close();
        return u;
    }
    @PostMapping("/datosAsesorias")
    public ArrayList<AsesoriaResponse> datosAsesorias(@RequestBody IdRequest s)throws Exception{
        ArrayList<AsesoriaResponse> a = new ArrayList<>();
        Integer i = Integer.parseInt(s.getId());
        Connection connn = template.getDataSource().getConnection();
        String sql = "SELECT A.ID,C.NOMBRE,E.NOMBRE,H.FECHA,H.HORA_INICIO,H.HORA_FIN,H.LINK_SALA FROM USUARIO U,ASESORIA A,HORARIO H,ASESOR E,CURSO C WHERE U.ID=? AND A.ID_ALUMNO=U.ID AND A.ID_HORARIO=H.ID AND H.ID_ASESOR=E.ID AND H.ID_CURSO=C.ID;";
        PreparedStatement pst = connn.prepareStatement(sql);
        pst.setInt(1,i);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            a.add(new AsesoriaResponse(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getTimestamp(5),rs.getTimestamp(6),rs.getDate(4),rs.getString(7)));
        }
        rs.close();
        pst.close();
        connn.close();
        return a;
    }
}
