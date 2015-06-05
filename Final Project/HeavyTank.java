import java.awt.*;
public class HeavyTank extends Tank
{
   public HeavyTank()   //default constructor
   {
      super(150, 5, new HeavyWeapon(), 300, 300);
      setIcon("heavytank0.png");
   }
   
   public HeavyTank(int x, int y)   //2-arg constructor for positioning heavyTank
   {
      super(150, 5, new HeavyWeapon(), x, y);
      setIcon("heavytank0.png");
   }
   
   public String toString()
   {
      return "heavytank";
   }
}
