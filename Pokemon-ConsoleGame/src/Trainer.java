/**
 * Trainer is a representation of the Player that extends Entity
 * 
 * @author Jennifer Luong
 *
 */

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Trainer extends Entity implements Serializable {
   /** Trainer's pokemon list */
   private ArrayList<Pokemon> mPokemon = new ArrayList<Pokemon>();
   /** Location of the Trainer's current pokemon */
   private int mCurrentPokemon;

   /**
    * Initializes trainer's name and HP
    * 
    * @param name
    *           Trainer's name.
    * @param hp
    *           HP count.
    */
   public Trainer(String name, int hp) {
      super(name, hp);
   }

   /** Display attack speech */
   public abstract void attackSpeech();

   /** Display win speech */
   public abstract void winSpeech();

   /** Display loss speech */
   public abstract void lossSpeech();

   /**
    * Displays to user whether to use basic or special User chooses certain
    * style (basic or special)
    * 
    * @return user's choice
    */
   public abstract int chooseStyle();

   /**
    * Displays basic or special style menu User chooses certain move
    * 
    * @param style
    *           called from chooseStyle() method
    * @return certain move
    */
   public abstract int chooseMove(int style);

   /** Displays trainer's pokemon */
   public void displayCurrentPokemon() {
      System.out.println("Current Pokemon: " + getCurrentPokemon().getName() + " Level: "
            + getCurrentPokemon().getLevel() + " HP: " + getCurrentPokemon().getHp());
   }

   /**
    * Accesses the trainer's current pokemon in array list
    * 
    * @return current Pokemon
    */
   public Pokemon getCurrentPokemon() {
      return mPokemon.get(mCurrentPokemon);
   }

   /**
    * Adds pokemon to Pokemon array list
    * 
    * @param p
    *           the Pokemon to add
    */
   public void addPokemon(Pokemon p) {
      mPokemon.add(p);
   }

   /**
    * Lists all Pokemon found in array list Includes name, HP, level, and EXP
    */
   public void listPokemon() {
      for (int i = 0; i < mPokemon.size(); i++) {
         System.out.println((i + 1) + ". " + mPokemon.get(i).getName() + " Level: " + mPokemon.get(i).getLevel()
               + " HP: " + mPokemon.get(i).getHp());
         System.out.println("\tEXP: " + mPokemon.get(i).getExp());
      }
   }

   /**
    * Found in PokeCenter Heals all Pokemon found in array list to original HP
    */
   public void healAllPokemon() {
      for (int i = 0; i < mPokemon.size(); i++) {
         // retrieves each pokemon
         System.out.println("Healing " + mPokemon.get(i).getName());
         mPokemon.get(i).incMaxHp();
      }
   }

   /**
    * Sets current Pokemon to Trainer's fighting Pokemon
    * 
    * @param cur
    *           index number found in array list
    * @return current Pokemon index number
    */
   public int setCurrentPokemon(int cur) {
      mCurrentPokemon = cur;
      return mCurrentPokemon;
   }

   /**
    * Gets next Pokemon index value
    * 
    * @return next Pokemon index number
    */
   public int getNextCurPokemon() {
      // checks if next pokemon position is equal to mPokemon list size
      if (mCurrentPokemon + 1 > mPokemon.size() - 1) {
         return 0;
      }
      // increments current position to next pokemon
      else {
         return mCurrentPokemon + 1;
      }
   }

   /**
    * Calls chooseStyle() to get style Calls choosemove(style) to get move
    * Pokemon fights with certain style and move using fight()
    * 
    * @return amount of damage done from calling fight()
    */
   public int battle() {
      int style = chooseStyle();
      int move = chooseMove(style);
      int attack = getCurrentPokemon().fight(style, move);
      return attack;
   }
}