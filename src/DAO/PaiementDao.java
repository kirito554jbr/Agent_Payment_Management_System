package DAO;

import Config.MyJDBC;
import Model.Paiment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.sql.Date.valueOf;

public class PaiementDao {

    Connection conn = MyJDBC.getConnection();


//    public static void main(String[] args) {
//        PaiementDao paiementDao = new PaiementDao();
//        Paiment paiment = new Paiment("SALAIRE",5000.00, "rass chhar hada", );
//        paiementDao.create();
//    }

    public boolean create(Paiment paiment){
        String sql = "INSERT INTO paiement(typePaiement, montant, datePaiement, motif, agent) VALUES (?, ?, ?, ?, ?)";

        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,paiment.getTypePaiement());
            stmt.setDouble(2,paiment.getMontant());
            stmt.setDate(3,valueOf(paiment.getDate()));
            stmt.setString(4,paiment.getMotif());
            stmt.setInt(5,paiment.getAgentId());

            int rows = stmt.executeUpdate();

            System.out.println(rows);

        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public void delete(){

    }

//    public void update(Paiment paiment)

    public void getAll(){

    }

    public void getById(){

    }
}
