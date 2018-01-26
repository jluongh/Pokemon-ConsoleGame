/**
 * 
 * Creates a Pokemon using the Pokemon class Can create wild, type, or starter
 * Pokemon
 * 
 * @author jenniferluong
 *
 */
public class PokemonMaker {

   /**
    * Wild pokemon includes all pokemon available Random int is pass through to
    * create: Charmander, Pikachu, Zapdos, Ponyta, Squirtle, Staryu, Bulbasaur,
    * Oddish
    * 
    * @return wild Pokemon
    */
   public static Pokemon makeWildPokemon() {
      final int AMT_CASES = 8;
      int randomNum = 1 + (int) (Math.random() * AMT_CASES);
      Pokemon wild;
      if (randomNum == 1) {
         wild = new Charmander();
      } else if (randomNum == 2) {
         wild = new Pikachu();
      } else if (randomNum == 3) {
         wild = new Zapdos();
      } else if (randomNum == 4) {
         wild = new Ponyta();
      } else if (randomNum == 5) {
         wild = new Squirtle();
      } else if (randomNum == 6) {
         wild = new Staryu();
      } else if (randomNum == 7) {
         wild = new Bulbasaur();
      } else {
         wild = new Oddish();
      }
      return wild;
   }

   /**
    * Creates a random type Pokemon: Fire, Water, Grass, Electric
    * 
    * @param type
    *           type of Pokemon inputted by user
    * @return type Pokemon created
    */
   public static Pokemon makeTypePokemon(int type) {
      final int AMT_CERTAIN = 2;
      int certain = 1 + ((int) Math.random() * AMT_CERTAIN);

      if (type == 1) {
         if (certain == 1) {
            return new Zapdos();
         } else {
            return new Pikachu();
         }
      } else if (type == 2) {
         if (certain == 1) {
            return new Ponyta();
         } else {
            return new Charmander();
         }
      } else if (type == 3) {
         if (certain == 1) {
            return new Squirtle();
         } else {
            return new Staryu();
         }
      }

      else {
         if (certain == 1) {
            return new Oddish();
         } else {
            return new Bulbasaur();
         }
      }
   }

   /**
    * Sets start Pokemon to: Charmander, Squirtle, Bulbasaur, or Pikachu
    * 
    * @param start
    *           inputted value by user
    * @return start Pokemon
    */
   public static Pokemon makeStartPokemon(int start) {
      if (start == 1) {
         return new Charmander();
      } else if (start == 2) {
         return new Squirtle();
      } else if (start == 3) {
         return new Bulbasaur();
      } else {
         return new Pikachu();
      }
   }
}
