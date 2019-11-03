import java.sql.*;
public class Startup {
    public static Connection conn = null;

    protected static Connection connect(){

        try {
            return DriverManager.getConnection("jdbc:mariadb://localhost:3306/gym","root", "");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String [] args) throws SQLException {
        Log_in_Form log_in_form = new Log_in_Form();
        GuiHandler login = new GuiHandler(log_in_form);
        login.buildLogin();
        conn = connect();
        Statement st = conn.createStatement();
    }

}
