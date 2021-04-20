package edu.uni.poo.pc04.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@RestController
public class CostoController {
    @Autowired
    JdbcTemplate template;
    @PostMapping("/horarios_costo")
    public String horariosDisp(@RequestBody CostoRequest horario_id)throws Exception{
        int aux = Integer.parseInt(horario_id.getId());
        Connection connn = template.getDataSource().getConnection();
        String sql = "SELECT COSTO FROM HORARIO WHERE ID=?";
        PreparedStatement pst = connn.prepareStatement(sql);
        pst.setInt(1,aux);
        ResultSet rs = pst.executeQuery();
        float result = 0;
        while(rs.next()){
            result = rs.getFloat(1);
        }
        pst.close();
        connn.close();
        String texto = result+"";
        return texto;
    }
}
