package scratchbench;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static scratchbench.KController.kmm;
import static scratchbench.enterController.mm;



public class AutoSave  {
MinuteFrame m5=new MinuteFrame();
public AutoSave()
{
    while(true)
    {
   waitFor5();
   saveFiles();
    }
}

    private void waitFor5() {
    try {
        Thread.sleep(5*60*1000);
    } catch (InterruptedException ex) {
        Logger.getLogger(MyTimerTask.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    private void saveFiles() {
     if(id.testint==1)
     {
         mm.saveAll();
     }
     else kmm.saveAll();
     System.out.println("Your Files are being Saved "+new Date());
    }



 
}