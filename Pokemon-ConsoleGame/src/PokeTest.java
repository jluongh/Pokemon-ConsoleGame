/**
 * Plays a game of Pokemon
 * 
 * @author jenniferluong
 *
 */

import java.awt.Point;
import java.io.*;

public class PokeTest {

   /**
    * Includes information to create a game of Pokemon
    * @param args
    * @throws FileNotFoundException
    */
   public static void main(String[] args) {
      
      Player player = null;
      Map playerMap = null;

      File file = new File("pokemon.dat");
      
      int openFile = 0;
      
      if (file.exists()) {
         
         System.out.println("It appears that there is a saved file. Do you want to open it?");
         System.out.println("1. Yes");
         System.out.println("2. No");
         
         openFile = CheckInput.checkIntRange(1, 2);
         
         if (openFile == 1) {
            try {
               
               ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
               
               playerMap = (Map) in.readObject();
               player = (Player) in.readObject();
               
               in.close();
            } catch (IOException e) {
               System.out.println("Error processing file. 1");
            } catch (ClassNotFoundException e) {
               System.out.println("Cannot find class");
            }
         }
         else {

            playerMap = new Map();
            playerMap.generateArea(1);

            Point start = playerMap.findStartLocation();
            player = new Player("Ash Ketchum", 15, start);

            System.out.println("Choose your starter pokemon:");
            System.out.println("1. Charmander");
            System.out.println("2. Squirtle");
            System.out.println("3. Bulbasaur");
            System.out.println("4. Pikachu");

            int input = CheckInput.checkIntRange(1, 4);

            Pokemon starter = PokemonMaker.makeStartPokemon(input);

            player.addPokemon(starter);
         }
      }
      else {
         playerMap = new Map();
         playerMap.generateArea(1);

         Point start = playerMap.findStartLocation();
         
         player = new Player("Ash Ketchum", 15, start);
         
         System.out.println("Choose your starter pokemon:");
         System.out.println("1. Charmander");
         System.out.println("2. Squirtle");
         System.out.println("3. Bulbasaur");
         System.out.println("4. Pikachu");

         int input = CheckInput.checkIntRange(1, 4);

         Pokemon starter = PokemonMaker.makeStartPokemon(input);

         player.addPokemon(starter);
      }
      
      System.out.println("Let's begin the journey!");
      System.out.println("You're walking around the city with " + player.getCurrentPokemon().getName() + ".");
      System.out.println("What would you like to do?");

      int choiceMain = 0;
      int choiceSave = 0;
      int angriness = 1;

      do {
         
         System.out.println("Main Menu");
         System.out.println("1. Walk around");
         System.out.println("2. Switch Pokemon");
         System.out.println("3. Heal Current Pokemon");
         System.out.println("4. View Stats");
         System.out.println("5. Save");
         System.out.println("6. Quit");

         choiceMain = CheckInput.checkIntRange(1, 6);

         switch (choiceMain) {
         case 1: {
            int choiceMove = 0;

            boolean flag = true;

            while (flag) {
               
               playerMap.displayMap(player.getLocation());

               System.out.println("Would way would you like to go?");
               System.out.println("1. North");
               System.out.println("2. South");
               System.out.println("3. East");
               System.out.println("4. West");
               
               Point current = new Point (player.getLocation());

               choiceMove = CheckInput.checkIntRange(1, 4);
               try {
                     switch (choiceMove) {
                     case 1: {
                        player.goNorth(playerMap);
                        break;
                     }
                     case 2: {
                        player.goSouth(playerMap);
                        break;
                     }
                     case 3: {
                        player.goEast(playerMap);
                        break;
                     }
                     case 4: {
                        player.goWest(playerMap);
                        break;
                     }
                     }
   
                     playerMap.reveal(player.getLocation());
                     flag = false;
                     
               } catch (ArrayIndexOutOfBoundsException ob) {
                  System.out.println("Error. Cannot go off of map.");
                  player.setLocation(current);
               }
            }

            if (playerMap.getCharAtLoc(player.getLocation()) == 'o') {
               OpponentMaker o = new OpponentMaker();
               Opponent opponent = o.makeRandomOpponent();
               
               PokemonBattles.opponentBattle(player, opponent);
               
               if (PokemonBattles.getRun()) {
                  playerMap.removeOppAtLoc(player.getLocation());
               }
               else {

                  int randomRun;
                  Point current = new Point (player.getLocation());

                  do {
                     randomRun = 1 + (int) (Math.random() * 4);
                     player.setLocation(current);

                     switch (randomRun) {
                     case 1: {
                        player.goNorth(playerMap);
                        break;
                     }
                     case 2: {
                        player.goSouth(playerMap);
                        break;
                     }
                     case 3: {
                        player.goEast(playerMap);
                        break;
                     }
                     case 4: {
                        player.goWest(playerMap);
                        break;
                     }
                     }

                  } while (playerMap.getCharAtLoc(player.getLocation()) == 'y');
               }
               playerMap.reveal(player.getLocation());

            } 
            else if (playerMap.getCharAtLoc(player.getLocation()) == 'w') {
               PokemonBattles.wildPokeBattle(player, player.getCurrentPokemon());
               
               if (PokemonBattles.getRun()) {
                  playerMap.removeOppAtLoc(player.getLocation());
               }
               
               else {
                  int randomRun;
                  Point current = new Point (player.getLocation());
                  
                  do {
                     
                     player.setLocation(current);
                     randomRun = 1 + (int) (Math.random() * 4);
   
                     switch (randomRun) {
                     case 1: {
                        player.goNorth(playerMap);
                        break;
                     }
                     case 2: {
                        player.goSouth(playerMap);
                        break;
                     }
                     case 3: {
                        player.goEast(playerMap);
                        break;
                     }
                     case 4: {
                        player.goWest(playerMap);
                        break;
                     }
                     }
                  } while (playerMap.getCharAtLoc(player.getLocation()) == 'y');
               }
               playerMap.reveal(player.getLocation());
            } 
            
            else if (playerMap.getCharAtLoc(player.getLocation()) == 'c') {
               System.out.println("You've entered a city!");
               System.out.println("What would you like to do?");
               System.out.println("1. Go to the PokeMart.");
               System.out.println("2. Go to the PokeCenter.");
               System.out.println("3. Leave");

               int choiceCity = CheckInput.checkIntRange(1, 3);

               switch (choiceCity) {
               case 1: {
                  System.out.print("Welcome to the PokeMart! ");

                  int choiceMart = 0;

                  while (choiceMart != 3) {
                     System.out.println("What would you like to buy?");
                     System.out.println("1. 2 Pokeballs $5");
                     System.out.println("2. 3 Potions for $15");
                     System.out.println("3. Nothing");

                     choiceMart = CheckInput.checkIntRange(1, 3);

                     if (choiceMart == 1) {
                        player.buyPokeball();
                     } else if (choiceMart == 2) {
                        player.buyPotion();
                     }
                  }
                  break;
               } // end case 1
               case 2: {
                  System.out.print("Welcome to the PokeCenter! ");

                  int choiceCenter = 0;

                  System.out.println("What would you like to do?");
                  System.out.println("1. Heal all pokemon");
                  System.out.println("2. Nothing");

                  choiceCenter = CheckInput.checkIntRange(1, 2);

                  if (choiceCenter == 1) {
                     player.healAllPokemon();
                  }
                  break;
               }
                  // end switch
               }
            } 
            else if (playerMap.getCharAtLoc(player.getLocation()) == 'f') {
               if (player.getLevel() < 3) {
                  player.incLevel();
                  
                  playerMap.generateArea(player.getLevel());
                  player.setLocation(playerMap.findStartLocation());
                  
                  System.out.println("You just moved to a new map!");
                  System.out.println("In order to go back to the previous map, walk back onto 's'");
                  
                  System.out.println("Do you want to save?");
                  System.out.println("1. Yes");
                  System.out.println("2. No");
                  
                  choiceSave = CheckInput.checkIntRange(1, 2);

                  if (choiceSave == 1) {
                     try {
                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));

                        out.writeObject(playerMap);
                        out.writeObject(player);
                        
                     } catch (IOException e) {
                        System.out.println("Error processing file. 2");
                     }
                  }
               }
               
               System.out.println("You've reached the end of the game!");
               System.out.println("You can continue to walk around. If not, enter 2 to quit game.");
               System.out.println("1. Continue");
               System.out.println("2. Quit");
               int choiceQuit = CheckInput.checkIntRange(1, 2);
               
               if (choiceQuit == 2) {
                  choiceMain = 6;
               }

            } 
            else if (playerMap.getCharAtLoc(player.getLocation()) == 'n') {

               System.out.println("You encountered nothing.");
               
               angriness += 1;
               if (angriness == 5) {
                  System.out.println("Your pokemon is starting to get angry...");
                  PokemonBattles.angryPokemon(player);
                  angriness = 0;
               }
            }
            break;
         }
         case 2: {
            player.displayCurrentPokemon();
            System.out.println("\nList of pokemon");
            player.listPokemon();
            System.out.println("Which Pokemon would you like to switch with?");
            int choiceSwitch = CheckInput.checkInt();
            player.setCurrentPokemon(choiceSwitch - 1);
            break;
         }
         case 3: {
            player.usePotion();
            break;
         }
         case 4: {
            System.out.println("Stats for " + player.getName());
            System.out.println("HP: " + player.getHp());
            System.out.println("Potions: " + player.getNumPotionsLeft());
            System.out.println("Pokeballs: " + player.getNumPokeballsLeft());
            System.out.println("Pokemon:");
            player.listPokemon();
            break;

         }
         case 5: {
            System.out.println("Do you want to save?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            
            choiceSave = CheckInput.checkIntRange(1, 2);

            if (choiceSave == 1) {
               try {
                  ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));

                  out.writeObject(playerMap);
                  out.writeObject(player);
                  
               } catch (IOException e) {
                  System.out.println("Error processing file. 2");
               }
            }
            break;
         }
            // end switch
         }
         if (player.getHp() == 0) {
            System.out.println("Oh boo... It looks like you have no more HP. This is it. The end. Goodbye.");
            choiceMain = 6;
         }

      } while (choiceMain != 6);

      System.out.println("Goodbye!");

   }
}