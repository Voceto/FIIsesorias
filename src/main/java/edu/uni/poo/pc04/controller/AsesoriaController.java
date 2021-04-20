package edu.uni.poo.pc04.controller;

import edu.uni.poo.pc04.bean.HorarioResponse;
import edu.uni.poo.pc04.request.AsesoriaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@RestController
public class AsesoriaController {
    @Autowired
    JdbcTemplate template;
    @PostMapping("/registrarAsesoria")
    public String registrarAsesoria(@RequestBody AsesoriaRequest a )throws Exception{
        Connection connn = template.getDataSource().getConnection();
        String sql = "INSERT INTO ASESORIA(ID_HORARIO,ID_ALUMNO) VALUES(?,?)";
        PreparedStatement pst = connn.prepareStatement(sql);
        pst.setInt(2, Integer.parseInt(a.getUsuario_id()));
        pst.setInt(1, Integer.parseInt(a.getHorario_id()));
        pst.executeUpdate();
        pst.close();
        connn.close();
        return "true";

    }
}
