public abstract class Weapon
{
   private String myName;
   private int myDamage;
   private int myFireRate;    //milliseconds
   
   public Weapon()            //no arg constructor
   {
      myName = null;
      myDamage = 0;
      myFireRate = 0;
   }
   
   public Weapon(String name, int damage, int rate)      //3 arg constructor
   {
      myName = name;
      myDamage = damage;
      myFireRate = rate;
   }
   
   public String getName()             //getters and setters
   {
      return myName;
   }
   
   public int getDamage()
   {
      return myDamage;
   }
   
   public int getFireRate()
   {
      return myFireRate;
   }
   
   public void setDamage(int damage)
   {
      myDamage = damage;
   }
   
   public void setFireRate(int rate)
   {
      myFireRate = rate;
   }
}
