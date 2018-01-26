/**
 * Entity is a representation of a person/object
 * 
 * @author jenniferluong
 *
 */
import java.io.Serializable;

public abstract class Entity implements Serializable {
   /** Name of person/object */
   private String mName;
   /** HitPoint count */
   private int mHp;
   /** Max amount of HP */
   private int mMaxHp;
   
   /**
    * Initializes entity's name and HP
    * @param name Player's name
    * @param hp   Person's HitPoint count
    */
   public Entity (String name, int hp) {
      mName = name.toUpperCase();
      mHp = hp;
      mMaxHp = hp;
   }
   
   /**
    * Gets name of person
    * 
    * @return name
    */
   public String getName() {
      return mName;  
   }
   
   /**
    * Gets HP count
    * 
    * @return hp
    */
   public int getHp() {
      return mHp;
   }
   
   /**
    * Decrease HP by hit count
    * @param hit     Amount to decrease
    * @return new HP count
    */
   public int loseHp (int hit) {
      mHp -= hit;
      
      //if HP is negative, make it 0
      if (mHp < 0) {
         mHp = 0;
      }
      return mHp;
   }
   
   /**
    * Increase HP by hit count
    * @param heal    Amount to increase
    * @return new HP count
    */
   public int gainHp (int heal) {
      mHp += heal;
      System.out.println("Healing...");
      return mHp;
   }
   
   /** Increase HP back to original value */
   public void incMaxHp() {
      mHp = mMaxHp;
   }
}
