package Repository.Interface;

import Model.Departement;

import java.util.List;

public interface IDepartementRepositoryInterface {
    void create(Departement departement);
    void delete(String nom);
    void update(Departement departement, String updatedNom);
    //    Departement getById(int id);
    List<Departement> getdAll();
    int findId(String departement);
    Departement findByName(String departement);
    Departement findById(int departement);
}
