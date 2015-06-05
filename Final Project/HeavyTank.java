import java.awt.*;
public class HeavyTank extends Tank
{
   public HeavyTank()
   {
      super(150, 5, new HeavyWeapon(), 300, 300);
      setIcon("heavytank0.png");
   }
   
   public HeavyTank(int x, int y)
   {
      super(150, 5, new HeavyWeapon(), x, y);
      setIcon("heavytank0.png");
   }
   
   public String toString()
   {
      return "heavytank";
   }
}