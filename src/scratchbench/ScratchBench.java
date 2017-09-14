/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scratchbench;

import java.awt.*;
import java.awt.geom.*;
import java.awt.SplashScreen;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;



/**
 *
 * @author Kp Saluja
 */
public class ScratchBench {

    /**
     * @param args the command line arguments
     *//**
     * Prepare the global variables for the other splash functions
     */
  static SplashScreen mySplash;                   // instantiated by JVM we use it to get    graphics
static Graphics2D splashGraphics;               // graphics context for overlay of the splash image
static Rectangle2D.Double splashTextArea;       // area where we draw the text
static Rectangle2D.Double splashProgressArea;// area where we draw the progress bar
static Login test;
static Font font;                               // used to draw our text
    private static void splashInit()
    {
        mySplash = SplashScreen.getSplashScreen();
        if (mySplash != null)
        {   // if there are any problems displaying the splash this will be null
            Dimension ssDim = mySplash.getSize();
            int height = ssDim.height;
            int width = ssDim.width;
            
            // stake out some area for our status information
            splashTextArea = new Rectangle2D.Double(15., height*0.88, width *3, 32.);
            splashProgressArea = new Rectangle2D.Double(4, height*0.822, width-7.1,2);

            // create the Graphics environment for drawing status info
            splashGraphics = mySplash.createGraphics();
             font = new Font("Dialog", Font.ROMAN_BASELINE, 14);
            splashGraphics.setFont(font);
            
            // initialize the status info
            splashText("Starting...");
            splashProgress(0);
        }
    }
    /**
     * Display text in status area of Splash.  Note: no validation it will fit.
     * @param str - text to be displayed
     */
    public static void splashText(String str)
    {
        if (mySplash != null && mySplash.isVisible())
        {   // important to check here so no other methods need to know if there
            // really is a Splash being displayed

            // erase the last status text
          

            // draw the text
            splashGraphics.setPaint(Color.WHITE);
            splashGraphics.drawString(str, (int)(splashTextArea.getX() + 10),(int)(splashTextArea.getY() + 15));

            // make sure it's displayed
            mySplash.update();
        }
    }/**
     * Display a (very) basic progress bar
     * @param pct how much of the progress bar to display 0-100
     */
    public static void splashProgress(int pct)
    {
        if (mySplash != null && mySplash.isVisible())
        {

            // Note: 3 colors are used here to demonstrate steps
            // erase the old one
            splashGraphics.setPaint(Color.WHITE);
            splashGraphics.fill(splashProgressArea);

            // draw an outline
            splashGraphics.setPaint(Color.RED);
            splashGraphics.draw(splashProgressArea);

            // Calculate the width corresponding to the correct percentage
            int x = (int) splashProgressArea.getMinX();
            int y = (int) splashProgressArea.getMinY();
             int wid = (int) splashProgressArea.getWidth();
            int hgt = (int) splashProgressArea.getHeight();

            int doneWidth = Math.round(pct*wid/100.f);
            doneWidth = Math.max(0, Math.min(doneWidth, wid-1));  // limit 0-width

            // fill the done part one pixel smaller than the outline
            splashGraphics.setPaint(Color.RED);
            splashGraphics.fillRect(x, y+1, doneWidth, hgt-1);

            // make sure it's displayed
            mySplash.update();
        }
    }
    /**
     * just a stub to simulate a long initialization task that updates
     * the text and progress parts of the status in the Splash
     */
    private static void appInit() throws InterruptedException
    {
        test = new Login();
        SwingUtilities.invokeLater(() -> {
           try { 
               test.initSwingComponents();
           } catch (InterruptedException ex) {
               Logger.getLogger(ScratchBench.class.getName()).log(Level.SEVERE, null, ex);
           }
       } );
    
        int i=0;
        while(i<100)
        {
        splashProgress(i++);
        Thread.sleep(20);
        }
           

            
            
        
    }
    public static void main(String[] args) throws InterruptedException {
        
        
        // TODO code application logic here
         splashInit();           // initialize splash overlay drawing parameters
        appInit();              // simulate what an application would do 
                                // before starting
        if (mySplash != null)   mySplash.close();
test.setVisible(true);

        
    }
    
}
