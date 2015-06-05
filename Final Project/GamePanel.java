import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;

public class GamePanel extends JPanel
{                                        //fields
   private BufferedImage myImage;                    //image
   private Graphics myBuffer;                        //buffer
   private JLabel health;                        //health label
   private int waveCount;                        //wave number
   private javax.swing.Timer gameTimer;                        //timer
   private Tank myTank;                            //tank type
   private Laser myLaser = null;
   private boolean shooting = false;
   private int width = 1366;
   private int height = 768;
   Turret[] turretArray = new Turret[10];
   private int countdown, time;
   private int score;
   
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
      
      gameTimer = new javax.swing.Timer(10, new ListenerGame());
      gameTimer.start();
      
      addKeyListener(new Key());
      setFocusable(true);
      
      countdown = 20;
      time = 0;
      score = 0;
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
         myBuffer.setColor(Color.WHITE);
         myBuffer.fillRect(0, 0, width, height);
         myTank.draw(myBuffer);
         
         if(shooting)
         {
            myLaser.move();
            myLaser.draw(myBuffer);
         }
            
         if(turretSpawn())
         {
            for(int k = 0; k < turretArray.length; k++)
            {
               if(turretArray[k] == null)
               {
                  turretArray[k] = new Turret();
                  break;
               }
            }
         }
         
         if(shooting)
         {
            for(int k = 0; k < turretArray.length; k++)
            {
               if(turretArray[k] != null)
               {
                  if(collide(myLaser, turretArray[k]))
                  {
                     turretArray[k].setHealth(turretArray[k].getHealth() - myTank.getDamage());
                     shooting = false;
                     
                     if(turretArray[k].getHealth() <= 0)
                     {
                        turretArray[k] = null;
                        score++;
                     }
                     break;
                  }
               }
            }
         }
         
         for(int k = 0; k < turretArray.length; k++)
         {
            if(turretArray[k] != null)
            {
               turretArray[k].draw(myBuffer);
            }
         }
         
         myBuffer.setColor(Color.BLACK);
         myBuffer.setFont(new Font("Monospaced", Font.BOLD, 50));
         time += 10;
         if(time % 1000 == 0)
         {
            countdown = 20 - time / 1000;
         }
         myBuffer.drawString("" + countdown, 30, 50);
         if(countdown <= 0)
         {
            myBuffer.fillRect(0, 0, width, height);
            myBuffer.setFont(new Font("Monospaced", Font.BOLD, 30));
            myBuffer.setColor(Color.GREEN);
            myBuffer.drawString("I hope you liked it Mr. Rudwick! Your mediocre score: " + score, 200, 400);
            gameTimer.stop();
         }
         
         repaint();
      }
   }
   
   private boolean turretSpawn()
   {
      if(Math.random() < 0.007)
         return true;
      return false;
   }
   
   private boolean collide(Laser l, Turret t)
   {
      if(l.getDirection() == 0)
         if(l.getX() + l.getLength() <= t.getX() && l.getY() >= t.getY() && l.getY() <= t.getY() + t.getLength())
            return true;
      
      if(l.getDirection() == 90)
         if(l.getY() - l.getLength() <= t.getY() && l.getX() >= t.getX() && l.getX() <= t.getX() + t.getLength())
            return true;
      
      if(l.getDirection() == 180)
         if(l.getX() - l.getLength() <= t.getX() + t.getLength() && l.getY() >= t.getY() && l.getY() <= t.getY() + t.getLength())
            return true;
      
      if(l.getDirection() == 270)
         if(l.getY() + l.getLength() <= t.getY() && l.getX() >= t.getX() && l.getX() <= t.getX() + t.getLength())
            return true;
      
      return false;   
   }
}
