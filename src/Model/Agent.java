package Model;

import Connection.MyJDBC;

import java.sql.*;
import java.util.ArrayList;

public class Agent extends Personne {
    private int idAgent;
    private TypeAgent typeAgent;
    private Departement departement;
    private ArrayList<Paiment> paiments;
//    private Role role;





//   public void create(String nom, String prenom, String email, String password){
//
//    String sql = "INSERT INTO agent (name , prenom, email, password) VALUES (?, ?, ?, ?)";
//
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
//   }

}
