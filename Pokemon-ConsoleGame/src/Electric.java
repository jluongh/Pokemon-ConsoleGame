/**
 * Interface for an electric type Pokemon
 *
 * @author jenniferluong
 *
 */
public interface Electric {
   /**Type of Pokemon*/
   static final int mTYPE = 3;
   /**Special Fight Menu*/
   static final String mTYPE_MENU = "1. Thunder Shock \n2. Thunderbolt \n3. Thunder Punch";

   /**
    * Method to use thunderShock on Pokemon
    * 
    * @return amount of damage
    */
   public int thunderShock();

   /**
    * Method to use thunderbolt on Pokemon
    * 
    * @return amount of damage
    */
   public int thunderBolt();

   /**
    * Method to use thunder punch on Pokemon
    * 
    * @return amount of damage
    */
   public int thunderPunch();

}
