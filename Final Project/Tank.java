import java.awt.*;
import javax.swing.ImageIcon;
public abstract class Tank
{
   private int myHealth;
   private int mySpeed;    //pixels
   private ImageIcon myImage;
   private int myX;
   private int myY;
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
      myWeapon = weapon;
   }
   
   public abstract void automove();
   
   public int getHealth()
   {
      return myHealth;
   }
   
   public int getSpeed()
   {
      return mySpeed;
   }
   
   public ImageIcon getImage()
   {
      return myImage;
   }
   
   public int getX()
   {
      return myX;
   }
   
   public int getY()
   {
      return myY;
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
   
   public void setImage(String filename)
   {
      myImage = new ImageIcon(filename);
   }
   
   public void setX(int x)
   {
      myX = x;
   }
   
   public void setY(int y)
   {
      myY = y;
   }
      
   public void setWeapon(Weapon weapon)
   {
      myWeapon = weapon;
   }
}