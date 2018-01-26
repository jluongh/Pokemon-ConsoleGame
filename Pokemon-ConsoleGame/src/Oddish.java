/**
 * Oddish is a representation of a Grass type, subclass of Pokemon
 * 
 * @author jenniferluong
 *
 */
public class Oddish extends Pokemon implements Grass {

   /** Initializes Oddish to its name and random level */
   public Oddish() {
      super("Oddish", 1 + (int)(Math.random() * 50));
   }

   /** 
    * Method to use vine whip
    *     
    * @return amount damage to Pokemon
    */
   @Override
   public int vineWhip() {
      System.out.println(getName() + " used VINE WHIP.");
      int damage = 1 + (int) (Math.random() * 20);
      return damage;
   }

   /** Method to use razor leaf
    * 
    * @return amount damage to Pokemon
    */
   @Override
   public int razorLeaf() {
      System.out.println(getName() + " used RAZOR LEAF.");
      int damage = 1 + (int) (Math.random() * 20);
      return damage;
   }

   /** Method to use solar beam
    *  
    * @return amount damage to Pokemon
    */
   @Override
   public int solarBeam() {
      System.out.println(getName() + " used SOLAR BEAM.");
      int damage = 1 + (int) (Math.random() * 20);
      return damage;
   }

   /** Method to return type integer 
    * 
    *  @return type of Pokemon
    */
   @Override
   public int getType() {
      return mTYPE;
   }

   /** Method to call special fight move 
    * 
    * @return fight move
    */
   @Override
   public int specialFight(int move) {
      if (move == 1) {
         return vineWhip();
      }
      else if (move == 2) {
         return razorLeaf();
      }
      else {
         return solarBeam();
      }
   }

   /** Method to display special fight menu based on type */
   @Override
   public void displaySpecialMenu() {
      System.out.println(mTYPE_MENU);
   }
}
