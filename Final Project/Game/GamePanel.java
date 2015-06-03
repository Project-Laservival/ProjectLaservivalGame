import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import engine.*;
public class GamePanel extends JPanel
{                                        //fields
   private BufferedImage myImage;                    //tank’s image
   private Graphics myBuffer;                        //buffer
   private JLabel health;                        //health label
   private int waveCount;                        //wave number
   private Timer gameTimer;                        //timer
   private Tank myTank;                            //tank type
   private ImageIcon myImg;                        //tank image
   public GamePanel()                            //constructor
   {
    /*
    Create image and buffer
    Instantiate myTank
    Set myImg
    Instantiate health with base health of myTank
    Instantiate and start timer of 10 ms, add ListenerGame
    Add keyListener
   */
   }
   public void paintComponent(Graphics g)                //draws image
   {
    /*
    Draw background
    Update tank img
    Update enemy tank images
    */
   }
   private class Key extends KeyAdapter                //yay keyboard
   {
      public void keyPressed(KeyEvent e)
      {
       /*
       Depending on pressed arrow keys, load different image
       Add shooting code when spacebar is pressed
       */
      }
   }
   private class ListenerGame implements ActionListener    //game timer
   {
      public void actionPerformed(ActionEvent e)
      {
       /*
       Randomly generates enemy based on wave count
       Updates buffer
       */
      }
   }
}