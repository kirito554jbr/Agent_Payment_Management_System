package Repository.Interface;

public interface ITypeAgentRepositoryInterface {
    public void create(String rolenNom);
    public void delete(int id);
    public void update(int id, String rolenNom);
    public void getById(int id);
    public int getRoleByName(String roleName);
}
