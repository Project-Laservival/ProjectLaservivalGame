import java.awt.*;
public class MediumTank extends Tank
{   
   public MediumTank()
   {
      super(125, 7, new MediumWeapon(), 300, 300);          //default constructor
      setIcon("mediumtank0.png");
   }
   
   public MediumTank(int x, int y)
   {
      super(125, 7, new MediumWeapon(), x, y);     //creates mediumTank in given location
      setIcon("mediumtank0.png");
   }
   
   public String toString()
   {
      return "mediumtank";
   }
}
