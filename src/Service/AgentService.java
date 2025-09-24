package Service;


//import Repository.Interface.*;
import Repository.AgentRepository;
import Repository.DepartementRepository;
import Repository.Interface.IAgentRepositoryInterface;
import Repository.Interface.IDepartementRepositoryInterface;
import Repository.Interface.ITypeAgentRepositoryInterface;
import Model.TypeAgent;
import Repository.TypeAgentRepoitory;

public class AgentService {

    private ITypeAgentRepositoryInterface typeAgent;
    private IDepartementRepositoryInterface departement;
    private IAgentRepositoryInterface agent;


    public static void main(String[] args) {
        AgentService agentService = new AgentService();
        agentService.create("IT","WORKER","aymen","jebrane","aymen@gmail.com","0000");
//        agentService.delete("aymen");
    }

    public AgentService() {
        this.typeAgent = new TypeAgentRepoitory();
        this.departement = new DepartementRepository();
        this.agent = new AgentRepository();
    }



    public void create(String departemenet, String role, String nom, String prenom, String email, String password){

        int role_id = this.typeAgent.getRoleId(role);
        int departement_id = this.departement.findId(departemenet);
        System.out.println(this.agent.create(role_id, departement_id, nom, prenom, email, password));   }

   public void delete(String nom){

//        if(nom.equals("")){}
       System.out.println(this.agent.delete(nom));

   }


}
