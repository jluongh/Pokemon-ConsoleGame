/**
 * Interface for a fire type Pokemon
 * 
 * @author jenniferluong
 *
 */
public interface Fire {
   /**Type of Pokemon*/
   static final int mTYPE = 0;
   /**Special Fight Menu*/
   static final String mTYPE_MENU = "1. Ember \n2. Fire Blast \n3. Fire Punch";

   /**
    * Method to use ember on Pokemon
    * 
    * @return amount of damage
    */
   public int ember();

   /**
    * Method to use fireblast on Pokemon
    * 
    * @return amount of damage
    */
   public int fireBlast();

   /**
    * Method to use fire punch on Pokemon
    * 
    * @return amount of damage
    */
   public int firePunch();

}
