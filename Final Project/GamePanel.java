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
   private Tank myTank;                            //tank type
   private Laser myLaser = null;
   private boolean shooting = false;
   private int width = 1366;
   private int height = 768;
   
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
   
      myImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
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
         if((e.getKeyCode() == KeyEvent.VK_W)||(e.getKeyCode() == KeyEvent.VK_UP)||(e.getKeyCode() == KeyEvent.VK_KP_UP))
         {
            if(myTank.getY() >= 0)
            {
               myTank.setY(myTank.getY() - myTank.getSpeed());
            }
            myTank.setDirection(90);
            myTank.setIcon(myTank.toString() + "90" + ".png");
         }
         
         if((e.getKeyCode() == KeyEvent.VK_S)||(e.getKeyCode() == KeyEvent.VK_DOWN)||(e.getKeyCode() == KeyEvent.VK_KP_DOWN))
         {
            if(myTank.getY() <= height - myTank.getLength())
            {
               myTank.setY(myTank.getY() + myTank.getSpeed());
            }
            myTank.setDirection(270);
            myTank.setIcon(myTank.toString() + "270" + ".png");
         }
         
         if((e.getKeyCode() == KeyEvent.VK_A)||(e.getKeyCode() == KeyEvent.VK_LEFT)||(e.getKeyCode() == KeyEvent.VK_KP_LEFT))
         {
            if(myTank.getX() >= 0)
            {
               myTank.setX(myTank.getX() - myTank.getSpeed());
            }
            myTank.setDirection(180);
            myTank.setIcon(myTank.toString() + "180" + ".png");
         }
         
         if((e.getKeyCode() == KeyEvent.VK_D)||(e.getKeyCode() == KeyEvent.VK_RIGHT)||(e.getKeyCode() == KeyEvent.VK_KP_RIGHT))
         {
            if(myTank.getX() <= width - myTank.getLength())
            {
               myTank.setX(myTank.getX() + myTank.getSpeed());
            }
            myTank.setDirection(0);
            myTank.setIcon(myTank.toString() + "0" + ".png");
         }
         
         if(e.getKeyCode() == KeyEvent.VK_SPACE)
         {
            if(shooting && (myLaser.getX() >= 0 && myLaser.getX() <= width - myLaser.getLength()) && (myLaser.getY() >= 0 && myLaser.getY() <= height - myLaser.getLength()))
            {
            }
            
            else if(shooting && !(myLaser.getX() >= 0 && myLaser.getX() <= width - myLaser.getLength()) && !(myLaser.getY() >= 0 && myLaser.getY() <= height - myLaser.getLength()))
               shooting = false;
            
            else
            {   
               myLaser = new Laser(myTank.getX() + 50, myTank.getY() + 50, myTank.getDirection());
               shooting = true;
            }
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
         myBuffer.fillRect(0, 0, width, height); 
      
         myTank.draw(myBuffer);
         
         if(shooting)
         {
            myLaser.move();
            myLaser.draw(myBuffer);
         }
         repaint();
      }
   }
   
   private boolean rng()
   {
      if(Math.random() < 0.10)
         return true;
      return false;
   }
}
