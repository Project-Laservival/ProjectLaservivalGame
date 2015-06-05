import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
public class GamePanel extends JPanel
{                                        //fields
   private BufferedImage myImage;                    //image
   private Graphics myBuffer;                        //buffer
   private JLabel health;                        //health label
   private int waveCount;                        //wave number
   private Timer gameTimer;                        //timer
   private Tank myTank, enemyTank;                            //tank type
   private static final int FRAME = 600;
   
   public GamePanel()                            //constructor
   {
    /*
    Create image and buffer
    Instantiate myTank
    Set myIcon
    Instantiate health with base health of myTank
    Instantiate and start timer of 10 ms, add ListenerGame
    Add keyListener
   */
   
      myImage = new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myTank = OptionsPanel.getTankType();
      
      gameTimer = new Timer(10, new ListenerGame());
      gameTimer.start();
      
      addKeyListener(new Key());
      setFocusable(true);
   }
   
   public void paintComponent(Graphics g)                //draws image
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }
   
   private class Key extends KeyAdapter                //yay keyboard
   {
      public void keyPressed(KeyEvent e)
      {
       /*
       Depending on pressed arrow keys, load different image
       Add shooting code when spacebar is pressed
       */
         if(e.getKeyCode() == KeyEvent.VK_W)
         {
            myTank.setY(myTank.getY() - myTank.getSpeed());
            myTank.setDirection(90);
            myTank.setIcon(myTank.toString() + "90" + ".png");
         }
         
         if(e.getKeyCode() == KeyEvent.VK_S)
         {
            myTank.setY(myTank.getY() + myTank.getSpeed());
            myTank.setDirection(270);
            myTank.setIcon(myTank.toString() + "270" + ".png");
         }
         
         if(e.getKeyCode() == KeyEvent.VK_A)
         {
            myTank.setX(myTank.getX() - myTank.getSpeed());
            myTank.setDirection(180);
            myTank.setIcon(myTank.toString() + "180" + ".png");
         }
         
         if(e.getKeyCode() == KeyEvent.VK_D)
         {
            myTank.setX(myTank.getX() + myTank.getSpeed());
            myTank.setDirection(0);
            myTank.setIcon(myTank.toString() + "0" + ".png");
         }
         
         if(e.getKeyCode() == KeyEvent.VK_SPACE)
         {
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
         myBuffer.setColor(Color.WHITE);
         myBuffer.fillRect(0,0,FRAME,FRAME); 
      
         myTank.draw(myBuffer);
         
         repaint();
      }
   }
}
