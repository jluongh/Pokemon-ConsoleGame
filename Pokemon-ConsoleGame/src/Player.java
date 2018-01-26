
/**
 * 
 * Player is a representation of a Trainer
 * 
 * @author jenniferluong
 *
 */

import java.awt.Point;
import java.io.Serializable;

public class Player extends Trainer implements Serializable {
   /** Starting amount of potions */
   private int mPotions = 5;
   /** Starting amount of pokeballs */
   private int mPokeballs = 3;
   /** Amount of money given */
   private int mMoney = 25;
   /** Current map level of player */
   private int mLevel = 1;
   /** Location of player */
   private Point mLocation;

   /**
    * Initializes the player's name and HP
    * 
    * @param name
    *           Player's name.
    * @param hp
    *           HP count.
    * @param start
    *           Start location of map
    */
   public Player(String name, int hp, Point start) {
      super("Ash Ketchum", 25);
      mLocation = start;
   }

   /**
    * Uses a potion on current Pokemon Current Pokemon is healed back to
    * original HP Decrements potion count
    */
   public void usePotion() {
      System.out.println("Healing " + getCurrentPokemon().getName() + " right now....");
      System.out.println("Using potion....");
      getCurrentPokemon().incMaxHp();
      mPotions--;
   }

   /**
    * Gets how many potions the player currently has
    * 
    * @return potions count
    */
   public int getNumPotionsLeft() {
      return mPotions;
   }

   /**
    * Buys potions if there is enough money Uses spendMoney() to decrease money
    * Amount of potions increases
    */
   public void buyPotion() {
      System.out.println("Buying potions....");
      if (mMoney > 0) {
         // $15 for 3 Potions
         int amt = 15;
         spendMoney(amt);
         int gain = 3;
         mPotions += gain;
      } else {
         System.out.println("You don't have enough money to buy potions.");
      }
   }

   /**
    * Uses pokeball by decreasing the amount
    */
   public void usePokeball() {
      System.out.println("Using pokeball....");
      mPokeballs--;
   }

   /**
    * Gets how many pokeballs the player currently has
    * 
    * @return pokeball count
    */
   public int getNumPokeballsLeft() {
      return mPokeballs;
   }

   /**
    * Buys pokeballs if there is enough money Uses spendMoney() to decrease
    * money Amount of pokeballs increases
    */
   public void buyPokeball() {
      System.out.println("Buying pokeballs....");
      if (mMoney > 0) {
         // $5 for 2
         int amt = 5;
         spendMoney(amt);
         int gain = 2;
         mPokeballs += gain;
      } else {
         System.out.println("You don't have enough money to buy pokeballs.");
      }
   }

   /**
    * mMoney decreases in accordance to the price
    * 
    * @param price
    *           amount of money the item costs
    */
   public void spendMoney(int price) {
      mMoney -= price;
   }

   /** Player's attack speech */
   @Override
   public void attackSpeech() {
      System.out.println(getName() + ": Ready to fight or not!!");
   }

   /** Player's win speech */
   @Override
   public void winSpeech() {
      System.out.println(getName() + ": I knew I could do it!");
   }

   /** Player's loss speech */
   @Override
   public void lossSpeech() {
      System.out.println(getName() + ": Man, I thought I improved... Guess not.");
   }

   /**
    * Displays which type of style the user inputs
    * 
    * @return style chosen by user
    */
   @Override
   public int chooseStyle() {
      System.out.println("What would you like to do?");
      System.out.println("1. Basic Attack");
      System.out.println("2. Special Attack");

      int choice = CheckInput.checkIntRange(1, 2);
      return choice;
   }

   /**
    * Displays basic or special menu Depends on user's input in chooseStyle()
    * 
    * @return a certain move chosen by user
    */
   @Override
   public int chooseMove(int style) {
      int choice;

      if (style == 1) {
         getCurrentPokemon().displayBasicMenu();
         choice = CheckInput.checkIntRange(1, 3);
         return choice;
      } else {
         getCurrentPokemon().displaySpecialMenu();
         choice = CheckInput.checkIntRange(1, 3);
         return choice;
      }
   }

   /**
    * Gets location of the player
    * 
    * @return current point location
    */
   public Point getLocation() {
      return mLocation;
   }

   /**
    * Sets location to point Will set location IF: Location is in bounds of
    * array ELSE: Location does not change
    * 
    * @param p
    *           Point location that may be moved
    * @return True if location can move False if location cannot move
    */
   public boolean setLocation(Point p) {
      // Checks to see if current location is in bounds
      mLocation = p;
      return true;
   }

   /**
    * Gets the current map number that player is on
    * 
    * @return current map number
    */
   public int getLevel() {
      return mLevel;
   }

   /**
    * Increase the current map number that player is on
    * 
    * @return current map number
    */
   public void incLevel() {
      mLevel++;
   }

   /**
    * Moves the player up one space
    * 
    * @param m
    *           Retrieves the map
    * @return Character at the new location
    */
   public char goNorth(Map m) {
      Point north;

      north = new Point(mLocation.x - 1, mLocation.y);
      mLocation = north;

      return m.getCharAtLoc(mLocation);
   }

   /**
    * Moves the player down one space
    * 
    * @param m
    *           Retrieves the map
    * @return Character at the new location
    */
   public char goSouth(Map m) {
      Point south;

      south = new Point(getLocation().x + 1, getLocation().y);
      mLocation = south;

      return m.getCharAtLoc(mLocation);
   }

   /**
    * Moves the player right one space
    * 
    * @param m
    *           Retrieves the map
    * @return Character at the new location
    */
   public char goEast(Map m) {
      Point east;

      east = new Point(getLocation().x, getLocation().y + 1);
      mLocation = east;

      return m.getCharAtLoc(mLocation);
   }

   /**
    * Moves the player left one space
    * 
    * @param m
    *           Retrieves the map
    * @return Character at the new location
    */
   public char goWest(Map m) {
      Point west;

      west = new Point(getLocation().x, getLocation().y - 1);
      mLocation = west;

      return m.getCharAtLoc(mLocation);
   }

}
