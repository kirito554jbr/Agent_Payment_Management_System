package View;

import Controller.AgentController;
import Controller.AuthController;
import Controller.DepartmentController;
import Controller.PaiementController;
import Model.Agent;
import Model.Departement;
import Repository.AgentRepository;
import Repository.DepartementRepository;
import Repository.Interface.IAgentRepositoryInterface;
import Repository.Interface.IDepartementRepositoryInterface;
import Repository.Interface.IPaiementRepositoryInterface;
import Repository.PaiementRepository;
import Service.AgentService;
import Service.AuthService;
import Service.DepartementService;
import Service.Interfaces.IAgentService;
import Service.Interfaces.IAuthService;
import Service.Interfaces.IDepartementService;
import Service.Interfaces.IPaiementService;
import Service.PaimentService;

import java.util.Scanner;

public class Auth {

    private AuthController authController;
    private MenuAgent menuAgent;
    private ResponsableMenu menuResponsable;
    private DirecteurMenu directeurMenu;

    public Auth(AuthController authController,MenuAgent menuAgent,ResponsableMenu menuResponsable, DirecteurMenu directeurMenu) {
        this.authController = authController;
        this.menuAgent = menuAgent;
        this.menuResponsable = menuResponsable;
        this.directeurMenu = directeurMenu;
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
                    this.menuResponsable.displayMsgResponsable(scanner, isAuthenticated);
                } else if (isAuthenticated.getTypeAgent() == "DIRECTOR") {
                    this.directeurMenu.displayDirecteur(scanner, isAuthenticated);
                }
            } else {
                System.out.println("❌ Identifiants invalides. Veuillez réessayer.");
            }

    }
    public static void main(String[] args) {
        IDepartementRepositoryInterface iDepartementRepositoryInterface=new DepartementRepository();
//        IAgentRepositoryInterface iAgentRepositoryInterface=new AgentRepository();
//        Departement departement=new Departement();
//        IPaiementService paiementService=new PaimentService();
//        IAgentService agentService=new AgentService(iDepartementRepositoryInterface,iAgentRepositoryInterface,departement,);
//        IDepartementService departementService=new DepartementService();
//        AuthController authController1=new AuthController();
//        IAuthService authService=new AuthService();
//        MenuAgent menuAgent1=new MenuAgent();
//        AgentController agentController=new AgentController();
//        ResponsableMenu responsableMenu=new ResponsableMenu();
//        IPaiementRepositoryInterface paiementRepository=new PaiementRepository();
//        IPaiementService paiementService=new PaimentService();

        Auth auth = new Auth(new AuthController(new AuthService(new AgentRepository())), new MenuAgent(new AgentController(new AgentService(new DepartementRepository(), new AgentRepository(), new Departement(),new PaimentService(new PaiementRepository(), new DepartementService(), new AgentService()))), new PaiementController(new PaimentService(new PaiementRepository(), new DepartementService(), new AgentService()))), new ResponsableMenu(new AgentController(new AgentService(new DepartementRepository(), new AgentRepository(), new Departement(),new PaimentService(new PaiementRepository(), new DepartementService(), new AgentService()))), new PaiementController(new PaimentService(new PaiementRepository(), new DepartementService(), new AgentService())), new DepartmentController(new DepartementService())), new DirecteurMenu(new AgentController(new AgentService(new DepartementRepository(), new AgentRepository(), new Departement(), new PaimentService(new PaiementRepository(), new DepartementService(), new AgentService()))), new PaiementController(new PaimentService(new PaiementRepository(),new DepartementService(), new AgentService())), new DepartmentController(new DepartementService())));
        auth.start();
    }
}
