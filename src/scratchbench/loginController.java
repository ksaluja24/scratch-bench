/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scratchbench;



import Server.interfaces.ServerInterface;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.sql.DriverManager;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import static scratchbench.KController.email;
import static scratchbench.ScratchBench.test;
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
import static scratchbench.Login.serverAddress;




/**
 * FXML Controller class
 *
 * @author Kp Saluja
 */
public class loginController extends AnchorPane implements Initializable {
@FXML
private CheckBox agreeBox;
String name;
String password;
String firstname,lastname;
@FXML
private Label nameError;
@FXML
private Label passwordError;
@FXML
private Label checkLabel;
@FXML
private Label label;
@FXML
private Text text;
@FXML
private TextField emailTF;
@FXML
private TextField nameTF;
@FXML
private PasswordField passwordTF;
String tukde[];
public static String message;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      emailTF.setText(email);
      message=" ";
      nameTF.requestFocus();
    }
    @FXML
private void setTrue()
{
if(agreeBox.isSelected()==true)
{
label.setText(":)");

checkLabel.setText("");
}else{
label.setText("");
}
}

@FXML
private void gotoSignIn()
{
    try {
        test.loadSecondFxml("email.fxml");
    } catch (IOException ex) {
        Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
    }
}

@FXML private void nameTyped(KeyEvent k)
    {
      if(!(nameTF.getText().length()==0))  
      {
      nameError.setText("");
      }
  
      
    }
   
@FXML private void passwordTyped(KeyEvent k)
    {
     if(!(passwordTF.getText().length()==0))  
      {
      passwordError.setText("");
      }
    }
@FXML
public void gotoRegister() throws RemoteException
{
    
if(nameTF.getText().length()==0)
{
 nameError.setText("Please enter your name");   
}
else
if(passwordTF.getText().length()==0)
{
   passwordError.setText("Please enter a new password");
   
}
else
if(agreeBox.isSelected()==false)
{
 checkLabel.setText("Please agree to the terms of service");

}else
{
    lastname="";
name=nameTF.getText();
password=passwordTF.getText();
tukde=name.split(" ");
if(tukde.length==2)
{
firstname=tukde[0];
lastname=tukde[1];
}
else{
    firstname=name;
}
boolean b=serverAddress.registerToDatabase(email,password,id.id,firstname,lastname);
id.id=serverAddress.getRegisterId();
System.out.println("Id caught by regiser "+id.id);
if(b==true)
{
message="You have been successfully registered";
        try {
            test.loadSecondFxml("enter.fxml");
        } catch (IOException ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
else
{
message="";
}
    

}

}


}
