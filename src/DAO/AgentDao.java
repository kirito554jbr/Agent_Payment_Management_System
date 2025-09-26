package DAO;

import Config.MyJDBC;
import Model.Agent;

import java.sql.*;


public class AgentDao {

    public static Connection conn = MyJDBC.getConnection();


    public String   create(Agent agent){
            String sql = "INSERT INTO agent (nom , prenom, email, password, typeAgent , departement) VALUES (?, ?, ?, ?, ?, ?)";
//
    try(PreparedStatement stmt = conn.prepareStatement(sql)){

        stmt.setString(1, agent.getNom());
        stmt.setString(2, agent.getPrenom());
        stmt.setString(3, agent.getEmail());
        stmt.setString(4, agent.getMotDePasse());
        stmt.setString(5, agent.getTypeAgent());
        stmt.setInt(6, agent.getDepartementId());

        int rows =  stmt.executeUpdate();
//        System.out.println(rows + "agent inserted Succefully");

       }catch(SQLException e){
        e.printStackTrace();
    };

    return "agent " + agent.getNom() +" created successfully!";
//       Statement stmt = conn.createStatement();
//       ResultSet resultSet = stmt.executeQuery("SELECT * FROM users");
    }



    public String delete(String nom){
        String sql = "DELETE FROM agent WHERE nom = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, nom);
            stmt.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        }
        return "agent " + nom +" deleted successfully!";

    }

    public void update(Agent agent,Agent updatedAgent){
        String sql = "UPDATE agent SET nom = ?, prenom = ?, email = ?, password = ?, typeAgent = ?, departement = ? WHERE idAgent = ?";


        try(PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1,updatedAgent.getNom());
            stmt.setString(2,updatedAgent.getPrenom());
            stmt.setString(3,updatedAgent.getEmail());
            stmt.setString(4,updatedAgent.getMotDePasse());
            stmt.setString(5,updatedAgent.getTypeAgent());
            stmt.setInt(6,updatedAgent.getDepartementId());
            stmt.setInt(7,agent.getIdAgent());

            stmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
