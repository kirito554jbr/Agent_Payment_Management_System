package Repository;

import DAO.AgentDao;
import Config.MyJDBC;
import java.sql.*;

import DAO.DepartementDao;
import DAO.TypeAgentDao;
import Model.Agent;
import Repository.Interface.IAgentRepositoryInterface;
import Repository.Interface.IDepartementRepositoryInterface;
import Repository.Interface.ITypeAgentRepositoryInterface;

public class AgentRepository implements IAgentRepositoryInterface {

    private AgentDao agentDao;
    private IDepartementRepositoryInterface departementRepo;
    private ITypeAgentRepositoryInterface  typeAgent;

    public AgentRepository() {
        agentDao = new AgentDao();
        departementRepo = new DepartementRepository();
        typeAgent = new TypeAgentRepoitory();
    }

    public String create(int departemenet, int role, String nom, String prenom, String email, String password){
        return this.agentDao.create(departemenet, role, nom, prenom, email, password);
    }


    public String delete(String nom){
       return  this.agentDao.delete(nom);

    }
    public void update(){}
    public void findById(){}
    public void findAll(){}
    public Agent findByName(String name){
        String sql = "select * from Agent where name = ?";
        Agent agent = null;
        try(Connection conn = MyJDBC.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            int role = 0;
            int departement = 0;
            while (rs.next()) {
                int idAgent = rs.getInt("idAgent");
                departement = rs.getInt("departement");
                role = rs.getInt("role");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                String password = rs.getString("pasword");
            }
            typeAgent.getById(role);
            departementRepo.findById(departement);


        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
