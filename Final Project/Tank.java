import java.awt.*;
import javax.swing.ImageIcon;
public abstract class Tank
{
   private int myHealth;
   private int mySpeed;    //pixels
   private ImageIcon myIcon;
   private int myX;
   private int myY;
   private int myDirection;
   private Weapon myWeapon;
      
   public Tank()
   {
      myHealth = 0;
      mySpeed = 0;
   }
   
   public Tank(int health, int speed, Weapon weapon, int x, int y)
   {
      myHealth = health;
      mySpeed = speed;
      myX = x;
      myY = y;
      myDirection = 0;
      myWeapon = weapon;
   }
   
   public void automove()
   {
      int random = (int)(Math.random() * 4);
   }
   
   public abstract String toString();
         
   public void draw(Graphics myBuffer) 
   {
      myIcon.paintIcon(null, myBuffer, myX, myY);
   }
   
   public int getHealth()
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
