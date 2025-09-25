package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Config.*;
import Model.Departement;

public class DepartementDao {

    static Connection conn = MyJDBC.getConnection();


    public static void main(String[] args) throws SQLException {
        DepartementDao dao = new DepartementDao();
//        dao.create("Managment");
//        dao.delete("iT");
//        dao.getAll();
//        dao.getAll();

        System.out.println(dao.findById(1));
    }

    public void create(Departement departement)throws  SQLException{

        String sql = "INSERT INTO departement(nom) VALUES(?)";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, departement.getNom());

            System.out.println(stmt.executeUpdate() + "department inserted Succefully");


        }catch (SQLException e){
            e.printStackTrace();
        }

    }


    public void delete(String nom) throws SQLException{
        String sql = "DELETE FROM departement WHERE nom = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1,nom);
            System.out.println(stmt.executeUpdate() + "department deleted Succefully");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void update(Departement departement , String updatedNom){
        String sql = "UPDATE department SET nom = ? WHERE nom = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,updatedNom);
            stmt.setString(1,departement.getNom());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public Departement findById(int idDepartement){
        String sql = "SELECT * FROM departement WHERE idDepartement = ?";
        Departement departement = new Departement();

        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,idDepartement);
           ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                departement = new Departement();
                departement.setIdDepartement(rs.getInt("idDepartement"));
                departement.setNom(rs.getString("nom"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if(departement.getNom() == null ) {
            return null;
        }else {
            return departement;
        }
    }




    public List<Departement> getAll(){
        String sql = "SELECT * FROM departement";
        List<Departement> departements = new ArrayList<>();

        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                int id = rs.getInt("idDepartement");
                String nom = rs.getString("nom");
                departements.add(new Departement(id, nom));
            }
//            for (int i = 0; i < departements.size(); i++) {
//                System.out.println(departements.get(i));
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departements;
    }
}
