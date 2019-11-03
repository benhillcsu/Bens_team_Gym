import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class StartupTest {

    @Test
    void connect() throws SQLException {
        Connection testcon = DriverManager.getConnection("jdbc:mariadb://localhost:3306/gym","root", "");
        assertNotNull(testcon);
    }
}