package Service;


//import Repository.Interface.*;
import Repository.DepartementRepository;
import Repository.Interface.IDepartementRepositoryInterface;
import Repository.Interface.ITypeAgentRepositoryInterface;
import Model.TypeAgent;
import Repository.TypeAgentRepoitory;

public class AgentService {

    private ITypeAgentRepositoryInterface typeAgent;
    private IDepartementRepositoryInterface departement;


    public AgentService() {
        this.typeAgent = new TypeAgentRepoitory();
        this.departement = new DepartementRepository();
    }



    public void create(String departemenet, String role, String nom, String prenom, String email, String password){

        this.typeAgent.getRoleByName(role);
        this.departement.get    

   }
}
