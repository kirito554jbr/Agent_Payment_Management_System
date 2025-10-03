package Controller;

import Model.Agent;
import Service.Interfaces.IPaiementService;
import Service.PaimentService;

import java.time.LocalDate;

public class PaiementController {

    private IPaiementService paiementService;

    public PaiementController(PaimentService paiementService){
        this.paiementService = paiementService;
    }


    public void start(){
        displayMsg();
    }

    public void displayMsg(){

    }



    public void FiltreParType(String type , int id){
        this.paiementService.FiltreParType(type, id);
    }

    public void FiltreParDate(String date, int id){
        this.paiementService.FiltreParDate(date, id);
    }

    public void FiltreParMontant(double min, double max, int id){
        this.paiementService.FiltreParMontant(min,max,id);
    }

    public void create(String typePaiement, Double montant, String motif, String agentName){
        this.paiementService.create(typePaiement, montant, motif, agentName);
    }

    public void FiltrePaymentParAgent(String AgentName){
        this.paiementService.FiltrePaymentParAgent(AgentName);
    }

    public void TotaleParAgent(String name){
        this.paiementService.TotalePaiementParAgent(name);
    }

    public void updateIsValide(boolean isValide, int id){
        this.paiementService.updateIsValide(isValide, id);
    }

    public void TotalPaiementParDepartement(String departement){
        this.paiementService.TotalPaiementParDepartement(departement);
    }
}
