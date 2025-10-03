package View;

import Controller.AgentController;
import Controller.DepartmentController;
import Controller.PaiementController;
import Model.Agent;

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



    public void displayMsgResponsable(Scanner scanner, Agent agent) {
//        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n====== Menu Responsable ======");
            System.out.println("1. Ajouter un agent");
            System.out.println("2. Modifier un agent");
            System.out.println("3. Supprimer un agent");
//            System.out.println("4. Affecter un agent à un département");
            System.out.println("4. Ajouter un paiement à un agent");
            System.out.println("5. Consulter et filtrer les paiements d’un agent");
            System.out.println("6. Calculer la totale des paiement par agent");
            System.out.println("7. Valider Un paiement");
            System.out.println("8. Se déconnecter");
            System.out.print("👉 Votre choix : ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
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
                    scanner.nextLine();
                    System.out.println("✏️ Modification d’un agent...");

                    System.out.println("🧑‍💼 old Agent name");
                    String oldName = scanner.nextLine();

                    System.out.print("🏢 Département : ");
                    String updatedDepartemenet = scanner.nextLine();

                    System.out.print("🧑‍💼 Type d’agent (ex: TRAINEE, WORKER) : ");
                    String updatedTypeAgent = scanner.nextLine();

                    System.out.print("👤 Nom : ");
                    String updatedNom = scanner.nextLine();

                    System.out.print("👤 Prénom : ");
                    String updatedPrenom = scanner.nextLine();

                    System.out.print("📧 Email : ");
                    String updatedEmail = scanner.nextLine();

                    System.out.print("🔑 Mot de passe : ");
                    String updatedPassword = scanner.nextLine();

                    this.agentController.update(oldName, updatedDepartemenet, updatedTypeAgent, updatedNom, updatedPrenom, updatedEmail, updatedPassword);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("🗑️ Suppression d’un agent...");

                    System.out.println("🚶 Agent name");
                    String NameToDelete = scanner.nextLine();
                    this.agentController.delete(NameToDelete);
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("✏️ Ajouter un paiement...");

                    System.out.print("👤 Nom : ");
                    String AgentName = scanner.nextLine();

                    System.out.println("💰 Paiement Type , ex (SALAIRE, PRIME, BONUS, INDEMNITE)");
                    String typePaiement = scanner.nextLine();

                    System.out.print("💰 montant : ");
                    double montant  = Double.parseDouble(scanner.nextLine());

                    System.out.print("🧐 Motif? : ");
                    String motif = scanner.nextLine();


                    System.out.println("💰 Ajout d’un paiement à un agent...");
                    this.paiementController.create(typePaiement, montant, motif, AgentName);
                    break;
                case 5:
                    scanner.nextLine();

                    System.out.print("👤 Nom : ");
                    String AgentNom = scanner.nextLine();

                    System.out.println("📑 Consultation/filtrage des paiements...");
                    this.paiementController.FiltrePaymentParAgent(AgentNom);
                    break;
                case 6:
                    scanner.nextLine();

                    System.out.print("👤 Nom : ");
                    String Nom = scanner.nextLine();
                    System.out.println("Calculation en cours...");
                    this.paiementController.TotaleParAgent(Nom);

                    break;
                case 7:
                    scanner.nextLine();

                    System.out.print("👤 Nom : ");
                    String Nome = scanner.nextLine();

                    this.paiementController.FiltrePaymentParAgent(Nome);
                    System.out.print("📑 IdPaiement : ");
                    int IdPaiement = Integer.parseInt(scanner.nextLine());
                    System.out.print("True✅ or False❌ : ");
                    Boolean isValid = Boolean.valueOf(scanner.nextLine());

                    this.paiementController.updateIsValide(isValid, IdPaiement);
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
