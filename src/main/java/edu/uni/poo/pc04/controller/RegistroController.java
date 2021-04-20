package edu.uni.poo.pc04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Controller
public class RegistroController {
    @Autowired
    JdbcTemplate template;

    @RequestMapping("/registrousuario")
    public String registro(@RequestParam String nombre,
                                   @RequestParam String apellido,
                                   @RequestParam String usuario,
                                   @RequestParam String email,
                                   @RequestParam int dni,
                                   @RequestParam int telefono,
                                   @RequestParam String contraseña,
                                   @RequestParam String universidad

    )throws Exception{
        int aux=0;
        if(universidad.equals("Universidad Nacional Federico Villareal")){
            aux = 2;
        }if(universidad.equals("Universidad Nacional de Ingenieria")){
            aux=1;
        }
        Connection conn = template.getDataSource().getConnection();
        String sql = "INSERT INTO USUARIO (NOMBRE,APELLIDO,DNI,TELEFONO,ID_UNIVERSIDAD,EMAIL,CONTRASENIA,USERNAME) VALUES (?, ?,?,?,?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nombre);
        pst.setString(2, apellido);

        pst.setInt(3, dni);
        pst.setInt(4, telefono);
        pst.setInt(5,aux);
        pst.setString(6, email);
        pst.setString(7, contraseña);
        pst.setString(8, usuario);
        pst.executeUpdate();
        pst.close();
        conn.close();
        return "redirect:http://fiisesorias.herokuapp.com/confirmacion.html";
    }
}
