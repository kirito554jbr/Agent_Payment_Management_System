package Service;

import Model.Departement;
import Repository.DepartementRepository;
import Repository.Interface.IDepartementRepositoryInterface;
import Service.Interfaces.IDepartementService;

import java.util.List;

public class DepartementService implements IDepartementService {

    private final IDepartementRepositoryInterface depatementRepo;

    public DepartementService(){
        this.depatementRepo = new DepartementRepository();
    }

        @Override
    public void create(String nom){

        if (nom.isEmpty()){
            System.out.println("Missing required field");
            return;
        }
        Departement departement = new Departement(nom);
       boolean created = this.depatementRepo.create(departement);

        if(created){
            System.out.println("Department created successfully!");
        } else {
            System.out.println("Failed to create department.");
        }
    }
    @Override
    public void delete(String nom){
        if (nom.isEmpty()){
            System.out.println("Missing required field");
            return;
        }
        boolean deleted = this.depatementRepo.delete(nom);

        if(deleted){
            System.out.println("Department deleted successfully!");
        } else {
            System.out.println("Failed to delete department.");
        }
    }
    @Override
    public void update(String nom, String updatedNom){
        if (nom.isEmpty()){
            System.out.println("Missing the required field name");
            return;
        } else if (updatedNom.isEmpty()) {
            System.out.println("Missing the required field updatedNom");
        }

        Departement departement = new Departement(nom);
        boolean updated = this.depatementRepo.update(departement, nom);

        if(updated){
            System.out.println("Department updated successfully!");
        } else {
            System.out.println("Failed to update department.");
        }
    }
    @Override
    public void getAll(){
        List<Departement> departements = this.depatementRepo.getdAll();
        for (Departement departement : departements) {
            System.out.println(departement);
        }
    }
}
