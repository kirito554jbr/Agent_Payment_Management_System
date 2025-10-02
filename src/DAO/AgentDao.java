package DAO;

import Config.MyJDBC;
import Model.Agent;
import Model.Departement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AgentDao {

    public static Connection conn = MyJDBC.getConnection();


    public boolean create(Agent agent){
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
        return rows > 0;
//        System.out.println(rows + "agent inserted Succefully");

       }catch(SQLException e){
        e.printStackTrace();
        return false;
    }
}



    public boolean delete(String nom){
        String sql = "DELETE FROM agent WHERE nom = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, nom);
           int row = stmt.executeUpdate();
            return row > 0;

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Agent agent){
        String sql = "UPDATE agent SET nom = ?, prenom = ?, email = ?, password = ?, typeAgent = ?, departement = ? WHERE idAgent = ?";


        try(PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1,agent.getNom());
            stmt.setString(2,agent.getPrenom());
            stmt.setString(3,agent.getEmail());
            stmt.setString(4,agent.getMotDePasse());
            stmt.setString(5,agent.getTypeAgent());
            stmt.setInt(6,agent.getDepartementId());
            stmt.setInt(7,agent.getIdAgent());

            int row = stmt.executeUpdate();
            return row > 0;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }

    }

    public List<Agent> getAll(){
        String sql = "SELECT a.*, d.* " +
                "FROM agent a " +
                "JOIN departement d ON a.departement = d.idDepartement";



        List<Agent> agents = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Departement departement = new Departement();
                departement.setIdDepartement(rs.getInt("idDepartement"));
                departement.setNom(rs.getString("d.nom"));

                int idAgent = rs.getInt("idAgent");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String typeAgent = rs.getString("typeAgent");
                agents.add(new Agent(idAgent, typeAgent, departement, nom, prenom, email, password));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return agents;
    }

    public Agent getById(int id){
        String sql = "SELECT a.*, d.* " +
                "FROM agent a " +
                "JOIN departement d ON a.departement = d.idDepartement WHERE idAgent = ?";
        Agent agent = new Agent();
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
           ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                Departement departement = new Departement();
                departement.setIdDepartement(rs.getInt("idDepartement"));
                departement.setNom(rs.getString("d.nom"));

                agent.setIdAgent(rs.getInt("idAgent"));
                agent.setNom(rs.getString("nom"));
                agent.setPrenom(rs.getString("prenom"));
                agent.setEmail(rs.getString("email"));
                agent.setMotDePasse(rs.getString("password"));
                agent.setTypeAgent(rs.getString("typeAgent"));
                agent.setDepartement(departement);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return agent;
    }
}
