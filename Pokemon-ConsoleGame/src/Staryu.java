/**
 * Staryu is a representation of a Water type, subclass of Pokemon
 * 
 * @author jenniferluong
 *
 */
public class Staryu extends Pokemon implements Water {

   /** Initializes Staryu to its name and random level */
   public Staryu() {
      super("Staryu", 1 + (int) (Math.random() * 50));
   }

   /**
    * Method to use water gun
    * 
    * @return amount damage to Pokemon
    */

   @Override
   public int waterGun() {
      System.out.println(getName() + " used WATERGUN.");
      int damage = 1 + (int) (Math.random() * 20);
      return damage;
   }

   /**
    * Method to use bubble beam
    *
    * @return amount damage to Pokemon
    */
   @Override
   public int bubbleBeam() {
      System.out.println(getName() + " used BUBBLE BEAM.");
      int damage = 1 + (int) (Math.random() * 20);
      return damage;
   }

   /**
    * Method to use waterfall
    * 
    * @return amount damage to Pokemon
    */
   @Override
   public int waterfall() {
      System.out.println(getName() + " used WATERFALL -- FLUSHHHH.");
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
         return waterGun();
      } else if (move == 2) {
         return bubbleBeam();
      } else {
         return waterfall();
      }
   }

   /** Method to display special fight menu based on type */
   @Override
   public void displaySpecialMenu() {
      System.out.println(mTYPE_MENU);
   }
}
