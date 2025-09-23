package DAO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connection.*;
import Model.TypeAgent;

public class TypeAgentDao {


    public static void main(String[] args) {
        TypeAgentDao dao = new TypeAgentDao();
//        dao.create("TRAINEE");
        dao.getById(2);
//        dao.delete(7);
//        dao.update(7,"hada_raymchi");
    }

    public void  create(String roleNom){
        String sql = "INSERT INTO TypeAgent (roleNom) VALUES (?)";
//
        try(Connection conn = MyJDBC.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, roleNom);

            int rows =  stmt.executeUpdate();
            System.out.println(rows + "role inserted Succefully");


        }catch(SQLException e){
            e.printStackTrace();
        };

//       Statement stmt = conn.createStatement();
//       ResultSet resultSet = stmt.executeQuery("SELECT * FROM users");
    }


    public String getById(int id){
        String sql = "SELECT * FROM TypeAgent WHERE id = ?";
        String roleName = "";

        try (Connection conn = MyJDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                 roleName = rs.getString("roleNom");
            }
//            System.out.println(roleName);
        }catch(SQLException e){
            e.printStackTrace();
        }
            return  roleName;
    }


    public boolean delete(int id){
        String sql = "DELETE FROM TypeAgent WHERE id = ?";
        boolean result = false;

        try (Connection conn = MyJDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
             stmt.setInt(1, id);
             result =  stmt.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(int id,String roleNom){
        String sql = "UPDATE TypeAgent SET roleNom = ? WHERE id = ?";
        boolean result = false;

        try (Connection conn = MyJDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, roleNom);
            stmt.setInt(2, id);
            result =  stmt.executeUpdate() > 0;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }


}
