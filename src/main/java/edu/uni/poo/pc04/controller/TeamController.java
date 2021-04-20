package edu.uni.poo.pc04.controller;

import edu.uni.poo.pc04.request.TeamRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@RestController
public class TeamController {
    @Autowired
    JdbcTemplate template;
    @RequestMapping("/getTeam")
    public ArrayList<TeamRequest> getTeam() throws Exception{
        ArrayList<TeamRequest> l=new ArrayList<TeamRequest>();

        Connection conn = template.getDataSource().getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM ASESOR");
        while(rs.next()){
            l.add(new TeamRequest(rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5)));
        }
        rs.close();
        st.close();
        conn.close();
        return l;

    }
}
