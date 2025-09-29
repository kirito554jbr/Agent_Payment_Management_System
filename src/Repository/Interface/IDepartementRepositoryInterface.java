package Repository.Interface;

import Model.Departement;

import java.util.List;

public interface IDepartementRepositoryInterface {
    boolean create(Departement departement);
    boolean delete(String nom);
    boolean update(Departement departement, String updatedNom);
    //    Departement getById(int id);
    List<Departement> getdAll();
    int findId(String departement);
    Departement findByName(String departement);
    Departement findById(int departement);
}
