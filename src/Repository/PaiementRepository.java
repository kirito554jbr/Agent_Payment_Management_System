package Repository;

import Config.MyJDBC;
import DAO.PaiementDao;
import Model.Paiment;
import Repository.Interface.IPaiementRepositoryInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PaiementRepository implements IPaiementRepositoryInterface {

    PaiementDao paiementDao = new PaiementDao();

    @Override
    public boolean create(Paiment paiment){
        return this.paiementDao.create(paiment);
    }

    @Override
    public boolean delete(int id){
       return this.paiementDao.delete(id);
    }

    @Override
    public List<Paiment> getAll(){
       return this.paiementDao.getAll();
    }
    @Override
    public Paiment getById(int id){
        return this.paiementDao.getById(id);
    }

    @Override
    public boolean updateisValide(boolean isValide, int id){
        String sql = "UPDATE paiement SET isValide = ? WHERE idPaiement = ?";


        try(Connection conn = MyJDBC.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setBoolean(1,isValide);
            stmt.setInt(2,id);
            int row = stmt.executeUpdate();
            return row > 0;

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

}
