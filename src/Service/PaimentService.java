package Service;

import Model.Agent;
import Model.Departement;
import Model.Paiment;
import Repository.Interface.IPaiementRepositoryInterface;
import Repository.PaiementRepository;
import Service.Interfaces.IAgentService;
import Service.Interfaces.IDepartementService;
import Service.Interfaces.IPaiementService;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PaimentService implements IPaiementService {
    private IPaiementRepositoryInterface paiementReapository ;
    private IDepartementService departementService;
    private IAgentService agentService;

    public PaimentService(PaiementRepository paiementReapository, DepartementService departementService, AgentService agentService) {
//        this.paiementReapository = new PaiementRepository();
//        this.departementService = new DepartementService();
//        this.agentService = new AgentService();
        this.paiementReapository = paiementReapository;
        this.departementService = departementService;
        this.agentService = agentService;
    }

    @Override
    public boolean create(String typePaiement, Double montant, String motif, String agentName) {

            Agent agent = this.agentService.finByName(agentName);

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
        Paiment paiment = new Paiment(typePaiement.toUpperCase(), montant,LocalDate.now(), motif, agent);
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

//    public

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

    @Override
    public void FiltrePaymentParAgent(String AgentNom) {
        List<Paiment> paiments = getAll();
        Agent agent = this.agentService.finByName(AgentNom);

        List<Paiment> paimentStream = paiments.stream()
                .filter(obj -> obj.getAgentId() == agent.getIdAgent())
                .toList();

        if (paimentStream.isEmpty()) {
            System.out.println(AgentNom + "has no Paiement");
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
    public void TotalePaiementParAgent(String name){
        List<Paiment> paiments = getAll();
        double totale = 0;
        List<Paiment> paimentStream = paiments.stream()
                .filter(obj -> Objects.equals(obj.getAgent().getNom(), name) && obj.isValide())
                .toList();

        for(Paiment paiment : paimentStream){
            totale += paiment.getMontant();
        }
        System.out.println("Le totale des paiement est " + totale);

    }

    @Override
    public void TotalPaiementParDepartement(String departement){
        int id = this.departementService.findId(departement);

        List<Paiment> paiments = this.paiementReapository.getAll();

        double total = paiments.stream()
                .filter(p ->  p.getAgent().getDepartement().getIdDepartement() == id && p.isValide())
                .mapToDouble(Paiment::getMontant)
                .sum();

        if (total == 0) {
            System.out.println("No payments found for department: " + departement);
        } else {
            System.out.println("Total payments for department " + departement + ": " + total);
        }
    }

}
