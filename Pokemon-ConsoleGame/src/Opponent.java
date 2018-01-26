/**
 * Opponent is a representation of a Pokemon player which extends from Trainer
 * 
 * @author jenniferluong
 *
 */
public class Opponent extends Trainer {
   /** Opponent's attack speech */
   private String atkSpeech;

   /** Opponent's loss speech */
   private String lossSpeech;

   /** Opponent's win speech */
   private String winSpeech;

   /** Two Types: Basic or Special */
   private final int AMT_STYLES = 2;

   /** Three types of attacks */
   private final int AMT_MOVES = 3;

   /**
    * Initializes opponent's name, hp, and speeches
    * 
    * @param name
    *           name of opponent
    * @param hp
    *           amount of HP of opponent
    * @param attack
    *           attack speech
    * @param loss
    *           loss speech
    * @param win
    *           win speech
    */
   public Opponent(String name, int hp, String attack, String loss, String win) {
      super(name, hp);
      atkSpeech = attack;
      lossSpeech = loss;
      winSpeech = win;
   }

   /** Attack speeches for each Opponent type */
   @Override
   public void attackSpeech() {
      System.out.println(atkSpeech);
   }

   /**
    * Gets opponent's attack speech
    * 
    * @return attack speech
    */
   public String getAttack() {
      return atkSpeech;
   }

   /** Win speeches for each opponent */
   @Override
   public void winSpeech() {
      System.out.println(winSpeech);
   }

   /**
    * Gets opponent's win speech
    * 
    * @return win speech
    */
   public String getWin() {
      return winSpeech;
   }

   /** Loss speeches for each opponent */
   @Override
   public void lossSpeech() {
      System.out.println(lossSpeech);
   }

   /**
    * Gets opponent's loss speech
    * 
    * @return loss speech
    */
   public String getLoss() {
      return lossSpeech;
   }

   /**
    * Random integer chooses attack style for opponent
    * 
    * @return randomly chosen style
    */
   @Override
   public int chooseStyle() {
      int style = (int) Math.random() * AMT_STYLES + 1;
      return style;
   }

   /**
    * Random integer chooses attack move from chooseStyle() for opponent
    * 
    * @return randomly chosen attack move
    */
   @Override
   public int chooseMove(int style) {
      int move = (int) Math.random() * AMT_MOVES + 1;
      return move;
   }
}