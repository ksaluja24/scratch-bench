package scratchbench;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static scratchbench.KController.kmm;
import static scratchbench.enterController.mm;



public class MyTimerTask  {
MinuteFrame m5=new MinuteFrame();
public MyTimerTask()
{
    while(true)
    {
   waitFor55();
   disableForFive();
    }
}

    private void waitFor55() {
    try {
        Thread.sleep(55*1000*60);
    } catch (InterruptedException ex) {
        Logger.getLogger(MyTimerTask.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    private void disableForFive() {
        m5.setVisible(true);
      if(id.testint==1)
      {
      //mm
          mm.setVisible(false);
      }
      else
          if(id.testint==0)
          {
          //kmm
              kmm.setVisible(false);
          }
    try {
        Thread.sleep(5*1000*60);
    } catch (InterruptedException ex) {
        Logger.getLogger(MyTimerTask.class.getName()).log(Level.SEVERE, null, ex);
    }
       if(id.testint==1)
      {
      //mm
          mm.setVisible(true);
      }
      else
          if(id.testint==0)
          {
          //kmm
             kmm.setVisible(true);
          }
       m5.setVisible(false);
    }

 
}