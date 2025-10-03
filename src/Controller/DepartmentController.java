package Controller;

import Service.Interfaces.IDepartementService;

public class DepartmentController {

    private IDepartementService departementService;

    public DepartmentController(IDepartementService departementService) {
        this.departementService = departementService;
    }

    public void start(){
        displayMsg();
    }

    public void displayMsg(){


    }

    public void create(String nom){
        this.departementService.create(nom);
    }

    public void update(String nom, String updatedNom){
        this.departementService.update(nom, updatedNom);
    }

    public void delete(String nom){
        this.departementService.delete(nom);
    }


}
