package edu.uni.poo.pc04.controller;


import edu.uni.poo.pc04.request.PagoTarRequest;
import edu.uni.poo.pc04.request.TarjetaRequest;
import edu.uni.poo.pc04.request.TarjetaRequest2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@RestController
public class TarjetaController {
    @Autowired
    JdbcTemplate template;

    @PostMapping("/pagartarjeta")
    public Boolean pagartar(@RequestBody TarjetaRequest tar) throws Exception{
        Connection conn = template.getDataSource().getConnection();
        String sql="";
        String sql2 = "INSERT INTO TARJETA(ID_TIPO_TARJETA,ID_USUARIO,PROPIETARIO,NRO_TARJETA,CVC,CADUCIDAD) VALUES (?,?,?,?,?,?)";
        if(tar.getId_tipo_tar() == 1){
            sql = "SELECT COUNT(*) FROM DB_MASTERCARD WHERE NRO_TARJETA = ? AND CVC = ? AND CADUCIDAD = ?";
        }else if(tar.getId_tipo_tar()==2){
            sql = "SELECT COUNT(*) FROM DB_VISA WHERE NRO_TARJETA = ? AND CVC = ? AND CADUCIDAD = ?";
        }else if(tar.getId_tipo_tar()==3){
            sql = "SELECT COUNT(*) FROM DB_AMERICANEXPRESS WHERE NRO_TARJETA = ? AND CVC = ? AND CADUCIDAD = ?";
        }
        PreparedStatement pst = conn.prepareStatement(sql);
        PreparedStatement pst2 = conn.prepareStatement(sql2);
        pst.setInt(1,tar.getNro_tar());
        pst.setString(2,tar.getCvc());
        pst.setInt(3,tar.getCaducidad());
        pst2.setInt(1,tar.getId_tipo_tar());
        pst2.setInt(2,Integer.parseInt(tar.getId_usuario()));
        pst2.setString(3,tar.getPropietario());
        pst2.setInt(4,tar.getNro_tar());
        pst2.setString(5,tar.getCvc());
        pst2.setInt(6,tar.getCaducidad());
        pst2.executeUpdate();
        ResultSet rs = pst.executeQuery();
        rs.next();

        int cantReg = rs.getInt(1);
        System.out.println(cantReg);


        rs.close();
        pst2.close();
        pst.close();
        conn.close();

        if(cantReg==1){
            return true;
        }
            return false;

    }

    @PostMapping ("/obtenerid")
    public Integer obtenerid(@RequestBody TarjetaRequest2 tar)throws Exception{
        Connection conn = template.getDataSource().getConnection();
        String sql = "SELECT ID FROM TARJETA WHERE NRO_TARJETA = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1,tar.getNro_tar());

        ResultSet rs = pst.executeQuery();
        rs.next();

        Integer id = rs.getInt(1);

        rs.close();
        pst.close();
        conn.close();
        return id;
    }

    @PostMapping("/realizarpago")
    public Boolean pago(@RequestBody PagoTarRequest tar)throws Exception{
        Connection conn = template.getDataSource().getConnection();
        String sql = "INSERT INTO PAGO_TARJETA (ID_TARJETA,MONTO) VALUES (?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1,tar.getId_tar());
        pst.setDouble(1,tar.getMonto());
        return true;
    }

}
