package edu.uni.poo.pc04.controller;

import edu.uni.poo.pc04.bean.AreasResponse;
import edu.uni.poo.pc04.bean.HorarioResponse;
import edu.uni.poo.pc04.bean.Usuario;
import edu.uni.poo.pc04.request.AreaAcadRequest;
import edu.uni.poo.pc04.request.HorarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.awt.geom.Area;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HorariosController {
    @Autowired
    JdbcTemplate template;
    @PostMapping("/horarios_disp")
    public ArrayList<HorarioResponse> horariosDisp(@RequestBody HorarioRequest h)throws Exception{
        ArrayList<HorarioResponse> l = new ArrayList<HorarioResponse>();
        Connection connn = template.getDataSource().getConnection();
        String sql = "SELECT H.ID,H.FECHA,H.HORA_INICIO,H.HORA_FIN,H.COSTO,A.NOMBRE,C.NOMBRE FROM HORARIO H,ASESOR A,CURSO C WHERE H.ID_ASESOR=A.ID AND H.ID_CURSO=C.ID AND UPPER(C.NOMBRE) = ?";
        PreparedStatement pst = connn.prepareStatement(sql);
        pst.setString(1,h.getCurso().toUpperCase());
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            l.add(new HorarioResponse(rs.getInt(1),rs.getDate(2),rs.getTimestamp(3),rs.getTimestamp(4),rs.getFloat(5),rs.getString(6),rs.getString(7)));
        }
        pst.close();
        connn.close();
        return l;
    }
    @RequestMapping("/getUniversidades")
    public ArrayList<AreasResponse> getUniversidades() throws Exception{
        Connection conn = template.getDataSource().getConnection();
        ArrayList<AreasResponse> u = new ArrayList<>();
        String sql = "SELECT NOMBRE FROM UNIVERSIDAD";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            u.add(new AreasResponse(rs.getString(1)));
        }
        rs.close();
        st.close();
        conn.close();
        return u;
    }
    @PostMapping("/getAreaAcademica")
    public ArrayList<AreasResponse> getAreas(@RequestBody AreaAcadRequest a) throws Exception{
        Connection conn = template.getDataSource().getConnection();
        ArrayList<AreasResponse> u = new ArrayList<>();
        String sql = "SELECT A.NOMBRE FROM AREA_ACADEMICA A,UNIVERSIDAD U WHERE A.ID_UNIVERSIDAD=U.ID AND U.NOMBRE=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,a.getNombre());
        ResultSet rs  = pst.executeQuery();
        while(rs.next()){
            u.add(new AreasResponse(rs.getString(1)));
        }
        rs.close();
        pst.close();
        conn.close();
        return u;
    }
    @PostMapping("/getCursos")
    public ArrayList<AreasResponse> getCursos(@RequestBody AreaAcadRequest a)throws Exception{
        Connection conn = template.getDataSource().getConnection();
        ArrayList<AreasResponse> u = new ArrayList<>();
        String sql = "SELECT C.NOMBRE FROM CURSO C,AREA_ACADEMICA A WHERE C.ID_AREA_ACADEMICA=A.ID AND A.NOMBRE=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,a.getNombre());
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            u.add(new AreasResponse(rs.getString(1)));
        }
        rs.close();
        pst.close();
        conn.close();
        return u;
    }
}
