import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Log_in_Form extends JFrame{
    private JTextField usernameTextField;
    private JPasswordField passwordPasswordField;
    private JPanel start;
    private JButton log_in;
    String userName;
    String password;
    boolean authentic = false;

    public Log_in_Form(){
        add(start);
        setSize(300,250);

        log_in.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userName = usernameTextField.getText();
                password = passwordPasswordField.getText();
                try {
                    authentic = check();
                    if(authentic){
                        System.out.println("welcome: " + userName);
                        dispose();
                        homePage home = new homePage();
                        GuiHandler guiHome = new GuiHandler(home);
                        guiHome.buildHome();

                    }else{
                        System.out.println("you no belong");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }

    public String[] getLogin(){
        String [] login = {userName, password};
        return login;
    }

    private boolean check() throws SQLException {
        String checkName = "";
        String checkPassword = "";
        String logInCheck = "select username, password from Staff";
        Statement st = Startup.conn.createStatement();
        ResultSet rs = st.executeQuery(logInCheck);
        while(rs.next()){
            checkName = rs.getString(1);
            checkPassword = rs.getString(2);
            if(checkName.equals(userName) && checkPassword.equals(password)){
                return true;
            }
        }
        return false;
    }

}
