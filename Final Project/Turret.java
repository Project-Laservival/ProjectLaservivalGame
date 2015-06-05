import java.awt.*;

public class Turret
{
   private int myX;   // x and y coordinates of center
   private int myY;
   private int myRadius = 20;
   private int width = 1366;
   private int height = 768;
   
   public Turret()//randomly spawns turret
   {
      myX = (int)(Math.random() * 1326) + myRadius;
      myY = (int)(Math.random() * 728) + myRadius;
   }
   
   public Turret(int x, int y)//spawns turret in given position
   {
      myX = x;
      myY = y;
   }
   //helper methods
   public int getX()
   {
      return myX;
   }
   
   public int getY()
   {
      return myY;
   }
   
   public int getRadius()
   {
      return myRadius;
   }
   
   public void setX(int x)
   {
      myX = x;
   }
   
   public void setY(int y)
   {
      myY = y;
   }
   
   public void setRadius(int r)
   {
      myRadius = r;
   }
   
   public void draw(Graphics myBuffer) //draws the turret
   {
      myBuffer.setColor(Color.GRAY);
      myBuffer.fillOval(myX - myRadius, myY - myRadius, myX + myRadius * 2, myY + myRadius * 2);
   }
}
