package Model;

public class Role {

    private int id;
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

//    public void createRole(String roleName) {
//        String sql = "INSERT INTO role (roleName) VALUES (?)";
//
//        try (Connection conn = MyJDBC.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//
//        } catch (SQLData e) {
//            e.printStackTrace();
//        }
//    }
}
