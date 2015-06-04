import java.awt.*;
public class MediumTank extends Tank
{   
   public MediumTank()
   {
      super(125, 7, new MediumWeapon(), 200, 200);          //center
      setImage("mediumtank.jpg");
   }
   
   public MediumTank(int x, int y)
   {
      super(125, 7, new MediumWeapon(), x, y);
      setImage("mediumtank.jpg");
   }
}