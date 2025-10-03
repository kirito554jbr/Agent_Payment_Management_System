package Service.Interfaces;

import Model.Departement;

import java.util.List;

public interface IDepartementService {

    void create(String nom);
    void delete(String nom);
    void update(String nom, String updatedNom);
    List<Departement> getAll();
    int findId(String departement);

}
