import java.awt.*;
public class MediumTank extends Tank
{   
   public MediumTank()
   {
      super(125, 10, new MediumWeapon(), 300, 300);          //center
      setIcon("mediumtank0.png");
   }
   
   public MediumTank(int x, int y)
   {
      super(125, 10, new MediumWeapon(), x, y);
      setIcon("mediumtank0.png");
   }
   
   public String toString()
   {
      return "mediumtank";
   }
}