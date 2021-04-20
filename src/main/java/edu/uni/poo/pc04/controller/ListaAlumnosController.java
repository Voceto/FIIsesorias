package edu.uni.poo.pc04.controller;

import edu.uni.poo.pc04.bean.AlumnosResponse;
import edu.uni.poo.pc04.bean.HorarioResponse;
import edu.uni.poo.pc04.request.IdRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ListaAlumnosController {
    @Autowired
    JdbcTemplate template;
    @PostMapping("/listaalumnos")
    public List<AlumnosResponse> obtenerlista(@RequestBody IdRequest id) throws Exception{

        List<AlumnosResponse> lista = new ArrayList<>();
        Connection conn = template.getDataSource().getConnection();
        String sql = "SELECT U.NOMBRE , U.APELLIDO , U.TELEFONO , A.ID , C.NOMBRE FROM USUARIO U , ASESORIA A , CURSO C , HORARIO H WHERE H.ID_ASESOR = ?  AND H.ID_CURSO = C.ID AND H.ID = A.ID_HORARIO AND A.ID_ALUMNO = U.ID";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1,Integer.parseInt(id.getId()));
        ResultSet st = pst.executeQuery();
        while(st.next()){
            lista.add(new AlumnosResponse(st.getString(1),st.getString(2),st.getInt(3),st.getString(5),st.getInt(4)));

        }
        st.close();
        pst.close();
        conn.close();




        return lista;

    }



}
