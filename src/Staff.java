import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Staff extends Person{
    public String username;
    public String password;

    public void setUsername(String username){this.username = username;}
    public void setPassword(String password){this.password = password;}

    public void addStaff(){
        if(first_name.length()==0 || last_name.length()== 0 ||
                phoneNum.length()==0 || email.length()==0 ||
                ins.length()==0 || street.length()==0 ||
                cityAddress.length()==0 || stateAddress.length() == 0){
            System.out.println("all fields must be filled out");

        }else {
            try {
                String setAddressID = "insert into Staff(name_first, name_last, phone, email, health_insur, username, password, adress_1, address_city, address_state) values (? ,? ,?,?,?,?,?,?,?,?)";
                PreparedStatement st = Startup.conn.prepareStatement(setAddressID);
                st.setString(1, first_name);
                st.setString(2, last_name);
                st.setString(3, phoneNum);
                st.setString(4, email);
                st.setString(5, ins);
                st.setString(6,(username));
                st.setString(7,(password));
                st.setString(8, street);
                st.setString(9, cityAddress);
                st.setString(10, stateAddress);
                st.executeUpdate();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void updateStaff(){
        String getStaff = "select * from Staff where name_first = ?";
        try {
            PreparedStatement pstCheck = Startup.conn.prepareStatement(getStaff);
            pstCheck.setString(1,first_name);
            ResultSet rs1 = pstCheck.executeQuery();
            if(!rs1.next()){
                JOptionPane.showMessageDialog(new JFrame(), "No Staff member with that name");
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        String [] updateCheck = {last_name, phoneNum, email, ins, username, password, street, cityAddress, stateAddress};
        String [] dbColumnset = {"name_last", "phone", "email", "health_insur", "username", "password", "adress_1", "address_city", "address_state"};
        ArrayList<String> updatefield = new ArrayList<>();
        ArrayList<String> dbColumn = new ArrayList<>();
        String updateCol = "";
        for(int j = 0; j < 9; j++){
            if(updateCheck[j].length() != 0){
                updatefield.add(updateCheck[j]);
                dbColumn.add(dbColumnset[j]);

            }
        }
        System.out.println(updatefield.size());
        for(int h = 0; h < updatefield.size(); h++){
            String update = "update Staff Set " + dbColumn.get(h) +"=" + "?" +  "where name_first = ?";
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
}
