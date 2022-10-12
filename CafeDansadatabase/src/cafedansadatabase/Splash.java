package cafedansadatabase;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.UIManager;
import javax.swing.text.AbstractDocument.Content;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*Splash.java
* A class representing the Splash screen used by the Cities.Java
* GUI used in a maintaining a USA cities database. 
*<pre>
* Project       Cafe Dansa database
* Description   A class representing the Splash screen used by the DancerGUI.java in a maintaining dance database
* Platform      1.8.0_51-b16 ,NetBeans IDE 15;Windows 10
* Course        CS 142
* Date          9/29/2022
* @author       <i>Abylay Dospayev</i>
* @version      1.0.4
* @see          java.awt.Color
* @see          java.awt.Toolkit
* @see          javax.BorderFactory
* Date          10/102022
* History Log      
*</pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
public class Splash extends JWindow
{
    //duration is integer value in milliseconds for how long the Splash screen is visible 
    private int duration;
    private JProgressBar loading = new JProgressBar(); //progress bar
    private int progress;
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
    *<pre>
    * 
    * Description   Constructor assigns distance variable duration that've been past to it 
    * Date          9/29/2022
    * @param        dur int
    * @author       <i>Abylay Dospayev</i>
    * Date          9/28/2022
    * History Log      
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public Splash(int dur)
    {
        duration = dur;
        UIManager.put("ProgressBar.selectionBackground", Color.ORANGE);
        UIManager.put("ProgressBar.selectionForeground", Color.white);
        UIManager.put("ProgressBar.foreground", new Color(255, 0, 0, 1));
        loading = new JProgressBar(0, 100);
        loading.setStringPainted(true);
    }
    //A simple little method to show a title screen in the center 
    //of the screen for the amount of time given in the constructor 
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
    *<pre>
    * 
    * Description   showSplash() to show a title screen in the center
    * @method       showSplash()
    * Date          9/29/2022
    * @author       <i>Abylay Dospayev</i>
    * Date          9/28/2022
    * History Log      
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void showSplash()
    {
        JPanel content = (JPanel)getContentPane();
        content.setBackground(Color.ORANGE);
        
        //Set window's bounds, centering the window 
        int width = 640; 
        int height = 419; 
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x, y, width, height);
        
        //Build the splash screen 
        JLabel label = new JLabel (new ImageIcon("src/cafedansadatabase/ballerina.jpg"));
        JLabel copyrt = new JLabel 
              ("Copyright Cafe Dansa Database Inc., 2022, Cafe Dansa Database", JLabel.CENTER);
        copyrt.setFont(new Font("Sans-serif", Font.BOLD, 12));
        content.add(label, BorderLayout.CENTER);
        content.add(loading, BorderLayout.SOUTH);
        Color border = new Color(50, 20, 20, 55);
        content.setBorder(BorderFactory.createLineBorder(border, 10));
        
        //Display it 
        setVisible(true);
        
        //wait a little while, while loading resources
        try
        {
            //increment the progress bar's value to 100 starting from 0
            incProgress(20);
            Thread.sleep(duration);
        }
        
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        setVisible(false);
    }
        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>>
     * Method       incProgress
     * Description  Creates and runs a new thread to manage the incrementation of the 
     * progress bar while the splash screen is showing 
     * @param       amount int
     * @throws      InterruptedException
     * @author      <i>Abylay Dospayev</i>
     * Date         9/30/2022
     * History Log 
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public void incProgress(int amount) throws InterruptedException
    {
        //Instantiate and start new thread
        ProgressThread up = new ProgressThread(amount);
        up.thread.start();
    }

    //Nested class to run the new thread from
    class ProgressThread
    {
        private int amount;
        public ProgressThread(int amount)
        {
            this.amount = amount;
        }
        
        private Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                {   
                    //Increment the progress bar until it's value hits 100
                    while(progress < 100)
                    {
                        progress++;
                        try
                        {
                            Thread.sleep(25);
                        }
                        catch(InterruptedException ex)
                        {
                        
                        }
                        loading.setValue(progress);
                    }    
                }
            }
        });
    }
}
