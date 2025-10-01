package Controller;
import java.util.Scanner;

public class AgentController {
    public static void main(String[] args) {
        AgentController agent = new AgentController();
        agent.displayMsgAgent();

    }

    public void start(){

//        if()
        displayMsgAgent();
    }

//    public void displayMsg(){
//
//        System.out.println("\n============================WELCOME====================================");
//    }




        public void displayMsgAgent() {
            Scanner scanner = new Scanner(System.in);
            int choice;
            int choice2;

            do {
                System.out.println("\n====== Menu Agent ======");
                System.out.println("1. Consulter mes informations personnelles et mon département");
                System.out.println("2. Voir l’historique complet de mes paiements");
                System.out.println("3. Filtrer et trier mes paiements (par type, montant ou date)");
                System.out.println("4. Calculer le total de mes paiements");
                System.out.println("5. Se déconnecter");
                System.out.print("👉 Votre choix : ");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("📌 Consultation des informations personnelles et du département...");
                        // TODO: appel méthode showProfile();
                        break;
                    case 2:
                        System.out.println("📑 Affichage de l’historique complet des paiements...");
                        // TODO: appel méthode showPaymentsHistory();
                        break;
                    case 3:
                        System.out.println("\n====== Filtre Agent ======");
                        System.out.println("1. par type");
                        System.out.println("2. par montant");
                        System.out.println("3. par date");
                        System.out.print("👉 Votre choix : ");
                        choice2 = scanner.nextInt();
                        switch (choice2){
                            case 1:
                            System.out.println("🔍 Filtrage des paiements...");
                        // TODO: appel méthode filterPayments();
                                break;
                            case 2:
                                System.out.println("🔍 Filtrage des paiements...");
                                // TODO: appel méthode filterPayments();
                                break;
                            case 3:
                                System.out.println("🔍 Filtrage des paiements...");
                                // TODO: appel méthode filterPayments();
                                break;
                        }
                        break;
                    case 4:
                        System.out.println("💰 Calcul du total des paiements...");
                        // TODO: appel méthode calculateTotalPayments();
                        break;
                    case 5:
                        System.out.println("👋 Déconnexion réussie !");
                        break;
                    default:
                        System.out.println("❌ Choix invalide, veuillez réessayer.");
                }

            } while (choice != 5);
        }


//======================RESPONSABLE MENU================





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
                    // TODO: addAgent();
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
