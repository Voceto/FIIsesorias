package edu.uni.poo.pc04.controller;

import edu.uni.poo.pc04.bean.CursoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@RestController
public class CursoController {
    @Autowired
    JdbcTemplate template;
    @RequestMapping("/cursosTop")
    public ArrayList<CursoResponse> getCursosTop()throws Exception{
        ArrayList<CursoResponse> c = new ArrayList<>();
        Connection conn = template.getDataSource().getConnection();
        String sql = "SELECT C.NOMBRE,C.ID,COUNT(*) AS NUMERO\n" +
                "FROM ASESORIA A\n" +
                "JOIN HORARIO H\n" +
                "ON A.ID_HORARIO = H.ID\n" +
                "JOIN CURSO C\n" +
                "ON C.ID = H.ID_CURSO\n" +
                "GROUP BY C.ID\n" +
                "ORDER BY NUMERO DESC\n" +
                "LIMIT 5";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        int i=1;
        while(rs.next()){
            c.add(new CursoResponse(i,rs.getString(1),rs.getInt(3)));
            i++;
        }
        rs.close();
        st.close();
        conn.close();
        return c;

    }
    @RequestMapping("/asesoresTop")
    public ArrayList<CursoResponse> getAsesoresTop()throws Exception{
        ArrayList<CursoResponse> a = new ArrayList<>();
        Connection conn = template.getDataSource().getConnection();
        String sql = "SELECT C.NOMBRE,C.APELLIDO,C.ID,COUNT(*) AS NUMERO\n" +
                "FROM ASESORIA A\n" +
                "JOIN HORARIO H\n" +
                "ON A.ID_HORARIO = H.ID\n" +
                "JOIN ASESOR C\n" +
                "ON C.ID = H.ID_ASESOR\n" +
                "GROUP BY C.ID\n" +
                "ORDER BY NUMERO DESC\n" +
                "LIMIT 5";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        int i=1;
        while(rs.next()){
            a.add(new CursoResponse(i,rs.getString(1)+" "+rs.getString(2),rs.getInt(4)));
            i++;
        }
        rs.close();
        st.close();
        conn.close();
        return a;
    }

}
