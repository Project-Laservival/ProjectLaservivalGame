import java.awt.*;
public class Laser
{
   private int dx = 0;
   private int dy = 0;
   private int myX;
   private int myY;
   private int myLength = 50;
   private int myDirection;
   
   public Laser()
   {
      myX = 0;
      myY = 0;
      dx = 0;
      dy = 0;
      myDirection = 0;
   }
   
   public Laser(int x, int y, int direction)
   {   
      myX = x;
      myY = y;
      myDirection = direction;
      
      if(myDirection == 0)
         dx = 20;
         
      else if(myDirection == 90)
         dy = -20;
         
      else if(myDirection == 180)
         dx = -20;
         
      else if(myDirection == 270)
         dy = 20;
   }
   
   public int getX()
   {
      return myX;
   }
   
   public int getY()
   {
      return myY;
   }
   
   public int getdx()
   {
      return dx;
   }
   
   public int getdy()
   {
      return dy;
   }
   
   public int getLength()
   {
      return myLength;
   }
   
   public int getDirection()
   {
      return myDirection;
   }
   
   public void setX(int x)
   {
      myX = x;
   }
   
   public void setY(int y)
   {
      myY = y;
   }
   
   public void setdx(int changeX)
   {
      dx = changeX;
   }
   
   public void setdy(int changeY)
   {
      dy = changeY;
   }
   
   public void move()
   {
      myX += dx;
      myY += dy;
   }     
   
   public void draw(Graphics myBuffer)
   {
      myBuffer.setColor(Color.RED);
      if(myDirection == 0)
         myBuffer.drawLine(myX, myY, myX + myLength, myY);
      else if(myDirection == 90)
         myBuffer.drawLine(myX, myY, myX, myY - myLength);
      else if(myDirection == 180)
         myBuffer.drawLine(myX, myY, myX - myLength, myY);
      else if(myDirection == 270)
         myBuffer.drawLine(myX, myY, myX, myY + myLength);
   }
}