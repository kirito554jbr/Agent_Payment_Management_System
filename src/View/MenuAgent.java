package View;

import Controller.AgentController;
import Controller.PaiementController;
import Model.Agent;

import java.util.Scanner;

public class MenuAgent {

    private AgentController agentController;
    private PaiementController paiementController;

    public MenuAgent(AgentController agentController, PaiementController paiementController){
        this.agentController = agentController;
        this.paiementController = paiementController;
    }


    public void displayMsgAgent(Scanner scanner, Agent agent) {
//        Scanner scanner = new Scanner(System.in);
        int choice;
        int choice2;

        int choiceType;

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
                        this.agentController.getById(agent.getIdAgent());
                    break;
                case 2:
                    System.out.println("📑 Affichage de l’historique complet des paiements...");
                    this.agentController.PaiementHistorique(agent.getIdAgent());
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
                            System.out.println("\n====== Choose which type ======");
                            System.out.println("1. BONUS");
                            System.out.println("2. PRIME");
                            System.out.println("3. SALAIRE");
                            System.out.println("4. INDEMNITE");

                            choiceType = scanner.nextInt();
                            switch (choiceType){
                                case 1:
                                    System.out.println("🔍 Filtrage des paiements...");
                                    this.paiementController.FiltreParType("BONUS", agent.getIdAgent());
                                    break;
                                case 2:
                                    System.out.println("🔍 Filtrage des paiements...");
                                    this.paiementController.FiltreParType("PRIME", agent.getIdAgent());
                                    break;
                                case 3:
                                    System.out.println("🔍 Filtrage des paiements...");
                                    this.paiementController.FiltreParType("SALAIRE", agent.getIdAgent());
                                    break;
                                case 4:
                                    System.out.println("🔍 Filtrage des paiements...");
                                    this.paiementController.FiltreParType("INDEMNITE", agent.getIdAgent());
                                    break;
                            }
                            break;
                        case 2:
                            System.out.print("💰 Entrez le montant minimum: ");
                            double min = scanner.nextDouble();
                            System.out.print("💰 Entrez le montant maximum: ");
                            double max = scanner.nextDouble();
                            this.paiementController.FiltreParMontant(min, max, agent.getIdAgent());
                            break;
                        case 3:
                            scanner.nextLine(); // consume leftover newline
                            System.out.print("📅 Entrez une date (format: yyyy-MM-dd): ");
                            String date = scanner.nextLine();
                            this.paiementController.FiltreParDate(date, agent.getIdAgent());
                            break;
                    }
                    break;
                    case 4:
                        System.out.println("💰 Calcul du total des paiements...");
                        this.agentController.Totale(agent.getIdAgent());
                        break;
                    case 5:
                        System.out.println("👋 Déconnexion réussie !");
                        break;
                    default:
                        System.out.println("❌ Choix invalide, veuillez réessayer.");
                }

        } while (choice != 5);
    }
}
