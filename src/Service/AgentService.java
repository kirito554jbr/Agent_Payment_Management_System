package Service;


import Model.Agent;
import Model.Departement;
import Model.Paiment;
import Repository.AgentRepository;
import Repository.DepartementRepository;
import Repository.Interface.IAgentRepositoryInterface;
import Repository.Interface.IDepartementRepositoryInterface;
import Repository.Interface.ITypeAgentRepositoryInterface;
import Model.TypeAgent;
import Repository.TypeAgentRepoitory;
import Service.Interfaces.IAgentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AgentService implements IAgentService {

    private ITypeAgentRepositoryInterface typeAgent;
    private IDepartementRepositoryInterface departementRepository;
    private IAgentRepositoryInterface agent;
    private Departement departement;
    private PaimentService paimentService;


    public static void main(String[] args) {
//        AgentService agentService = new AgentService();
//        agentService.create("IT","Worker","ahmed","foullan","ahmed@gmail.com","0000");
//        agentService.create("IT","DEPARTMENT_MANAGER","MR","president","admin@gmail.com","0000");
//            agentService.logIn("aymen@gmail.com","0000");
//        agentService.getAll();
//        agentService.PaiementHistorique(1);
//        agentService.getById(1);
//        agentService.delete("ahmed");
//        agentService.update("ahmed","IT","Worker",null,null,"admin123@gmail.com","1234");
    }

    public AgentService(DepartementRepository departementRepository,IAgentRepositoryInterface agent,Departement departement, PaimentService paimentService) {

        this.departementRepository = departementRepository;
        this.agent = agent;
        this.departement = departement;
        this.paimentService = paimentService;
    }




    @Override
    public boolean create(String departementName,  String typeAgent, String nom, String prenom, String email, String password){

        if (nom == null || nom.isEmpty() ||
                prenom == null || prenom.isEmpty() ||
                email == null || email.isEmpty() ||
                password == null || password.isEmpty()) {
            System.out.println("Missing required fields.");
            return false;
        }




        int departement_id = this.departementRepository.findId(departementName);
        if (departement_id < 1) { // assume -1 if not found
            System.out.println("Department does not exist: " + departementName);
            return false;
        }


        Departement newDepartement = new Departement(departement_id,departementName);

        if (this.agent.findByEmail(email) != null) {
            System.out.println("An agent with this email already exists.");
            return false;
        }


        Agent agent = new Agent(typeAgent,newDepartement,nom, prenom, email, password);
//        this.agent.create(agent);


            if ("DEPARTMENT_MANAGER".equalsIgnoreCase(typeAgent)){
            if(this.departement.getResponsable() == null){
//                System.out.println("----------------");
                this.departement.setResponsable(agent);
                this.departement.setAgents(agent);
            }
            else{
                System.out.println("this Department already has a manager");
                return false;
            }
        }
//        System.out.println(this.agent.create(departementRepository_id, typeAgent, nom, prenom, email, password));

        boolean created = this.agent.create(agent);
//        System.out.println(this.departement.getResponsable());

        if (created) {
            System.out.println("Agent created successfully: " + nom + " " + prenom);
            return true;
        } else {
            System.out.println("Failed to create agent.");
            return false;
        }
    }
    @Override
   public boolean delete(String nom){

        if (nom == null || nom.isEmpty()){
            System.out.println("Missing required fields.");
            return false;
        }

       Agent agentToDelete = this.agent.findByName(nom);
       if (agentToDelete == null) {
           System.out.println("No agent found with name: " + nom);
           return false;
       }
       boolean deleted = this.agent.delete(nom);

       if (deleted) {
           System.out.println("Agent deleted successfully: " + nom);
           return true;
       } else {
           System.out.println("Failed to delete agent: " + nom);
           return false;
       }

//       System.out.println(this.agent.delete(nom));
   }

   //add condition when you call this method to enter null if there is no update on that specific element
   @Override
    public boolean update(String nom, String updatedDepartemenet,  String updatedTypeAgent, String updatedNom, String updatedPrenom, String updatedEmail, String updatedPassword){
        Agent oldAgent = this.agent.findByName(nom);

        if (oldAgent == null) {
            System.out.println(" No agent found with name: " + nom);
            return false;
        }
//        System.out.println(oldAgent);

        Agent newAgent = new Agent();
        if(updatedDepartemenet == null) {
            newAgent.setDepartement(oldAgent.getDepartement());
        }else {

                Departement newDepartment = this.departementRepository.findByName(updatedDepartemenet);
            if (newDepartment == null) {
                System.out.println("Department not found: " + updatedDepartemenet);
                return false;
            }
                newAgent.setDepartement(newDepartment);
//            }
        }
        if(updatedNom == null){
            newAgent.setNom(oldAgent.getNom());
        }else{
            newAgent.setNom(updatedNom);
        }

        newAgent.setNom(updatedNom == null ? oldAgent.getNom() : updatedNom);
        newAgent.setPrenom(updatedPrenom == null ? oldAgent.getPrenom() : updatedPrenom);

//        newAgent.setEmail(updatedEmail == null ? oldAgent.getEmail() : updatedEmail);
        //---------------------------------Email UPDATE--------------------------------------------
//        if (this.agent.findByEmail(email) != null) {
//            System.out.println("An agent with this email already exists.");
//            return false;
//        }
        if (updatedEmail != null) {
//            System.out.println("-------------------------");
            if (this.agent.findByEmail(updatedEmail) != null) {
                System.out.println("Another agent with this email already exists.");
                return false;
            }
            newAgent.setEmail(updatedEmail);
        } else {
            newAgent.setEmail(oldAgent.getEmail());
        }


        newAgent.setMotDePasse(updatedPassword == null ? oldAgent.getMotDePasse() : updatedPassword);
//---------------------------------------------Type UPDATE-------------------------------------------------
//        newAgent.setTypeAgent(updatedTypeAgent == null ? oldAgent.getTypeAgent() : updatedTypeAgent);
        String finalType = updatedTypeAgent == null ? oldAgent.getTypeAgent() : updatedTypeAgent;
        if ("DEPARTMENT_MANAGER".equalsIgnoreCase(finalType)) {
            Departement dept = newAgent.getDepartement();
            if (dept.getResponsable() != null && !dept.getResponsable().equals(oldAgent)) {
                System.out.println("This department already has a manager.");
                return false;
            }
            dept.setResponsable(newAgent);
        }
        newAgent.setTypeAgent(finalType);


//        this.agent.update(oldAgent,newAgent);
        boolean updated = this.agent.update(oldAgent, newAgent);
        if (updated) {
            System.out.println("Agent updated successfully: " + newAgent.getNom());
            return true;
        } else {
            System.out.println("Failed to update agent: " + oldAgent.getNom());
            return false;
        }
//        System.out.println(newAgent);
    }
    @Override
    public List<Agent> getAll(){
        return this.agent.getAll();

//        for (Agent agent : this.agent.getAll()){
//            System.out.println(agent);
//        }
    }
    @Override
    public void getById(int id){
        List<Agent> agents = getAll();

        List<Agent> agentStream = agents.stream()
                .filter(obj -> obj.getIdAgent() == id)
                .collect(Collectors.toList());

        for(Agent agent : agentStream){
            System.out.println(agent);
        }
    }

    @Override
    public void PaiementHistorique(int id){
        List<Paiment> paiments = paimentService.getAll();

        List<Paiment> paimentStream = paiments.stream()
                .filter(obj -> obj.getAgentId() == id)
                .collect(Collectors.toList());

        for(Paiment paiment : paimentStream){
            System.out.println(paiment);
        }


    }

//    public void Totale(int id){
//        Agent agent = PrintById(id);
//
//
//
//    }



}
