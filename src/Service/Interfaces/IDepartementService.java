package Service.Interfaces;

public interface IDepartementService {

    void create(String nom);
    void delete(String nom);
    void update(String nom, String updatedNom);
    void getAll();

}
