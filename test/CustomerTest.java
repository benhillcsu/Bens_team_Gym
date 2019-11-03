import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer testCustomer = new Customer();

    @Test
    void setAccountStatus() {
        assertNull(testCustomer.accountStatus);
        testCustomer.setAccountStatus("test");
        assertEquals("test",testCustomer.accountStatus);
    }

    @Test
    void customerUpdate() throws SQLException {
        Connection testcon = DriverManager.getConnection("jdbc:mariadb://localhost:3306/gym","root", "");
        testCustomer.setFirst_name("Test");
        String testquery = "select * from Customer where name_first = ?";
        assertNotNull(testcon);
        PreparedStatement testpst = testcon.prepareStatement(testquery);
        testpst.setString(1,"test");
        ResultSet testrd = testpst.executeQuery();
        assertNotNull(testrd);
        PreparedStatement testpst1 = testcon.prepareStatement(testquery);
        testpst1.setString(1,"brittany");
        testrd = testpst1.executeQuery();
        testrd.next();
        assertEquals("hill", testrd.getString(3));

    }

    @Test
    void setDisable() {
    }

    @Test
    void setActive() {
    }
}