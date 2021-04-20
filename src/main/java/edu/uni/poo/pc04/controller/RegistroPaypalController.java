package edu.uni.poo.pc04.controller;

import edu.uni.poo.pc04.request.CompraPaypalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

@RestController
public class RegistroPaypalController {
    @Autowired
    JdbcTemplate template;

    @RequestMapping("/registroCompraPaypal")
    public Boolean registro(@RequestBody CompraPaypalRequest c

    )throws Exception{
        Connection conn = template.getDataSource().getConnection();
        String sql = "INSERT INTO REGISTRO_PAYPAL(NOMBRE,APELLIDOS,FECHA,PAIS,CIUDAD,TELEFONO,ID_PAQUETE) VALUES (?, ?,?,?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, c.getNombre());
        pst.setString(2, c.getApellidos());
        pst.setString(3, c.getFecha());
        pst.setString(4, c.getPais());
        pst.setString(5,c.getCiudad());
        pst.setInt(6, c.getTelefono());
        pst.setInt(7, c.getId_paquete());

        pst.executeUpdate();
        pst.close();
        conn.close();
        return true;
    }
}
