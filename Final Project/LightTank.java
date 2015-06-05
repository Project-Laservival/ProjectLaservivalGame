import java.awt.*;
public class LightTank extends Tank
{   
   public LightTank()
   {
      super(100, 10, new LightWeapon(), 300, 300);
      setIcon("lighttank0.png");
   }
   
   public LightTank(int x, int y)
   {
      super(100, 10, new LightWeapon(), x, y);
      setIcon("lighttank0.png");
   }
   
   public String toString()
   {
      return "lighttank";
   }
}