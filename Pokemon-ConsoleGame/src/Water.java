/**
 * Interface for a water type Pokemon
 * 
 * @author jenniferluong
 *
 */
public interface Water {
   /**Type of Pokemon*/
   static final int mTYPE = 1;
   /**Special Fight Menu*/
   static final String mTYPE_MENU = "1. Water Gun \n2. Bubble Beam \n3. Waterfall";

   /**
    * Method to use water gun on Pokemon
    * 
    * @return amount of damage
    */
   public int waterGun();

   /**
    * Method to use bubble beam on Pokemon
    * 
    * @return amount of damage
    */
   public int bubbleBeam();

   /**
    * Method to use waterfall on Pokemon
    * 
    * @return amount of damage
    */
   public int waterfall();

}
