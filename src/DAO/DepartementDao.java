package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Config.*;
import Model.Departement;

public class DepartementDao {

    public static void main(String[] args) {
        DepartementDao dao = new DepartementDao();
//        dao.create("IT", 0);
        dao.getAll();
    }

    public void create(String nom, int responsable){

        String sql = "INSERT INTO departement(nom,responsable) VALUES(?,?)";
        try(Connection conn = MyJDBC.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, nom);
            stmt.setInt(2, responsable);

            System.out.println(stmt.executeUpdate() + "department inserted Succefully");


        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void getAll(){
        String sql = "SELECT * FROM departement";
        List<Departement> departements = new ArrayList<>();

        try(Connection conn = MyJDBC.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                int id = rs.getInt("idDepartement");
                String nom = rs.getString("nom");
                int responsable = rs.getInt("responsable");
                departements.add(new Departement(id, nom));
            }
            for (int i = 0; i < departements.size(); i++) {
                System.out.println(departements.get(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
