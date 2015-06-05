import java.awt.*;
public class LightTank extends Tank
{   
   public LightTank()
   {
      super(100, 10, new LightWeapon(), 300, 300); //creates lightTank
      setIcon("lighttank0.png");
   }
   
   public LightTank(int x, int y)
   {
      super(100, 10, new LightWeapon(), x, y);   //creates lightTank in given position
      setIcon("lighttank0.png");
   }
   
   public String toString()
   {
      return "lighttank";
   }
}
