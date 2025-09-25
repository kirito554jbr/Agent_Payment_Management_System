package Service;

import Model.Departement;
import Repository.DepartementRepository;
import Repository.Interface.IDepartementRepositoryInterface;

import java.util.List;

public class DepartementService {

    private final IDepartementRepositoryInterface depatementRepo;

    public DepartementService(){
        this.depatementRepo = new DepartementRepository();
    }

    public void create(String nom){

        Departement departement = new Departement(nom);
        this.depatementRepo.create(departement);
    }

    public void delete(String nom){
        this.depatementRepo.delete(nom);
    }

    public void update(String nom, String updatedNom){
        Departement departement = new Departement(nom);
        this.depatementRepo.update(departement, nom);
    }

    public void getAll(){
        List<Departement> departements = this.depatementRepo.getdAll();
        for (Departement departement : departements) {
            System.out.println(departement);
        }
    }
}
