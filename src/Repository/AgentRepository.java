package Repository;

import DAO.AgentDao;
import Config.MyJDBC;
import java.sql.*;
import java.util.List;

import DAO.DepartementDao;
import DAO.TypeAgentDao;
import Model.Agent;
import Model.Departement;
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

    public boolean create(Agent agent){
        return this.agentDao.create(agent);
    }


    public boolean delete(String nom){return this.agentDao.delete(nom);}


    public boolean update(Agent agent, Agent updatedAgent){
        return this.agentDao.update(agent, updatedAgent);
    }


    public List<Agent> getAll(){
        return this.agentDao.getAll();
    }

//    public void findById(){}

    public Agent findByName(String name){
        String sql = "select * from agent where nom = ?";
        Agent agent = new Agent();
        try(Connection conn = MyJDBC.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();


            if (rs.next()) {
//                int idAgent = rs.getInt("idAgent");
//                String nom = rs.getString("nom");
//                String prenom = rs.getString("prenom");
//                String email = rs.getString("email");
//                String password = rs.getString("password");
//                role = rs.getString("typeAgent");
                int departement = rs.getInt("departement");
                Departement d =  departementRepo.findById(departement);


                agent.setIdAgent(rs.getInt("idAgent"));
                agent.setTypeAgent(rs.getString("typeAgent"));
                agent.setDepartement(d);
                agent.setNom(rs.getString("nom"));
                agent.setPrenom(rs.getString("prenom"));
                agent.setEmail(rs.getString("email"));
                agent.setMotDePasse(rs.getString("password"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return agent;
    }

    public Agent findByEmail(String email){
        String sql = "SELECT * FROM agent WHERE email = ?";
        Agent agent = new Agent();

        try(Connection conn = MyJDBC.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                int departement = rs.getInt("departement");
                Departement d =  departementRepo.findById(departement);


                agent.setIdAgent(rs.getInt("idAgent"));
                agent.setTypeAgent(rs.getString("typeAgent"));
                agent.setDepartement(d);
                agent.setNom(rs.getString("nom"));
                agent.setPrenom(rs.getString("prenom"));
                agent.setEmail(rs.getString("email"));
                agent.setMotDePasse(rs.getString("password"));
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        if(agent.getNom() == null){
            return null;
        }else {
            return agent;
        }

    }

}
