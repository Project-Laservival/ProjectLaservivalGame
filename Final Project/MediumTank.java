import java.awt.*;
public class MediumTank extends Tank
{   
   public MediumTank()
   {
<<<<<<< HEAD
      super(125, 10, new MediumWeapon(), 300, 300);          //center
=======
      super(125, 7, new MediumWeapon(), 300, 300);          //default constructor
>>>>>>> origin/master
      setIcon("mediumtank0.png");
   }
   
   public MediumTank(int x, int y)
   {
<<<<<<< HEAD
      super(125, 10, new MediumWeapon(), x, y);
=======
      super(125, 7, new MediumWeapon(), x, y);     //creates mediumTank in given location
>>>>>>> origin/master
      setIcon("mediumtank0.png");
   }
   
   public String toString()
   {
      return "mediumtank";
   }
}
