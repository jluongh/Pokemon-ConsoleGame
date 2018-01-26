
/**
 * Creates an opponent using the Opponent class
 * 
 * @author jenniferluong
 *
 */

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class OpponentMaker {

   /** Creates an array of opponents **/
   private ArrayList<Opponent> opponentList;

   /**
    * OpponentMaker creates a random opponent based on a given file
    */
   public OpponentMaker() {
      opponentList = new ArrayList<Opponent>();

      int hp;
      String name, attack, loss, win;
      Opponent opponent;

      try {
         Scanner read = new Scanner(new File("OpponentList"));

         do {
            name = read.nextLine();
            hp = Integer.parseInt(read.nextLine());
            attack = read.nextLine().replace('#', '\n');
            loss = read.nextLine().replace('#', '\n');
            win = read.nextLine().replace('#', '\n');
            opponent = new Opponent(name, hp, attack, loss, win);
            opponentList.add(opponent);

         } while (read.hasNext());

         read.close();

      } catch (FileNotFoundException fnf) {
         System.out.println("File was not found.");
      }
   }

   /**
    * Creates a random type opponent. Adds pokemon of their type. Includes
    * opponent of all types
    * 
    * @return Opponent of random
    */
   public Opponent makeRandomOpponent() {
      int random = 1 + (int) (Math.random() * opponentList.size() - 1);

      Opponent o = opponentList.get(random);
      Opponent randomOpp = new Opponent(o.getName(), o.getHp(), o.getAttack(), o.getLoss(), o.getWin());

      randomOpp.addPokemon(PokemonMaker.makeWildPokemon());

      if (randomOpp.getName().equals("Team Rocket")) {
         randomOpp.addPokemon(PokemonMaker.makeWildPokemon());
      }

      return randomOpp;
   }
}
