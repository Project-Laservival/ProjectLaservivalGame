import java.awt.*;

public class Turret
{
   private int myX;   // x and y coordinates of center
   private int myY;
   private int myLength = 20;
   private int width = 1366;
   private int height = 768;
   private int myHealth = 50;
   
   public Turret()
   {
      myX = (int)(Math.random() * 1326) + myLength;
      myY = (int)(Math.random() * 728) + myLength;
   }
   
   public Turret(int x, int y)
   {
      myX = x;
      myY = y;
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
   
   public int getHealth()
   {
      return myHealth;
   }
   
   public void setX(int x)
   {
      myX = x;
   }
   
   public void setY(int y)
   {
      myY = y;
   }
   
   public void setLength(int r)
   {
      myLength = r;
   }
   
   public void setHealth(int h)
   {
      myHealth = h;
   }
   
   public void draw(Graphics myBuffer)
   {
      myBuffer.setColor(Color.GRAY);
      myBuffer.fillRect(myX, myY, myLength, myLength);
   }
}