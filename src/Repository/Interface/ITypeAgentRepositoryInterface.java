package Repository.Interface;

public interface ITypeAgentRepositoryInterface {
    void create(String rolenNom);
    void delete(int id);
    void update(int id, String rolenNom);
    void getById(int id);
    int getRoleId(String roleName);
}
