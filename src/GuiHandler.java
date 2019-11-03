import javax.swing.*;

public class GuiHandler {
    Log_in_Form login;
    homePage home;
    addCustomer addCustomer;
    displayTable displayTable;
    modifyStaff modifyStaff;
    public GuiHandler(Log_in_Form log){
        this.login = log;
    }
    public GuiHandler(homePage home){this.home = home; }
    public GuiHandler(addCustomer addCustomer){this.addCustomer = addCustomer;}
    public GuiHandler(displayTable displayTable){this.displayTable = displayTable;}
    public GuiHandler(modifyStaff modifyStaff){this.modifyStaff = modifyStaff;}
    public void buildLogin(){
        login.setVisible(true);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void buildHome(){
        home.setVisible(true);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void newCustomer(){
        addCustomer.setVisible(true);
        //addCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void displayTable(){
        displayTable.setVisible(true);
        //displayTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void modifyStaff(){
        modifyStaff.setVisible(true);
    }
}
