package edu.uni.poo.pc04.controller;

import edu.uni.poo.pc04.bean.RecomendacionResponse;
import edu.uni.poo.pc04.request.IdRequest;
import edu.uni.poo.pc04.request.RecomendacionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@RestController
public class RecomendacionController {
    @Autowired
    JdbcTemplate template;
    @PostMapping("/dejarRecomendacion")
    public String dejarRecomendacion(@RequestBody RecomendacionRequest r )throws Exception{

        Connection conn = template.getDataSource().getConnection();
        PreparedStatement pst =conn.prepareStatement("INSERT INTO RECOMENDACION(ID_ASESORIA,COMENTARIO) VALUES(?,?)");
        pst.setInt(1,r.getId_asesoria());
        pst.setString(2,r.getComentario());
        pst.executeUpdate();
        pst.close();
        conn.close();
        return "correcto";
    }
    @PostMapping("/recuperarRecom")
    public ArrayList<RecomendacionResponse> getRecom(@RequestBody IdRequest id)throws Exception{
        ArrayList<RecomendacionResponse> r = new ArrayList<>();
        Connection conn = template.getDataSource().getConnection();
        String sql = "SELECT R.COMENTARIO FROM RECOMENDACION R,ASESORIA A,HORARIO H WHERE R.ID_ASESORIA=A.ID AND A.ID_HORARIO=H.ID AND H.ID_ASESOR =?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1,Integer.parseInt(id.getId()));
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            r.add(new RecomendacionResponse(rs.getString(1)));
        }
        rs.close();
        pst.close();
        conn.close();
        return r;
    }
}
