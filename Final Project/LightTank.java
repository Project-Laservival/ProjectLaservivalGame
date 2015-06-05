import java.awt.*;
public class LightTank extends Tank
{   
   public LightTank()
   {
<<<<<<< HEAD
      super(100, 20, new LightWeapon(), 300, 300);
=======
      super(100, 10, new LightWeapon(), 300, 300); //creates lightTank
>>>>>>> origin/master
      setIcon("lighttank0.png");
   }
   
   public LightTank(int x, int y)
   {
<<<<<<< HEAD
      super(100, 20, new LightWeapon(), x, y);
=======
      super(100, 10, new LightWeapon(), x, y);   //creates lightTank in given position
>>>>>>> origin/master
      setIcon("lighttank0.png");
   }
   
   public String toString()
   {
      return "lighttank";
   }
}
