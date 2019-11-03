import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Customer extends Person{
    String accountStatus;
    String getCustomer = "select * from Customer where name_first = ?";
    public void setAccountStatus(String accountStatus){this.accountStatus = accountStatus;}

    public void customerUpdate(){
        try {
            PreparedStatement pstCheck = Startup.conn.prepareStatement(getCustomer);
            pstCheck.setString(1,first_name);
            ResultSet rs1 = pstCheck.executeQuery();
            if(!rs1.next()){
                JOptionPane.showMessageDialog(new JFrame(), "No user with that name");
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        String [] updateCheck = {last_name, phoneNum, email, ins, street, cityAddress, stateAddress};
        String [] dbColumnset = {"name_last", "phone", "email", "health_insur", "adress_1", "address_city", "address_state"};
        ArrayList<String> updatefield = new ArrayList<>();
        ArrayList<String> dbColumn = new ArrayList<>();
        String updateCol = "";
        for(int j = 0; j < 7; j++){
            if(updateCheck[j].length() != 0){
                updatefield.add(updateCheck[j]);
                dbColumn.add(dbColumnset[j]);

            }
        }
        System.out.println(updatefield.size());
        for(int h = 0; h < updatefield.size(); h++){
            String update = "update Customer Set " + dbColumn.get(h) +"=" + "?" +  "where name_first = ?";
            try {
                PreparedStatement updateCustField = Startup.conn.prepareStatement(update);
                updateCustField.setString(1,updatefield.get(h));
                updateCustField.setString(2,first_name);
                updateCustField.executeUpdate();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }

    public void setDisable() throws SQLException {
        String disable = "Update Customer set account_status = 'disabled' where name_first = ?";
        PreparedStatement dpst = Startup.conn.prepareStatement(disable);
        dpst.setString(1,first_name);
        dpst.executeUpdate();
    }
    public void setActive() throws SQLException {
        String disable = "Update Customer set account_status = 'active' where name_first = ?";
        PreparedStatement dpst = Startup.conn.prepareStatement(disable);
        dpst.setString(1,first_name);
        dpst.executeUpdate();
    }

}
