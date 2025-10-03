package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Config.*;
import Model.Departement;

public class DepartementDao {

    static Connection conn = MyJDBC.getConnection();




    public boolean create(Departement departement){

        String sql = "INSERT INTO departement(nom) VALUES(?)";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, departement.getNom());

            int row = stmt.executeUpdate();
            return  row > 0;
//            System.out.println(stmt.executeUpdate() + "department inserted Succefully");


        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }


    public boolean delete(String nom){
        String sql = "DELETE FROM departement WHERE nom = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1,nom);
                int row = stmt.executeUpdate();
                return row > 0;
//            System.out.println(stmt.executeUpdate() + "department deleted Succefully");
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }


    public boolean update(Departement departement , String updatedNom){
        String sql = "UPDATE departement SET nom = ? WHERE idDepartement = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,updatedNom);
            stmt.setInt(2,departement.getIdDepartement());
            int row = stmt.executeUpdate();
            return row > 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
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


    public Departement findByName(String department){
        String sql = "SELECT * FROM departement WHERE nom = ?";
        Departement returnDepartement = new Departement();
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,department);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                returnDepartement.setIdDepartement(rs.getInt("idDepartement"));
                returnDepartement.setNom(rs.getString("nom"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(returnDepartement.getNom() == null ) {
            return null;
        }else {
            return returnDepartement;
        }
    }
}
