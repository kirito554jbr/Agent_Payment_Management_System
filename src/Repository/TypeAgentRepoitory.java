package Repository;

import DAO.TypeAgentDao;
import Config.MyJDBC;
import Repository.Interface.ITypeAgentRepositoryInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeAgentRepoitory implements ITypeAgentRepositoryInterface {

    private TypeAgentDao roleDao;

    public TypeAgentRepoitory() {
        this.roleDao = new TypeAgentDao();
    }

    public void create(String rolenNom){
        this.roleDao.create(rolenNom);
    }

    public void delete(int id){
        this.roleDao.delete(id);
    }


    public void update(int id,String roleNom){
        this.roleDao.update(id, roleNom);
    }

    public void getById(int id){
        this.roleDao.getById(id);
    }

    public int getRoleId(String roleName){

        String sql = "SELECT * FROM TypeAgent WHERE roleNom = ?";
        int id = 0;

        try (Connection conn = MyJDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, roleName);
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
