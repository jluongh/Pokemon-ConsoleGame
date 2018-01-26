/**
 * Pokemon battles are battles that the Player encounters throughout the game
 * 
 * @author jenniferluong
 *
 */
public class PokemonBattles {

   /**
    * A 2D array that represents the pokemon's effectiveness towards its
    * opponent
    */
   final static double[][] fightTable = { { .5, .5, 2, 1 }, { 2, .5, .5, 1 }, { .5, 2, .5, 1 }, { 1, 2, .5, .5 } };

   /** Is the player able to run away from battle? */
   private static boolean mRun;

   /**
    * The amount of damage and effectiveness will be done on the defender Uses
    * the fightTable and battle() to find out HP is lost
    * 
    * @param attacker
    *           Player using an attack move
    * @param defender
    *           Player losing HP
    */
   private static void trainerBattle(Trainer attacker, Trainer defender) {
      int damage = attacker.battle();
      double effectiveness = fightTable[attacker.getCurrentPokemon().getType()][defender.getCurrentPokemon().getType()];
      defender.getCurrentPokemon().loseHp((int) (damage * effectiveness));
   }

   /**
    * Sets up a Pokemon Bottle with a wild Pokemon
    * 
    * @param player
    *           User's player account
    * @param poke
    *           User's current pokemon
    */
   public static void wildPokeBattle(Player player, Pokemon poke) {
      Pokemon wild = PokemonMaker.makeWildPokemon();

      System.out.println("As you continue to walk, you encountered a wild Pokemon.");
      System.out.println("A wild " + wild.getName() + " Level: " + wild.getLevel() 
         + " HP: " + wild.getHp() + " has appeared!!");

      int choiceBattle = 0;

      //loop runs as long as fight is not over
      do {
         System.out.println(player.getCurrentPokemon().getName() 
            + " Level: " + player.getCurrentPokemon().getLevel()
            + " HP: " + player.getCurrentPokemon().getHp() 
            + " vs. " 
            + wild.getName() 
            + " Level: " + wild.getLevel()
            + " HP: " + wild.getHp());

         System.out.println("What do you do?");
         System.out.println("1. Fight");
         System.out.println("2. Use Potion");
         System.out.println("3. Use Pokeball");
         System.out.println("4. Switch Pokemon");
         System.out.println("5. Run Away");

         choiceBattle = CheckInput.checkIntRange(1, 5);

         switch (choiceBattle) {
         case 1: {
            // battle
            player.attackSpeech();

            // calls battle() to choose attack move
            int wildDamage = player.battle();

            // determines effectiveness of move
            double effective = fightTable[player.getCurrentPokemon().getType()][wild.getType()];

            // wild loses HP
            wild.loseHp((int) (effective * wildDamage));

            // gathers move and style to use fight() for wild Pokemon
            int move = 1 + (int) (Math.random() * 3);
            int style = 1 + (int) (Math.random() * 2);
            int pDamage = wild.fight(style, move);

            // determines effectiveness of move
            double OPPeffective = fightTable[wild.getType()][player.getCurrentPokemon().getType()];

            // player's pokemon loses HP
            player.getCurrentPokemon().loseHp((int) (pDamage * OPPeffective));

            // fainted wild
            if (wild.getHp() == 0) {
               System.out.println("You won the battle!");

               int exp = 1 + (int) (Math.random() * 100);
               player.getCurrentPokemon().gainExp(exp);
               mRun = true;

               player.winSpeech();
            }
            // you fainted
            else if (player.getCurrentPokemon().getHp() == 0) {
               System.out.println(player.getCurrentPokemon().getName() + " has fainted.");

               player.lossSpeech();
               // breaks out of while loop
               choiceBattle = 6;
            }
            break;
         } // end case 1
         case 2: {
            // spray potion
            System.out.println("You spray potion on " + player.getCurrentPokemon().getName());

            player.usePotion();

            break;
         }
         case 3: {
            // throw pokeball
            System.out.println("You throw a Pokeball at " + wild.getName() + ".");
            player.usePokeball();

            if (wild.getHp() < player.getHp()) {
               player.addPokemon(wild);

               System.out.println("Success! " + wild.getName() + " was added to your Pokemon list.");

               mRun = true;
               
               choiceBattle = 6; // breaks out of while loop
            } else {
               System.out.println("Aww, " + wild.getName() + " jumped out of the Pokeball.");
            }
            break;
         } // end case 2
         case 4: {
            // switch pokemon
            player.displayCurrentPokemon();
            System.out.println("\nList of pokemon");
            player.listPokemon();
            System.out.println("Which Pokemon would you like to switch with?");
            int choiceSwitch = CheckInput.checkInt();
            player.setCurrentPokemon(choiceSwitch - 1); // subtract 1 to match
                                                        // array list indexes
            break;
         }
         case 5: {
            // determines whether or not player can run away
            int runAway = 1 + (int) (Math.random() * 2);
            if (runAway == 1) {
               System.out.println("You successfully ran away.");
               choiceBattle = 6;
            } else {
               System.out.println("You can't run away!!");
            }
            break;
         } // end case 3
         }// end switch

      } while ((choiceBattle != 6) && (wild.getHp() > 0 && player.getCurrentPokemon().getHp() > 0));
   }

