package Repository;

import DAO.DAO;

import java.util.ArrayList;

public class Repository {

    private DAO dao;
    public Repository() {
        this.dao = new DAO();
    }

    public void create(String tableName , ArrayList<ArrayList<String>> data){

        this.dao.create(tableName, data);
    }

    public void delete(String tableName , int id){
        this.dao.delete(tableName, id);
    }

    public void update(String tableName , ArrayList<ArrayList<String>> data, int id){
        this.dao.update(tableName, data, id);
    }

    public void getAll(String tableName){
        this.dao.getAll(tableName);
    }

    public void getById(String tableName , int id){
        this.dao.getById(tableName, id);
    }
}
