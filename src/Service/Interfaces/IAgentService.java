package Service.Interfaces;

import Model.Agent;

import java.util.List;

public interface IAgentService {
    boolean create(String departementName,  String typeAgent, String nom, String prenom, String email, String password);
    boolean delete(String nom);
    boolean update(String nom, String updatedDepartemenet,  String updatedTypeAgent, String updatedNom, String updatedPrenom, String updatedEmail, String updatedPassword);
    List<Agent> getAll();
    public void getById(int id);
    void PaiementHistorique(int id);

}
