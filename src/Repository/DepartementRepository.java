package Repository;

import Repository.Interface.IDepartementRepositoryInterface;
import Connection.MyJDBC;
import java.sql.*;

public class DepartementRepository implements IDepartementRepositoryInterface {
    @Override
    public void create() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public void findById() {

    }

    @Override
    public void findAll() {

    }

    @Override
    public int findId(String departement) {


        String sql = "SELECT * FROM departemet WHERE nom = ?";
        int id = 0;

        try (Connection conn = MyJDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, departement);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                id = rs.getInt("id");
            }
//            System.out.println(roleName);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return  id;
    }
}
