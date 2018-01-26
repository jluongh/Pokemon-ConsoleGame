/**
 * Zapdos is a representation of an Electric type, subclass of Pokemon
 * 
 * @author jenniferluong
 *
 */
public class Zapdos extends Pokemon implements Electric {

   /** Initializes Zapdos to its name and random level */
   public Zapdos() {
      super("Zapdos", 1 + (int) (Math.random() * 50));
   }

   /**
    * Method to use thunder shock
    * 
    * @return amount damage to Pokemon
    */
   @Override
   public int thunderShock() {
      System.out.println(getName() + " used THUNDER SHOCK!");
      int damage = 1 + (int) (Math.random() * 20);
      return damage;
   }

   /**
    * Method to use thunderbolt
    * 
    * @return amount damage to Pokemon
    */
   @Override
   public int thunderBolt() {
      System.out.println(getName() + " used THUNDER BOLT.");
      int damage = 1 + (int) (Math.random() * 20);
      return damage;
   }

   /**
    * Method to use thunder punch
    * 
    * @return amount damage to Pokemon
    */
   @Override
   public int thunderPunch() {
      System.out.println(getName() + " used THUNDER PUNCH.");
      int damage = 1 + (int) (Math.random() * 20);
      return damage;
   }

   /**
    * Method to return type integer
    * 
    * @return type of Pokemon
    */
   @Override
   public int getType() {
      return mTYPE;
   }

   /**
    * Method to call special fight move
    * 
    * @return fight move
    */
   @Override
   public int specialFight(int move) {
      if (move == 1) {
         return thunderShock();
      } else if (move == 2) {
         return thunderBolt();
      } else {
         return thunderPunch();
      }
   }

   /** Method to display special fight menu based on type */
   @Override
   public void displaySpecialMenu() {
      System.out.println(mTYPE_MENU);
   }

}
