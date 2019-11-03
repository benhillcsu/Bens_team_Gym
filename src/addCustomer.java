import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class addCustomer extends JFrame{
    private JPanel panel1;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField phone;
    private JTextField email;
    private JTextField insurance;
    private JTextField address;
    private JTextField city;
    private JButton reg;
    private JButton updateCustomerInfoButton;
    private JTextField state;
    private JRadioButton activateRadioButton;
    private JRadioButton disableRadioButton;
    private ButtonGroup bg = new ButtonGroup();

    public addCustomer(){
        add(panel1);
        setSize(1000,500);
        bg.add(activateRadioButton);
        bg.add(disableRadioButton);
        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person customer = new Customer();
                customer.setFirst_name(firstname.getText());
                customer.setLast_name(lastname.getText());
                customer.setPhoneNum(phone.getText());
                customer.setEmail(email.getText());
                customer.setIns(insurance.getText());
                customer.setStreet(address.getText());
                customer.setCityAddress(city.getText());
                customer.setStateAddress(state.getText());

                if(customer.first_name.length()==0 || customer.last_name.length()== 0 ||
                        customer.phoneNum.length()==0 || customer.email.length()==0 ||
                        customer.ins.length()==0 || customer.street.length()==0 ||
                        customer.cityAddress.length()==0 || customer.stateAddress.length() == 0){
                    System.out.println("all fields must be filled out");

                }else {
                    try {
                        String setAddressID = "insert into Customer(name_first, name_last, phone, email, health_insur, adress_1, address_city, address_state) values (? ,? ,?,?,?,?,?,?)";
                        PreparedStatement st = Startup.conn.prepareStatement(setAddressID);
                        st.setString(1, customer.first_name);
                        st.setString(2, customer.last_name);
                        st.setString(3, customer.phoneNum);
                        st.setString(4, customer.email);
                        st.setString(5, customer.ins);
                        st.setString(6, customer.street);
                        st.setString(7, customer.cityAddress);
                        st.setString(8, customer.stateAddress);
                        st.executeUpdate();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        updateCustomerInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person customer = new Customer();
                customer.setFirst_name(firstname.getText());
                customer.setLast_name(lastname.getText());
                customer.setPhoneNum(phone.getText());
                customer.setEmail(email.getText());
                customer.setIns(insurance.getText());
                customer.setStreet(address.getText());
                customer.setCityAddress(city.getText());
                customer.setStateAddress(state.getText());
                ((Customer) customer).customerUpdate();
                if(disableRadioButton.isSelected()){
                    try {
                        ((Customer) customer).setDisable();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                if(activateRadioButton.isSelected()){
                    try {
                        ((Customer) customer).setActive();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

    }


    private ResultSet getData(Statement st, String query) throws SQLException {
        ResultSet rs = st.executeQuery(query);
        return rs;
    }

}
