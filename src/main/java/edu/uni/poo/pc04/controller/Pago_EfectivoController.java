package edu.uni.poo.pc04.controller;

import edu.uni.poo.pc04.request.EfectivoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

@RestController
public class Pago_EfectivoController {

    @Autowired
    JdbcTemplate template;

    @PostMapping("/registarpagoefectivo")
    public String registro_pago_efectivo(@RequestBody EfectivoRequest e)throws Exception{

        Connection conn = template.getDataSource().getConnection();
        String sql = "INSERT INTO PAGO_EFECTIVO (NOMBRE,DNI,MONTO) VALUES (?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, e.getNombre());
        pst.setInt(2, e.getDni());
        pst.setFloat(3, e.getMonto());
        pst.executeUpdate();
        pst.close();
        conn.close();
        return "true";
    }
}
