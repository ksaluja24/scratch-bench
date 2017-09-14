package scratchbench;

import Server.interfaces.ServerInterface;
import java.awt.*;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.Duration;
import javax.swing.JFrame;




public class Login extends JFrame {
        JFXPanel jfxPanel;
       
    public static ServerInterface serverAddress;
    
    {
        
      
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
       setSize(d.width,d.height);
       setAlwaysOnTop(true);
        setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(false);
    
        connectServer();
    
    }
    
      public void connectServer() {
     try
        {
            Registry reg=LocateRegistry.getRegistry("localhost",5040);

            serverAddress = (ServerInterface) reg.lookup("LionKing");
            System.out.println("Connected to Server");
        
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void initSwingComponents() throws InterruptedException {
        
     
        jfxPanel = new JFXPanel();
       add(jfxPanel, BorderLayout.CENTER);

      Thread.sleep(100);
        Platform.runLater(() -> initFX(jfxPanel));
    }

    private  void initFX(JFXPanel jfxPanel) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("email.fxml"));
            Scene scene = new Scene(root,500, 500);
            scene.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());
            jfxPanel.setScene(scene);
        } catch (IOException exc) {
            exc.printStackTrace();
            System.exit(1);
        }
    }
    public void loadSecondFxml(String fxml) throws IOException{
    //Load new FXML and assign it to scene

    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
    Parent root = (Parent) fxmlLoader.load();
    FadeTransition ft = new FadeTransition(Duration.millis(500),root);
    ft.setFromValue(0.5);
    ft.setToValue(1.0);
    ft.play();
    Scene scene = new Scene(root, 600, 65);
    jfxPanel.setScene(scene);
}

   
}