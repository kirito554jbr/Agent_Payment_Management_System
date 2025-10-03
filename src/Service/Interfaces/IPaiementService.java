package Service.Interfaces;

import Model.Agent;
import Model.Paiment;

import java.util.List;

public interface IPaiementService {

    boolean create(String typePaiement, Double montant, String motif, String agentName);
    boolean delete(int id);
    void getAllAndPrint();
    List<Paiment> getAll();
    Paiment getById(int id);
    void updateIsValide(boolean isValide, int id);
    void FiltreParMontant(double min, double max, int id);
    void FiltreParDate(String date, int id);
    void FiltreParType(String type, int id);
    void FiltrePaymentParAgent(String AgentNom);
    void TotalPaiementParDepartement(String departement);
    void TotalePaiementParAgent(String name);

}
