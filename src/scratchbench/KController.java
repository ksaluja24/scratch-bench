/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scratchbench;




import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import static scratchbench.Login.serverAddress;
import static scratchbench.ScratchBench.test;





/**
 * FXML Controller class
 *
 * @author Kp Saluja
 */
public class KController extends AnchorPane implements Initializable {
@FXML
    private Button loginButton;
@FXML
    private TextField userNameTF;
@FXML
    private Button testUserButton;
@FXML
        private Label validateTrueLabel;
@FXML
        private Label validateFalseLabel;
@FXML
        private AnchorPane content;
  public static  MainMenu kmm;
    public static String email="";
    public static String password;
private boolean b;
private boolean emailExists;

    /**
     * Initializes the controller class.
     */



    @Override
    public void initialize(URL url, ResourceBundle rb) { 
       b=false;
    }    
@FXML
    public void processLogin(ActionEvent event) throws InterruptedException {   
       login();
    }
@FXML
private void continueAsTest() throws IOException
{
    kmm=new MainMenu();
                
        kmm.setVisible(true);
        test.dispose();
        
      callThreads();
}
    private void continueAsRegistered() throws  IOException {
        callThreads();
if(b==true)
{
    String email=userNameTF.getText();
        if(serverAddress.existsByEmail(email)==true)
        {
            id.id=serverAddress.getID();
        test.loadSecondFxml("enter.fxml");
        
        System.out.println("KController:  "+id.id);
        password=serverAddress.getPassword();
        }
        else
        {
         test.loadSecondFxml("login.fxml");
        }
}
    }
    @FXML
    private void emailcheck(KeyEvent k)
    {
    String c=k.getCharacter();
   if(c.equals(" "))
   {
        k.consume();
   }
     String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      if(userNameTF.getText().matches(EMAIL_REGEX))
      {
      validateFalseLabel.setVisible(false);
      validateTrueLabel.setVisible(true);
      validateTrueLabel.setText("Kindly click on Login");
      b=true;
      }
      else
      {
          validateTrueLabel.setVisible(false);
          validateFalseLabel.setVisible(true);
          validateFalseLabel.setText("Invalid E-Mail Format");
          b=false;
      }
     
         
    }

    @FXML 
    private void login() {
        email=userNameTF.getText();
       if(email.length()==0)
       {
         
           try {
               continueAsTest();
           } catch (IOException ex) {
               Logger.getLogger(KController.class.getName()).log(Level.SEVERE, null, ex);
           }
          
       }
       else
       {
           try {
               continueAsRegistered();
           } catch (IOException ex) {
               Logger.getLogger(KController.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
 
    }

    private void callThreads() {
          Thread t1=new Thread(new Runnable(){
        
        @Override
        public void run()
        {
        new MyTimerTask();
        }
        });
        Thread t2=new Thread(new Runnable(){
        
        @Override
        public void run()
        {
        new AutoSave();
        }
        });
    
t1.start();
t2.start();
    }
 

  

}