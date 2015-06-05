import java.awt.*;
import javax.swing.*;
public abstract class Tank
{
   private int myHealth;      //health
   private int mySpeed;    //pixels
   private ImageIcon myIcon;     //tank image
   private int myX;     //x coords top left
   private int myY;     //y coords top left
   private int myLength = 100;      //length of image
   private int myDirection;      //direction facing (N,S,E,W)
   private Weapon myWeapon;      //weapon equipped
      
   public Tank()           //default constructor
   {
      myHealth = 0;
      mySpeed = 0;
   }
   
   public Tank(int health, int speed, Weapon weapon, int x, int y)         //many arg constructor
   {
      myHealth = health;
      mySpeed = speed;
      myX = x;
      myY = y;
      myDirection = 0;
      myWeapon = weapon;
   }
   
   public int automove()      //chooses N/S/E/W
   {
      int random = (int)(Math.random() * 4);
      return random * 90;
   }
   
   public abstract String toString();
   
   public void draw(Graphics myBuffer)    //draws
   {
      myIcon.paintIcon(null, myBuffer, myX, myY);
   }
   public int getHealth()     //getters and setters
   {
      return myHealth;
   }
   
   public int getSpeed()
   {
      return mySpeed;
   }
   
   public ImageIcon getIcon()
   {
      return myIcon;
   }
   
   public int getX()
   {
      return myX;
   }
   
   public int getY()
   {
      return myY;
   }
   
   public int getLength()
   {
      return myLength;
   }
   
   public int getDirection()
   {
      return myDirection;
   }
   
   public Weapon getWeapon()
   {
      return myWeapon;
   }
   
   public void setHealth(int health)
   {
      myHealth = health;
   }
   
   public void setSpeed(int speed)
   {
      mySpeed = speed;
   }
   
   public void setIcon(String filename)
   {
      myIcon = new ImageIcon(filename);
   }
   
   public void setX(int x)
   {
      myX = x;
   }
   
   public void setY(int y)
   {
      myY = y;
   }
   
   public void setDirection(int d)
   {
      myDirection = d;
   }
      
   public void setWeapon(Weapon weapon)
   {
      myWeapon = weapon;
   }
}
