package Config;

import java.sql.*;

public class MyJDBC {
//    public static void main(String[] args) {
//
//        try{
//            Connection conn = DriverManager.getConnection(
//                    "jdbc:mysql://127.0.0.1:3306/test",
//                    "root",
//                    "root"
//            );
//
//            Statement stmt = conn.createStatement();
//            ResultSet resultSet = stmt.executeQuery("SELECT * FROM users");
//
//            while (resultSet.next()){
//                System.out.println(resultSet.getString("username"));
//                System.out.println(resultSet.getString("password"));
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//    }

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
