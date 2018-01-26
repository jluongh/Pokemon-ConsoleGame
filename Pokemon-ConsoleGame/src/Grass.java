/**
 * Interface for a grass type Pokemon
 * 
 * @author jenniferluong
 *
 */
public interface Grass {
   /**Type of Pokemon*/
   static final int mTYPE = 2;
   /**Special Fight Menu*/
   static final String mTYPE_MENU = "1. Vine Whip \n2. Razor Leaf \n3. Solar Beam";

   /**
    * Method to use vine whip on Pokemon
    * 
    * @return amount of damage
    */
   public int vineWhip();

   /**
    * Method to use razor leaf on Pokemon
    * 
    * @return amount of damage
    */
   public int razorLeaf();

   /**
    * Method to use solarbeam on Pokemon
    * 
    * @return amount of damage
    */
   public int solarBeam();
}
