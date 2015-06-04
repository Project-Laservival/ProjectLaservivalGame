import java.awt.*;
public class LightTank extends Tank
{   
   public LightTank()
   {
      super(100, 10, new LightWeapon(), 200, 200);
      setImage("lighttank.jpg");
   }
   
   public LightTank(int x, int y)
   {
      super(100, 10, new LightWeapon(), x, y);
      setImage("lighttank.jpg");
   }
}