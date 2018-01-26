
/**
 * 
 * Pokemon is a representation of the player's pokemon that extends Entity
 *
 * @author jenniferluong
 *
 */

import java.io.Serializable;

public abstract class Pokemon extends Entity implements Serializable {

   /** Current Level of Pokemon */
   private int mLevel;
   /** EXP of Pokemon */
   private int mExp;
   /** How much EXP needed in order to level up */
   private int mNextLevelExp;

   /**
    * Initializes Pokemon's name, level, and next level EXP
    * 
    * @param name
    *           Name is the name of Pokemon
    * @param level
    *           Level is initialized by getting random number and multiplying by
    *           it's "hp" level
    */
   public Pokemon(String name, int level) {
      super(name, level);

      final int LEVEL_FORMULA = 1 + (int) (((int) Math.random() * level) + level * 0.5);
      final int EXP_FORMULA = (int) (mLevel * 100 * 0.5);
      final int AMT_HP_UP = 150 + (mLevel * 3);

      mLevel = LEVEL_FORMULA;
      mNextLevelExp = EXP_FORMULA;

      if (mExp >= mNextLevelExp) {
         mLevel++;
         level += AMT_HP_UP;
         mExp = 0;
      }
   }

   /**
    * Gets the type of Pokemon
    * 
    * @return mTYPE
    */
   public abstract int getType();

   /**
    * Pokemon attacks with its special fight move
    * 
    * @param move
    *           Integer is user's choice for the certain fight move
    * @return The amount of HP will be lost
    */
   public abstract int specialFight(int move);

   /**
    * Displays Pokemon's special fight menu
    */
   public abstract void displaySpecialMenu();

   /**
    * Gets Pokemon's level
    * 
    * @return The current level of Pokemon
    */
   public int getLevel() {
      return mLevel;
   }

   /**
    * Gets EXP
    * 
    * @return The current EXP of Pokemon
    */
   public int getExp() {
      return mExp;
   }

   /**
    * Displays the name of Pokemon
    */
   public void displayPokemon() {
      this.getName();
   }

   /**
    * Pokemon gains a certain amount of experience
    * 
    * @param exp
    *           amount of experience Pokemon will gain
    * @return new Exp amount
    */
   public int gainExp(int exp) {
      if (mExp == mNextLevelExp) {
         mLevel++;
         System.out.println(getName() + " leveled up to level " + getLevel() + "!");
      }
      int gain = (int) (exp * mLevel * 0.5);
      mExp += gain;
      System.out.println(getName() + " gained " + gain + " EXP.");
      return mExp;
   }

   /**
    * Displays basic fight menu
    */
   public void displayBasicMenu() {
      System.out.println("What do you want your pokemon to do?");
      System.out.println("1. Slam");
      System.out.println("2. Tackle");
      System.out.println("3. Mega Punch");
   }

   /**
    * Pokemon attacks with its basic fight move
    * 
    * @param move
    *           Integer is user's choice for the certain fight move
    * @return The amount of HP will be lost
    */
   public int basicFight(int move) {
      if (move == 1) {
         return slam();
      } else if (move == 2) {
         return tackle();
      } else {
         return megaPunch();
      }
   }

   /**
    * Pokemon fights with the certain battle move and style
    * 
    * @param style
    *           Style is either basic or special fight
    * @param move
    *           Move is the certain basic or special fight move
    * @return returns the certain basic or special fight move
    */
   public int fight(int style, int move) {
      if (style == 1) {
         return basicFight(move);
      } else {
         return specialFight(move);
      }
   }

   /**
    * Pokemon attack slam
    * 
    * @return Amount of damage
    */
   public int slam() {
      System.out.println("Wowza! " + getName() + " used SLAM.");
      int attack = 1 + (int) (Math.random() * 10);
      return attack;
   }

   /**
    * Pokemon attack tackle
    * 
    * @return Amount of damage
    */
   public int tackle() {
      System.out.println("Ouchers " + getName() + " used TACKLE.");

      int attack = 1 + (int) (Math.random() * 10);
      return attack;
   }

   /**
    * Pokemon attack Mega Punch
    * 
    * @return Amount of damage
    */
   public int megaPunch() {
      System.out.println("Wa-POW! " + super.getName() + " used MEGAPUNCH.");
      int attack = 1 + (int) (Math.random() * 10);
      return attack;
   }
}
