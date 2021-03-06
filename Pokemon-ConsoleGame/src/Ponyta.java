/**
 * Ponyta is a representation of a Fire type, subclass of Pokemon
 * 
 * @author jenniferluong
 *
 */
public class Ponyta extends Pokemon implements Fire {

   /** Initializes Ponyta to its name and random level */
   public Ponyta() {
      super("Ponyta", 1 + (int) (Math.random() * 50));
   }

   /**
    * Method to use ember
    * 
    * @return amount damage to Pokemon
    */
   @Override
   public int ember() {
      System.out.println(getName() + " used EMBER.");
      int damage = 1 + (int) (Math.random() * 20);
      return damage;
   }

   /**
    * Method to use fire blast
    * 
    * @return amount damage to Pokemon
    */
   @Override
   public int fireBlast() {
      System.out.println("KA-BOOM " + getName() + " used fire blast!");
      int damage = 1 + (int) (Math.random() * 20);
      return damage;
   }

   /**
    * Method to use fire punch
    * 
    * @return amount damage to Pokemon
    */
   @Override
   public int firePunch() {
      System.out.println(getName() + "used FIREPUNCH.");
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
         return ember();
      } else if (move == 2) {
         return fireBlast();
      } else {
         return firePunch();
      }
   }

   /** Method to display special fight menu based on type */
   @Override
   public void displaySpecialMenu() {
      System.out.println(mTYPE_MENU);
   }

}
