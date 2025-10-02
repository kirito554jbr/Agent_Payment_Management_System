package View;

import Controller.AgentController;
import Controller.DepartmentController;
import Controller.PaiementController;

import java.util.Scanner;

public class ResponsableMenu {

    private AgentController agentController;
    private PaiementController paiementController;
    private DepartmentController departmentController;

    public ResponsableMenu(AgentController agentController, PaiementController paiementController, DepartmentController departmentController){
        this.agentController = agentController;
        this.departmentController = departmentController;
        this.paiementController = paiementController;
    }



    public void displayMsgResponsable() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n====== Menu Responsable ======");
            System.out.println("1. Ajouter un agent");
            System.out.println("2. Modifier un agent");
            System.out.println("3. Supprimer un agent");
            System.out.println("4. Affecter un agent à un département");
            System.out.println("5. Ajouter un paiement à un agent");
            System.out.println("6. Consulter et filtrer les paiements d’un agent ou d’un département");
            System.out.println("7. Identifier les paiements inhabituels ou incorrects");
            System.out.println("8. Se déconnecter");
            System.out.print("👉 Votre choix : ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("👤 Ajout d’un nouvel agent...");
                    scanner.nextLine(); // consume leftover newline from previous nextInt()
                    System.out.println("👤 Ajout d’un nouvel agent...");

                    System.out.print("🏢 Département : ");
                    String departementName = scanner.nextLine();

                    System.out.print("🧑‍💼 Type d’agent (ex: ADMIN, AGENT, RESPONSABLE) : ");
                    String typeAgent = scanner.nextLine();

                    System.out.print("👤 Nom : ");
                    String nom = scanner.nextLine();

                    System.out.print("👤 Prénom : ");
                    String prenom = scanner.nextLine();

                    System.out.print("📧 Email : ");
                    String email = scanner.nextLine();

                    System.out.print("🔑 Mot de passe : ");
                    String password = scanner.nextLine();

                    // Envoi des données collectées au contrôleur
                    this.agentController.create(departementName, typeAgent, nom, prenom, email, password);
                    break;
                case 2:
                    System.out.println("✏️ Modification d’un agent...");
                    // TODO: updateAgent();
                    break;
                case 3:
                    System.out.println("🗑️ Suppression d’un agent...");
                    // TODO: deleteAgent();
                    break;
                case 4:
                    System.out.println("🏢 Affectation d’un agent à un département...");
                    // TODO: assignAgentToDepartment();
                    break;
                case 5:
                    System.out.println("💰 Ajout d’un paiement à un agent...");
                    // TODO: addPayment();
                    break;
                case 6:
                    System.out.println("📑 Consultation/filtrage des paiements...");
                    // TODO: viewAndFilterPayments();
                    break;
                case 7:
                    System.out.println("⚠️ Identification des paiements inhabituels ou incorrects...");
                    // TODO: detectAnomalies();
                    break;
                case 8:
                    System.out.println("👋 Déconnexion réussie !");
                    break;
                default:
                    System.out.println("❌ Choix invalide, veuillez réessayer.");
            }

        } while (choice != 8);
    }
}