   /**
    * Sets up a Pokemon battle with an opponent
    * 
    * @param player
    *           User's player account
    * @param opponent
    *           Random opponent that was created in OpponentMaker()
    */
   public static void opponentBattle(Player player, Opponent opponent) {
      System.out.println("As you continue to walk, you run into " + opponent.getName());
      opponent.attackSpeech();

      int choiceBattle = 0;

      //loop runs as long as fight is not over
      do {
         // representation of versus
         System.out.println(player.getCurrentPokemon().getName() + " Level: " + player.getCurrentPokemon().getLevel()
               + " HP: " + player.getCurrentPokemon().getHp() + " vs. " + opponent.getCurrentPokemon().getName()
               + " Level: " + opponent.getCurrentPokemon().getLevel() + " HP: " + opponent.getCurrentPokemon().getHp());

         // menu
         System.out.println("What do you do?");
         System.out.println("1. Fight");
         System.out.println("2. Use Potion");
         System.out.println("3. Use Pokeball");
         System.out.println("4. Switch Pokemon");
         System.out.println("5. Run Away");

         // there are 5 case statements
         choiceBattle = CheckInput.checkIntRange(1, 5);

         switch (choiceBattle) {
         case 1: {

            trainerBattle(player, opponent);

            if (player.getCurrentPokemon().getHp() != 0) {
               trainerBattle(opponent, player);
            }

            if (opponent.getCurrentPokemon().getHp() == 0) {
               System.out.println("You won the battle!");
               if (player.getCurrentPokemon().getHp() == 0) {
                  System.out.println("However, your Pokemon has fainted!");
               }
               // random amount of exp to be gained ranging from 50-100
               int exp = 50 + (int) (Math.random() * 100);
               player.getCurrentPokemon().gainExp(exp);
               mRun = true;

               if (opponent.getNextCurPokemon() != 0) {
                  System.out.println("Hold on..." + opponent.getName() + " summoned "
                        + opponent.getCurrentPokemon().getName() + "!");
                  opponent.setCurrentPokemon(opponent.getNextCurPokemon());
               } else {
                  player.winSpeech();
                  opponent.lossSpeech();
                  // breaks out of loop
                  choiceBattle = 6;
                  mRun = true;

               }
            } else if (player.getCurrentPokemon().getHp() == 0) {
               System.out.println(player.getCurrentPokemon().getName() + " has fainted.");
               player.lossSpeech();
               opponent.winSpeech();
               // breaks out of loop
               choiceBattle = 6;
            }
            break;
         }
         case 2: {
            System.out.println("You spray potion on " + player.getCurrentPokemon().getName());
            player.usePotion();
            break;
         }
         case 3: {
            System.out.println("You throw a Pokeball at " + opponent.getCurrentPokemon().getName() + ".");
            player.usePokeball();
            System.out.println("Aww, " + opponent.getCurrentPokemon().getName() + " jumped out of the Pokeball.");
            System.out.println(opponent.getName() + ": HEYY!!! YOU CAN'T CATCH MY POKEMON!!");
            break;
         }
         case 4: {
            player.displayCurrentPokemon();
            System.out.println("\nList of pokemon");
            player.listPokemon();
            System.out.println("Which Pokemon would you like to switch with?");
            int choiceSwitch = CheckInput.checkInt();
            player.setCurrentPokemon(choiceSwitch - 1);
            break;
         }
         case 5: {
            int runAway = 1 + (int) (Math.random() * 2);
            if (runAway == 1) {
               System.out.println("You successfully ran away.");
               // breaks out of loop
               choiceBattle = 6;
            } else {
               System.out.println("You can't run away!!");
            }
            break;
         }
            // end switch
         }

      } while ((choiceBattle != 6)
            && (opponent.getCurrentPokemon().getHp() > 0 && player.getCurrentPokemon().getHp() > 0));

      System.out.println("You walk away and carry on with your journey.");

   }

   /**
    * Indicates whether the player was able to run away from battle
    * 
    * @return success/failure of running away
    */
   public static boolean getRun() {
      return mRun;
   }

   /**
    * Angry pokemon does damage to the player, not the Pokemon
    * 
    * @param trainer
    *           the user's player account
    */
   public static void angryPokemon(Trainer trainer) {
      System.out.println("Jigglypuff just appeared on the road singing...");
      System.out.println("\"Jig-guh-le-puff... Jig-guh-le... puff...");
      System.out.println(trainer.getName() + " is starting to fall asleep");

      int lost = 10;
      trainer.loseHp(lost);

      System.out.println(trainer.getName() + " lost " + lost + " HP.");
      System.out.println("Jigglypuff's lullaby was EFFECTIVE");

   }

   /**
    * Angry trainer does damage to the player, not the Pokemon
    * 
    * @param trainer
    *           the user's player account
    */
   public static void angryTrainer(Trainer trainer) {
      System.out.println("HEY YOU!!! STOP RIGHT THERE");
      System.out.println("Officer Jenny smacks you in the head and you lose 5HP.");

      int lost = 5;
      trainer.loseHp(lost);

      System.out.println("Officer Jenny: Oh whoops, sorry " + trainer.getName() + ". I didn't mean to hurt you!");
      System.out.println("Officer Jenny proceeds to walk away and you continue your journey.");
      System.out.println(trainer.getName() + " lost " + lost + " HP.");

   }
}
