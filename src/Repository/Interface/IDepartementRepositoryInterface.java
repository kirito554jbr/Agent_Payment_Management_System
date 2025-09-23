package Repository.Interface;

public interface IDepartementRepositoryInterface {
    public void create();
    public void delete();
    public void update();
    public void findById();
    public void findAll();
    public int findId(String departement);
}
