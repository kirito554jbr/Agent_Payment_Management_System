package View;

import Controller.AgentController;
import Controller.AuthController;
import Controller.PaiementController;
import Model.Agent;
import Model.Departement;
import Repository.AgentRepository;
import Repository.DepartementRepository;
import Service.AgentService;
import Service.AuthService;
import Service.PaimentService;

import java.util.Scanner;

public class Auth {

    private AuthController authController;
    private MenuAgent menuAgent;

    public Auth(AuthController authController,MenuAgent menuAgent) {
        this.authController = authController;
        this.menuAgent = menuAgent;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Agent isAuthenticated = null;

        while (isAuthenticated == null) {
            System.out.println("====== Connexion Agent ======");
            System.out.print("📧 Email : ");
            String email = scanner.nextLine();
            System.out.print("🔑 Mot de passe : ");
            String password = scanner.nextLine();

            isAuthenticated = this.authController.LogIn(email, password);

            if(isAuthenticated == null){
                System.out.println("❌ Identifiants invalides. Veuillez réessayer.\n");
            }
        }
            if (isAuthenticated != null) {
                System.out.println("✅ Connexion réussie !");
                if(isAuthenticated.getTypeAgent() == "WORKER" || isAuthenticated.getTypeAgent() == "TRAINEE"){
                this.menuAgent.displayMsgAgent(scanner, isAuthenticated); // lancer le menu
                } else if (isAuthenticated.getTypeAgent() == "DEPARTMENT_MANAGER") {
                    //this.menuResponsable.diplayResponsable(scanner, isAuthenticated);
                }
            } else {
                System.out.println("❌ Identifiants invalides. Veuillez réessayer.");
            }

    }
    public static void main(String[] args) {
        Auth auth = new Auth(new AuthController(new AuthService(new AgentRepository())), new MenuAgent(new AgentController(new AgentService(new DepartementRepository(), new AgentRepository(), new Departement(),new PaimentService())), new PaiementController(new PaimentService())));
        auth.start();
    }
}
