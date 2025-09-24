package Repository.Interface;

import Model.Departement;

public interface IDepartementRepositoryInterface {
    void create();
    void delete();
    void update();
    Departement getById(int id);
    void findAll();
    int findId(String departement);
}
