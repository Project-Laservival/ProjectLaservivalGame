import java.awt.*;
public class HeavyTank extends Tank
{
   public HeavyTank()
   {
      super(150, 5, new HeavyWeapon(), 200, 200);
      setImage("heavytank.jpg");
   }
   
   public HeavyTank(int x, int y)
   {
      super(150, 5, new HeavyWeapon(), x, y);
      setImage("heavytank.jpg");
   }
   
   public void automove()
   {
   }   
}