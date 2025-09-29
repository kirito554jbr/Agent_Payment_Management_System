package Config;

import java.sql.*;

public class MyJDBC {


    private static MyJDBC instance;

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/ManagerSystem";
    private static final String USER = "root";   // change if different
    private static final String PASSWORD = "root"; // change to your MySQL password


    public static MyJDBC getInstance() {
        if (instance == null) {
            instance = new MyJDBC();  // create only once
        }
        return instance;
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
