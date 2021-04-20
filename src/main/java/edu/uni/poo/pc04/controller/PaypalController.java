package edu.uni.poo.pc04.controller;

import edu.uni.poo.pc04.request.PaypalRequest;
import edu.uni.poo.pc04.request.UsuarioRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@RestController
public class PaypalController {
    @Autowired
    JdbcTemplate template;

    @PostMapping("/validarPaypal")
        public Boolean inicioSesion(@RequestBody PaypalRequest p) throws  Exception{
        Connection conn = template.getDataSource().getConnection();
        String sql = "SELECT COUNT(*) FROM DB_PAYPAL WHERE CORREO = ? AND PASSWORD = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,p.getUsername());
        pst.setString(2,p.getPassword());
        ResultSet rs = pst.executeQuery();
        rs.next();

        int cantReg = rs.getInt(1);
        System.out.println(cantReg);
        rs.close();
        pst.close();
        conn.close();


        System.out.println(cantReg);
        if(cantReg==1){
            return true;
        }else{
            return false;
        }
    }

    @PostMapping("/ingresarPaypal")
    public Integer usuarioId(@RequestBody PaypalRequest p)throws Exception{
        Connection conn = template.getDataSource().getConnection();
        String sql = "SELECT COUNT(*) FROM DB_PAYPAL WHERE CORREO=? AND PASSWORD=?";
        String sql2 = "SELECT * FROM DB_PAYPAL WHERE CORREO=? AND PASSWORD=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        PreparedStatement pst2 = conn.prepareStatement(sql2);
        pst.setString(1,p.getUsername());
        pst.setString(2,p.getPassword());
        pst2.setString(1,p.getUsername());
        pst2.setString(2,p.getPassword());
        ResultSet rs = pst.executeQuery();
        rs.next();
        Integer cantReg = rs.getInt(1);
        Integer i=0;
        if(cantReg==1){
            rs = pst2.executeQuery();
            rs.next();
            i = rs.getInt(1);
           return 1;
        }else  {
            i = -1;
        }
        rs.close();
        pst.close();
        conn.close();
        return i;
    }
}
