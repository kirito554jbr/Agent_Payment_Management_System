package DAO;

import java.util.ArrayList;
import Connection.MyJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {

    public void create(String tableName , ArrayList<ArrayList<String>> data){

            String sql = "INSERT INTO agent (name , prenom, email, password) VALUES (?, ?, ?, ?)";


//    try(Connection conn = MyJDBC.getConnection();
//       PreparedStatement stmt = conn.prepareStatement(sql)){
//
//        stmt.setString(1, nom);
//        stmt.setString(2, prenom);
//        stmt.setString(3, email);
//        stmt.setString(4, password);
//
//        int rows =  stmt.executeUpdate();
//        System.out.println(rows + "agent inserted Succefully");
//
//       }catch(SQLException e){
//        e.printStackTrace();
//    };

//       Statement stmt = conn.createStatement();
//       ResultSet resultSet = stmt.executeQuery("SELECT * FROM users");
    }

    public void delete(String tableName , int id){

    }

    public void update(String tableName , ArrayList<ArrayList<String>> data, int id){

    }

    public void getAll(String tableName){

    }

    public void getById(String tableName , int id){
    }


}
