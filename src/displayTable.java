import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class displayTable extends JFrame{
    private JTable table1;
    private JTextField first;
    private JTextField last;
    private JButton findButton;
    private JPanel panel1;

    public displayTable(){
        add(panel1);
        setSize(1000,500);
        DefaultTableModel model = new DefaultTableModel();
        String [] header = {"Name", "Phone", "Email", "Insurance", "Address", "Account Status"};
        model.setColumnIdentifiers(header);
        table1.setModel(model);


        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = first.getText();
                String lastName = last.getText();
                String query = "select * from Customer where name_first = ? and name_last = ?";
                try {
                    PreparedStatement pst = Startup.conn.prepareStatement(query);
                    pst.setString(1,firstName);
                    pst.setString(2,lastName);
                    ResultSet rs = pst.executeQuery();
                    ResultSetMetaData rsm = rs.getMetaData();
                    int col = rsm.getColumnCount();
                    while(rs.next()){
                        String name = rs.getString(2) + " " + rs.getString(3);
                        String phone = rs.getString(4);
                        String email = rs.getString(5);
                        String insurance = rs.getString(6);
                        String address = rs.getString(7) + " " + rs.getString(8) + ", " + rs.getString(9);
                        String status = rs.getString(10);
                        String [] row = {name, phone, email, insurance, address, status};
                        model.addRow(row);
                    }


                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });
    }
}
