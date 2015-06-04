import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
public class GamePanel extends JPanel
{                                        //fields
   private BufferedImage myImage;                    //tank’s image
   private Graphics myBuffer;                        //buffer
   private JLabel health;                        //health label
   private int waveCount;                        //wave number
   private Timer gameTimer;                        //timer
   private Tank myTank;                            //tank type
   private ImageIcon myImg;                        //tank image
   
   private static final int FRAME = 600;
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
      myImage = new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myTank = new Tank();
      gameTimer = 0;
      waveCount = 1;
      
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
       if(keyPressed(VK_DOWN)||keyPressed(VK_KP_DOWN))
         {
           //image down 
         }
      if(keyPressed(VK_UP)||keyPressed(VK_KP_UP))
         {
           //image up 
         }
      if(keyPressed(VK_LEFT)||keyPressed(VK_KP_LEFT))
         {
            //image left
         }
      if(keyPressed(VK_RIGHT)||keyPressed(VK_KP_RIGHT))
         {
            //image right
         }
      if(keyPressed(VK_SPACE))
         {
         //shooting code
         }
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
