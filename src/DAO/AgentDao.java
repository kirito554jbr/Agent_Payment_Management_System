package DAO;

import Config.MyJDBC;
import java.sql.*;


public class AgentDao {



    public String   create(int departemenet, int role, String nom, String prenom, String email, String password){
            String sql = "INSERT INTO agent (departement, role, nom , prenom, email, pasword) VALUES (?, ?, ?, ?, ?, ?)";
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

    return "agent " + nom +" created successfully!";
//       Statement stmt = conn.createStatement();
//       ResultSet resultSet = stmt.executeQuery("SELECT * FROM users");
    }



    public String delete(String nom){
        String sql = "DELETE FROM agent WHERE nom = ?";
        try(Connection conn = MyJDBC.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, nom);
            int rows =  stmt.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        }
        return "agent " + nom +" deleted successfully!";

    }

    public void update(String nom, String prenom, String email, String password){

    }
}
