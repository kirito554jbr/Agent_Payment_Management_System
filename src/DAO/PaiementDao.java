package DAO;

import Config.MyJDBC;
import Model.Agent;
import Model.Departement;
import Model.Paiment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Date.valueOf;

public class PaiementDao {

    Connection conn = MyJDBC.getConnection();


//    public static void main(String[] args) {
//        PaiementDao paiementDao = new PaiementDao();
//     Paiment paiment = new Paiment("SALAIRE",5000.00, "rass chhar hada", );
//       paiementDao.create();
//        System.out.println(paiementDao.getById(1));
//    }

    public boolean create(Paiment paiment){
        String sql = "INSERT INTO paiement(typePaiement, montant, datePaiement, motif, agent, isValide) VALUES (?, ?, ?, ?, ?, ?)";

        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,paiment.getTypePaiement());
            stmt.setDouble(2,paiment.getMontant());
            stmt.setDate(3,valueOf(paiment.getDate()));
            stmt.setString(4,paiment.getMotif());
            stmt.setInt(5,paiment.getAgentId());
            stmt.setBoolean(6, paiment.isValide());

            int rows = stmt.executeUpdate();
            return rows >0;

//            System.out.println(rows);

        }catch (SQLException e){
            e.printStackTrace();
        return false;
        }
    }

    public boolean delete(int id){
        String sql = "DELETE FROM paiement WHERE idPaiement = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            int row = stmt.executeUpdate();
            return row > 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

//    public void update(Paiment paiment)

    public List<Paiment> getAll () {
        List<Paiment> paiements = new ArrayList<>();
        String sql = "SELECT p.*, " + "a.*, " + "d.* " + "FROM paiement p " +
                "JOIN agent a ON p.agent = a.idAgent " +
                "JOIN departement d ON a.departement = d.idDepartement";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Departement departement = new Departement();
                departement.setIdDepartement(rs.getInt("idDepartement"));
                departement.setNom(rs.getString("departement"));

                // build Agent
                int idAgent = rs.getInt("idAgent");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String typeAgent = rs.getString("typeAgent");
                Agent agent = new Agent(idAgent,typeAgent,departement,nom, prenom, email, password);

                // build Paiement
                int idPaiement = rs.getInt("idPaiement");
                LocalDate date = rs.getDate("datePaiement").toLocalDate();
                Double montant = rs.getDouble("montant");
                String typePaiement = rs.getString("typePaiement");
                String motif = rs.getString("motif");
                boolean isValide = rs.getBoolean("isValide");

                Paiment paiement = new Paiment(idPaiement,typePaiement,montant,motif,agent,isValide);

                paiements.add(paiement);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paiements;
    }


    public Paiment getById(int id){
//        String sql = "SELECT * FROM paiement WHERE idPaiement = ?";
        String sql = "SELECT p.*, " + "a.*, " + "d.* " + "FROM paiement p " +
                "JOIN agent a ON p.agent = a.idAgent " +
                "JOIN departement d ON a.departement = d.idDepartement WHERE p.idPaiement = ?";

        Paiment paiement = new Paiment();


        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Departement departement = new Departement();
                departement.setIdDepartement(rs.getInt("idDepartement"));
                departement.setNom(rs.getString("departement"));

                // build Agent
                int idAgent = rs.getInt("idAgent");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String typeAgent = rs.getString("typeAgent");
                Agent agent = new Agent(idAgent,typeAgent,departement,nom, prenom, email, password);

                // build Paiement
                paiement.setIdPaiement(rs.getInt("idPaiement"));
                paiement.setDate(rs.getDate("datePaiement").toLocalDate());
                paiement.setMontant(rs.getDouble("montant"));
                paiement.setAgent(agent);
                paiement.setTypePaiement(rs.getString("typePaiement"));
                paiement.setMotif(rs.getString("motif"));
                paiement.setValide(rs.getBoolean("isValide"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return paiement;

    }
}
