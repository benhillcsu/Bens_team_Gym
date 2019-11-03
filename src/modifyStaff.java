import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class modifyStaff extends JFrame{
    private JPanel panel1;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField phone;
    private JTextField email;
    private JTextField insur;
    private JTextField street;
    private JTextField city;
    private JTextField state;
    private JTextField username;
    private JTextField password;
    private JButton update;
    private JButton hire;

    public modifyStaff(){
        add(panel1);
        setSize(1000,500);
        hire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Staff staff = new Staff();
                staff.setFirst_name(firstname.getText());
                staff.setLast_name(lastname.getText());
                staff.setPhoneNum(phone.getText());
                staff.setEmail(email.getText());
                staff.setIns(insur.getText());
                staff.setStreet(street.getText());
                staff.setCityAddress(city.getText());
                staff.setStateAddress(state.getText());
                ((Staff) staff).setUsername(username.getText());
                ((Staff) staff).setPassword(password.getText());
                staff.addStaff();
            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Staff staff = new Staff();
                staff.setFirst_name(firstname.getText());
                staff.setLast_name(lastname.getText());
                staff.setPhoneNum(phone.getText());
                staff.setEmail(email.getText());
                staff.setIns(insur.getText());
                staff.setStreet(street.getText());
                staff.setCityAddress(city.getText());
                staff.setStateAddress(state.getText());
                ((Staff) staff).setUsername(username.getText());
                ((Staff) staff).setPassword(password.getText());
                staff.updateStaff();
            }
        });
    }
}
