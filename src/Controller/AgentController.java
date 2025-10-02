package Controller;
import Model.Agent;
import Service.AgentService;
import Service.Interfaces.IAgentService;
import Service.Interfaces.IPaiementService;
import Service.PaimentService;

import java.util.Scanner;

public class AgentController {

    private IAgentService agentService;

   public AgentController (AgentService agentService){
        this.agentService = agentService;
   }

//    public void start(){
//
//        if()
//        displayMsgAgent();
//    }

//    public void displayMsg(){
//
//        System.out.println("\n============================WELCOME====================================");
//    }




        public void getById(int id){
           Agent agent = this.agentService.getById(id);

            System.out.println("Nom:"+ agent.getNom() + "|| Prenom:" + agent.getPrenom() + "|| Email:" + agent.getEmail() + "|| Depatment:" + agent.getDepartement().getNom());
        }

        public void PaiementHistorique(int id){
            this.agentService.PaiementHistorique(id);
        }


        public void Totale(int id){
            this.agentService.Totale(id);
        }

        public void create(String departementName,  String typeAgent, String nom, String prenom, String email, String password){
            this.agentService.create(departementName, typeAgent,nom, prenom, email, password);
        }

//======================RESPONSABLE MENU================











}
