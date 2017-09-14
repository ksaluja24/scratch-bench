/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scratchbench;


import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import static scratchbench.Login.serverAddress;
import static scratchbench.ScratchBench.test;
import static scratchbench.loginController.message;





/**
 * FXML Controller class
 *
 * @author Kp Saluja
 */
public class enterController extends AnchorPane implements Initializable {
@FXML
private Label emailLabel;
@FXML
private Text cancelLabel;
@FXML
private Button loginButton;
@FXML
private PasswordField passwordField;
private String name;
public static  String obtainedPassword;
@FXML
private Label errorLabel;
@FXML
        private Text k;
public static MainMenu mm;
@FXML
private Label messageLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
     
    try {
        System.out.println("Enter Controller"+id.id);
        String abc=serverAddress.getNameAndPassword(id.id);
        System.out.println(abc);
        String tukde[]=abc.split(",");
        name=tukde[0];
        obtainedPassword=tukde[1];
        emailLabel.setText("Dear "+name);
        cancelLabel.setText("Not "+name+"..?");
        messageLabel.setText(message);
    } catch (RemoteException ex) {
        Logger.getLogger(enterController.class.getName()).log(Level.SEVERE, null, ex);
    }
      
    }

    
@FXML
private void gotoSignIn() throws InterruptedException
{
    try {
        test.loadSecondFxml("email.fxml");
    } catch (IOException ex) {
        Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
    }
}
  
@FXML
private void processLogin(ActionEvent event) throws InterruptedException
{

if(passwordField.getText().equals(obtainedPassword))
{
    id.testint=1;
mm=new MainMenu();
mm.setVisible(true);
        test.dispose();
}
else 
    
{
   errorLabel.setText("Invalid Password..!!");
   passwordField.setText("");
   
}}
@FXML
private void pwdTyped(KeyEvent k)
{
errorLabel.setText("");
}


}