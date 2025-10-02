package Service;

import Model.Agent;
import Model.Paiment;
import Repository.Interface.IPaiementRepositoryInterface;
import Repository.PaiementRepository;
import Service.Interfaces.IPaiementService;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PaimentService implements IPaiementService {
    private IPaiementRepositoryInterface paiementReapository ;

    public PaimentService() {
        this.paiementReapository = new PaiementRepository();
    }

    public static void main(String[] args) {
//        PaimentService paimentService = new PaimentService();
//        Departement departement = new Departement(3,"IT");
//        Agent agent = new Agent(1, "Worker",departement,"aymen", "erraji", "aymen@gmail","0000");
//        paimentService.create("Bonus",12000.00,"makitkhalessch kiyakhod li bra",agent);
//        paimentService.updateIsValide(true,3);
//        paimentService.getAll();
//        paimentService.FiltreParType("Bonus");
//        paimentService.FiltreParDate("2025-09-26");
//        paimentService.FiltreParMontant(2000.00);
    }

    @Override
    public boolean create(String typePaiement, Double montant, String motif, Agent agent) {
            // 1. Validate mandatory fields
            if (typePaiement == null || typePaiement.isEmpty()) {
                System.out.println("Payment type is required.");
                return false;
            }
            if (montant == null || montant <= 0) {
                System.out.println("Invalid amount: " + montant);
                return false;
            }
            if (motif == null || motif.isEmpty()) {
                System.out.println("Motif (reason) is required.");
                return false;
            }
            if (agent == null || agent.getIdAgent() == 0) {
                System.out.println("A valid agent must be associated with the payment.");
                return false;
            }
        Paiment paiment = new Paiment(typePaiement.toUpperCase(), montant, motif, agent);
        boolean created = this.paiementReapository.create(paiment);

        if (created) {
            System.out.println("Payment created successfully for agent: " + agent.getNom());
            return true;
        } else {
            System.out.println("Failed to create payment.");
            return false;
        }
        }

    @Override
    public boolean delete(int id){

        if (id <= 0) {
            System.out.println("Invalid payment ID.");
            return false;
        }


        Paiment existingPayment = this.paiementReapository.getById(id);
        if (existingPayment == null) {
            System.out.println("No payment found with ID: " + id);
            return false;
        }
        boolean deleted = this.paiementReapository.delete(id);

        if (deleted) {
            System.out.println("Payment deleted successfully (ID: " + id + ")");
            return true;
        } else {
            System.out.println("Failed to delete payment (ID: " + id + ")");
            return false;
        }
    }
    @Override
    public void getAllAndPrint(){
        for (Paiment paiment : this.paiementReapository.getAll()){
            System.out.println(paiment);
        }
    }
    @Override
    public List<Paiment> getAll(){
        return this.paiementReapository.getAll();
    }
    @Override
    public Paiment getById(int id){
        if (id <= 0) {
            System.out.println("Invalid payment ID.");
            return null;
        }


        Paiment paiement = this.paiementReapository.getById(id);

        if (paiement == null) {
            System.out.println("No payment found with ID: " + id);
            return null;
        }

        System.out.println("Payment retrieved successfully (ID: " + id + ")");
        return paiement;
    }
    @Override
    public void updateIsValide(boolean isValide, int id){
        this.paiementReapository.updateisValide(isValide, id);
    }
    @Override
    public void FiltreParMontant(double min, double max, int id){
        List<Paiment> paiments = getAll();

        List<Paiment> paimentStream = paiments.stream()
                .filter(obj -> obj.getMontant() >= min && obj.getMontant() <= max && obj.getAgent().getIdAgent() == id)
                .collect(Collectors.toList());
        for(Paiment paiment : paimentStream){
            System.out.println(paiment);
        }
    }
    @Override
    public void FiltreParDate(String date , int id){
        List<Paiment> paiments = getAll();

        LocalDate nDate = LocalDate.parse(date);

        List<Paiment> paimentStream = paiments.stream()
                .filter(obj -> obj.getDate().equals(nDate) && obj.getAgent().getIdAgent() == id)
                .sorted(Comparator.comparing(Paiment::getDate))
                .toList();

        if (paimentStream.isEmpty()) {
            System.out.println("No Paiement found for date: " + date);
        } else {
            for (Paiment paiment : paimentStream) {
                System.out.println(
                        "Type de Paiement: " + paiment.getTypePaiement() +
                                " || Montant: " + paiment.getMontant() +
                                " || Date de Paiement: " + paiment.getDate() +
                                " || Motif: " + paiment.getMotif() +
                                " || Valide: " + paiment.isValide()
                );
            }
        }

    }
    @Override
    public void FiltreParType(String type, int id){
        List<Paiment> paiments = getAll();

        List<Paiment> paimentStream = paiments.stream()
                .filter(obj -> obj.getTypePaiement().equals(type.toUpperCase()) && obj.getAgent().getIdAgent() == id)
                .collect(Collectors.toList());

        if (paimentStream.isEmpty()) {
            System.out.println("No " + type + " Paiement found");
        } else {
            for (Paiment paiment : paimentStream) {
                System.out.println(
                        "Type de Paiement: " + paiment.getTypePaiement() +
                                " || Montant: " + paiment.getMontant() +
                                " || Date de Paiement: " + paiment.getDate() +
                                " || Motif: " + paiment.getMotif() +
                                " || Valide: " + paiment.isValide()
                );
            }
        }

    }

}
