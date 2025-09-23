package Repository.Interface;

public interface IAgentRepositoryInterface {

    public void create(int departemenet, int role, String nom, String prenom, String email, String password );
    public void delete();
    public void update();
    public void findById();
    public void findAll();
    public void findByName();
}
