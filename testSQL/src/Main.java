import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        String user = "root";
        String password = "01666553995";
        String url = "jdbc:mysql://localhost:3306/test";
        try {
            Connection c = DriverManager.getConnection(url, user, password);
            String sql = "select count(*) from orders";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                System.out.print(rs.getInt("count(*)"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}