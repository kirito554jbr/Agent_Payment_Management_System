package DAO;

import java.util.ArrayList;
import Connection.MyJDBC;
import java.sql.*;


public class AgentDao {



    public void   create(int departemenet, int role, String nom, String prenom, String email, String password){
            String sql = "INSERT INTO agent (TypeAgent, departemenet, role, nom , prenom, email, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
//
    try(Connection conn = MyJDBC.getConnection();
       PreparedStatement stmt = conn.prepareStatement(sql)){

        stmt.setInt(1, departemenet);
        stmt.setInt(2, role);
        stmt.setString(3, nom);
        stmt.setString(4, prenom);
        stmt.setString(5, email);
        stmt.setString(6, password);

        int rows =  stmt.executeUpdate();
//        System.out.println(rows + "agent inserted Succefully");

       }catch(SQLException e){
        e.printStackTrace();
    };

//       Statement stmt = conn.createStatement();
//       ResultSet resultSet = stmt.executeQuery("SELECT * FROM users");
    }
}
