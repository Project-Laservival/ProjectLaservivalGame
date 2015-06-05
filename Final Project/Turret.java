import java.awt.*;

public class Turret
{
   private int myX;   // x and y coordinates of center
   private int myY;
   private int myRadius = 20;
   
   public Turret()
   {
      myX = 0;
      myY = 0;
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
   
   public void draw(Graphics myBuffer)
   {
      myBuffer.setColor(Color.GRAY);
      myBuffer.fillOval(myX - myRadius, myY - myRadius, myX + myRadius * 2, myY + myRadius * 2);
   }
}