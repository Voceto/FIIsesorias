package edu.uni.poo.pc04.controller;


import edu.uni.poo.pc04.request.AsesorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;

@RestController
public class AsesorControler {
    @Autowired
    JdbcTemplate template;
    @PostMapping ("/registrop")
    public Boolean regases(@RequestBody AsesorRequest a) throws Exception{
        Connection conn = template.getDataSource().getConnection();
        String sql = "INSERT INTO ASESOR (NOMBRE,APELLIDO,TELEFONO,CORREO,CALIFICACION) VALUES (?,?,?,?,0)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,a.getNombre());
        pst.setString(2,a.getApellido());
        pst.setInt(3,Integer.parseInt(a.getTelefono()));
        pst.setString(4,a.getCorreo());
        pst.executeUpdate();
        pst.close();
        conn.close();
        return true;

    }

}
