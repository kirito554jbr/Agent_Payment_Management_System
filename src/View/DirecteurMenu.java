package View;

import Controller.AgentController;
import Controller.DepartmentController;
import Controller.PaiementController;
import Model.Agent;

import java.util.Scanner;

public class DirecteurMenu {

    private AgentController agentController;
    private PaiementController paiementController;
    private DepartmentController departmentController;

    public DirecteurMenu(AgentController agentController, PaiementController paiementController, DepartmentController departmentController){
        this.agentController = agentController;
        this.departmentController = departmentController;
        this.paiementController = paiementController;
    }

    public void displayDirecteur(Scanner scanner, Agent agent){
        int choice;

        do{
            System.out.println("\n====== Menu Directeur ======");
            System.out.println("1. Ajouter un Departement");
            System.out.println("2. Modifier un Departement");
            System.out.println("3. Supprimer un Departement");
            System.out.println("4. Calculer la totale des paiement par Departement");
            System.out.println("5. Se déconnecter");
            System.out.print("👉 Votre choix : ");

            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    scanner.nextLine();
                    System.out.println("👤 Ajout d’une nouvel Departement...");

                    System.out.print("🏢 Département nom : ");
                    String departementName = scanner.nextLine();
                    this.departmentController.create(departementName);
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("✏️ Modification d’une Departement...");

                    System.out.print("🏢 Département nom : ");
                    String oldDepartementName = scanner.nextLine();

                    System.out.print("🏢 Département nouveaux nom : ");
                    String NewdepartementName = scanner.nextLine();

                    this.departmentController.update(oldDepartementName,NewdepartementName);

                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("🗑️ Suppression d’un Departement...");

                    System.out.print("🏢 Département nom : ");
                    String departementNameDelete = scanner.nextLine();

                    this.departmentController.delete(departementNameDelete);
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("Calcule la totale...");

                    System.out.print("🏢 Département nom : ");
                    String departementNameCalcule = scanner.nextLine();

                    this.paiementController.TotalPaiementParDepartement(departementNameCalcule);
                    break;
                case 5:
                    System.out.println("👋 Déconnexion réussie !");
                    break;
            }

        }while (choice != 5);
    }
}
