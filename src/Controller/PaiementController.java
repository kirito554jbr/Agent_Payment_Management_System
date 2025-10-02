package Controller;

import Service.Interfaces.IPaiementService;
import Service.PaimentService;

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
}
