package Repository.Interface;

import Model.Paiment;

import java.util.List;

public interface IPaiementRepositoryInterface {

    boolean create(Paiment paiment);
    List<Paiment> getAll();
    Paiment getById(int id);
    boolean delete(int id);
    boolean updateisValide(boolean isValide, int id);

}
