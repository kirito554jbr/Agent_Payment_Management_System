package Repository;

import DAO.DepartementDao;
import Model.Departement;
import Repository.Interface.IDepartementRepositoryInterface;
import Config.MyJDBC;
import java.sql.*;
import java.util.List;

public class DepartementRepository implements IDepartementRepositoryInterface {

    private static DepartementDao departementDao = new DepartementDao();

    @Override
    public boolean create(Departement departement) {
       return departementDao.create(departement);
    }

    @Override
    public boolean delete(String nom) {
         return departementDao.delete(nom);
    }

    @Override
    public boolean update(Departement departement, String updatedNom) {
       return departementDao.update(departement, updatedNom);
    }


    @Override
    public Departement findById(int id){
         return departementDao.findById(id);
    }



    @Override
    public List<Departement> getdAll() {
        return departementDao.getAll();
    }




    @Override
    public int findId(String departement) {


        String sql = "SELECT * FROM departement WHERE nom = ?";
        int id = 0;

        try (Connection conn = MyJDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, departement);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                id = rs.getInt("idDepartement");
            }
//            System.out.println(roleName);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return  id;
    }

    @Override
    public Departement findByName(String departement) {
        return departementDao.findByName(departement);
    }
}
