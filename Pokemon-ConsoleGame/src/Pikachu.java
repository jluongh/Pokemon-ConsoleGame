/**
 * Pikachu is a representation of an Electric type, subclass of Pokemon
 * 
 * @author jenniferluong
 *
 */
public class Pikachu extends Pokemon implements Electric {

   /** Initializes Pikachu to its name and random level */
   public Pikachu() {
      super("Pikachu", 1 + (int) (Math.random() * 50));
   }

   /** Method to use thunder shock */
   @Override
   public int thunderShock() {
      System.out.println(getName() + " used Thunder Shock!! KABOOM!");
      int damage = 1 + (int) (Math.random() * 20);
      return damage;
   }

   /** Method to use thunderbolt */
   @Override
   public int thunderBolt() {
      System.out.println(getName() + " used Thunderbolt! ZAPP!");
      int damage = 1 + (int) (Math.random() * 20);
      return damage;
   }

   /** Method to use thunder punch */
   @Override
   public int thunderPunch() {
      System.out.println(getName() + " just used Thunder Punch!! WHA-POW!");
      int damage = 1 + (int) (Math.random() * 20);
      return damage;
   }

   /** Method to return type integer */
   @Override
   public int getType() {
      return mTYPE;
   }

   /** Method to call special fight move */
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
