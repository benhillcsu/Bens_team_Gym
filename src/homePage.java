

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class homePage extends JFrame {
    private JButton newcust;
    private JButton hireStaffButton;
    private JButton viewCurrentCustomersButton;
    private JPanel home;

    public homePage(){
        add(home);
        setSize(300, 300);
        viewCurrentCustomersButton.addActionListener(e -> {

        });

        newcust.addActionListener(e -> {
            addCustomer cust = new addCustomer();
            GuiHandler customer= new GuiHandler(cust);
            customer.newCustomer();
        });
        viewCurrentCustomersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                        displayTable disp = new displayTable();
                        GuiHandler displayTable = new GuiHandler(disp);
                        displayTable.displayTable();
            }
        });
        hireStaffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyStaff modifyStaff = new modifyStaff();
                GuiHandler staff = new GuiHandler(modifyStaff);
                staff.modifyStaff();
            }
        });
    }
}
