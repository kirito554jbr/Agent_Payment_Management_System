package Service;


//import Repository.Interface.*;
import Model.Agent;
import Model.Departement;
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
//        agentService.create("Managment","Trainee","harit","ennair","ennair@gmail.com","0000");
//        agentService.delete("ahmed");
        agentService.update("aymen",null,null,null,null,null,null);
    }

    public AgentService() {
        this.typeAgent = new TypeAgentRepoitory();
        this.departement = new DepartementRepository();
        this.agent = new AgentRepository();
    }



    public void create(String departemenet,  String typeAgent, String nom, String prenom, String email, String password){

        int departement_id = this.departement.findId(departemenet);
        Departement newDepartement = new Departement(departement_id,departemenet);
        Agent agent = new Agent(typeAgent,newDepartement,nom, prenom, email, password);
        this.agent.create(agent);
//        System.out.println(this.agent.create(departement_id, typeAgent, nom, prenom, email, password));
    }

   public void delete(String nom){

//        if(nom.equals("")){}
       System.out.println(this.agent.delete(nom));

   }

   //add condition when you call this method to enter null if there is no update on that specific element
    public void update(String nom, String updatedDepartemenet,  String updatedTypeAgent, String updatedNom, String updatedPrenom, String updatedEmail, String updatedPassword){
        Agent oldAgent = this.agent.findByName(nom);
        System.out.println(oldAgent);

//        Agent newAgent = new Agent(null, null, null, null, null, null);
//        if(updatedDepartemenet == null) {
//            int departement_id = this.departement.findId(oldAgent.getDepartementId());
//            newAgent.setDepartement();
//        }
    }


}
