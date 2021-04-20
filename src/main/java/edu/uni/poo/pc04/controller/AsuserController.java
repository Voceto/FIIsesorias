package edu.uni.poo.pc04.controller;

import edu.uni.poo.pc04.bean.AsesorResponse;
import edu.uni.poo.pc04.bean.HorarioAsesorResponse;
import edu.uni.poo.pc04.request.AsuserRequest;
import edu.uni.poo.pc04.request.IdRequest;
import edu.uni.poo.pc04.request.UsuarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


@RestController
public class AsuserController {
    @Autowired
    JdbcTemplate template;
    @PostMapping("/validarp")
    public String inicioSesionp(@RequestBody AsuserRequest r) throws Exception{
        Connection connn = template.getDataSource().getConnection();
        String sql = "SELECT COUNT(*) FROM ASESOR WHERE CORREO=? AND TELEFONO=?";
        PreparedStatement pst = connn.prepareStatement(sql);
        pst.setString(1,r.getCorreo());
        pst.setInt(2,Integer.parseInt(r.getTelefono()));
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
    @PostMapping("/loginp")
    public Integer usuarioIdp(@RequestBody AsuserRequest r)throws Exception{
        Connection connn = template.getDataSource().getConnection();
        String sql = "SELECT COUNT(*) FROM ASESOR WHERE CORREO=? AND TELEFONO=?";
        String sql2 = "SELECT * FROM ASESOR WHERE CORREO=? AND TELEFONO=?";
        PreparedStatement pst = connn.prepareStatement(sql);
        PreparedStatement pst2 = connn.prepareStatement(sql2);
        pst.setString(1,r.getCorreo());
        pst.setInt(2,Integer.parseInt(r.getTelefono()));
        pst2.setString(1,r.getCorreo());
        pst2.setInt(2,Integer.parseInt(r.getTelefono()));
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
    @PostMapping("/cursosAsesor")
    public ArrayList<HorarioAsesorResponse> cursosAsesor(@RequestBody IdRequest id) throws Exception{
        Integer i = Integer.parseInt(id.getId());
        ArrayList<HorarioAsesorResponse> a = new ArrayList<>();
        Connection conn = template.getDataSource().getConnection();
        String sql = "SELECT C.NOMBRE,H.FECHA,H.HORA_INICIO,H.HORA_FIN,H.COSTO,H.LINK_SALA  FROM CURSO C,HORARIO H WHERE H.ID_ASESOR=? AND C.ID = H.ID_CURSO";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1,i);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            a.add(new HorarioAsesorResponse(rs.getString(1),rs.getDate(2),rs.getTimestamp(3),rs.getTimestamp(4),rs.getFloat(5),rs.getString(6)));
        }
        rs.close();
        pst.close();
        conn.close();
        return a;
    }
    @PostMapping("/datosAsesor")
    public AsesorResponse datosAsesor(@RequestBody IdRequest i)throws Exception{
        Integer id = Integer.parseInt(i.getId());
        Connection conn= template.getDataSource().getConnection();
        String sql = "SELECT NOMBRE,APELLIDO,TELEFONO,CORREO FROM ASESOR WHERE ID =?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1,id);
        ResultSet rs = pst.executeQuery();
        rs.next();
        AsesorResponse a = new AsesorResponse(rs.getString(1),rs.getString(2),rs.getString(4),rs.getInt(3));
        rs.close();
        pst.close();
        conn.close();
        return a;
    }
}
