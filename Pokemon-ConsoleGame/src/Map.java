
/**
 * 
 * Map is a representation of a map
 * Includes opponents, wild pokemon, cities, and nothing
 * 
 * @author jenniferluong
 *
 */

import java.awt.Point;
import java.io.*;
import java.util.Scanner;

public class Map implements Serializable {
   /** A 2D Array representing a 5X5 Map */
   private char[][] mMap;
   /**
    * A 2D Boolean Array representing places the player has already encountered
    */
   private boolean[][] mRevealed;
   /** Height of the Map */
   private final int HEIGHT = 5;
   /** Width of the Map */
   private final int WIDTH = 5;

   /** Initializes the 2D arrays for a map */
   public Map() {
      // area of the map
      mMap = new char[HEIGHT][WIDTH];
      mRevealed = new boolean[HEIGHT][WIDTH];
   }

   /**
    * Reads "Area #" file Creates a map according to area number
    * 
    * @param areaNum
    *           Area number that will generate the corresponding map
    */
   public void generateArea(int areaNum) {
      Scanner read;

      String file = "Area" + areaNum;
      try {
         read = new Scanner(new File(file));

         for (int i = 0; i < mMap.length; i++) {
            String line = read.nextLine();
            String[] s = line.split(" ");
            for (int j = 0; j < mMap.length; j++) {
               mMap[i][j] = s[j].charAt(0);

               if (mMap[i][j] == 'c' || mMap[i][j] == 's') {
                  mRevealed[i][j] = true;
               } else {
                  mRevealed[i][j] = false;
               }
            }
         }

      } catch (FileNotFoundException fnf) {
         System.out.println("File not found.");
      }
   }

   /**
    * Gets the character at specific point location Uses the 2D map array to
    * find point
    * 
    * @param p
    *           Point that is found on map
    * @return character at given point
    */
   public char getCharAtLoc(Point p) {
      if ((p.x < 0 || p.x > 4) || (p.y < 0 || p.y > 4)) {
         return 'y';
      } else {
         return mMap[p.x][p.y];
      }
   }

   /**
    * Creates a display of generated map
    * 
    * True values are always visible Sets 'c', 's' to true
    * 
    * False values are shown as 'x' Sets rest of values to false
    * 
    * @param p
    *           Point is generally the player's current location on map
    */
   public void displayMap(Point p) {
      System.out.println("  ----------");
      for (int i = 0; i < mMap.length; i++) {
         System.out.print("| ");
         for (int j = 0; j < mMap.length; j++) {

            if ((p.x == i) && (p.y == j)) {
               System.out.print("* ");
            } else if (mRevealed[i][j] == true) {
               System.out.print(mMap[i][j] + " ");
            } else {
               System.out.print("x ");
            }
         }
         System.out.println("|");
      }
      System.out.println("  ----------");
   }

   /**
    * Finds start location on map Indicated by 's' on .txt file
    * 
    * @return point location of start
    */
   public Point findStartLocation() {
      Point start = null;
      for (int x = 0; x < HEIGHT; x++) {
         for (int y = 0; y < WIDTH; y++) {
            if (mMap[x][y] == 's') {
               start = new Point(x, y);
            }
         }
      }
      return start;
   }

   /**
    * Reveals the character at point location
    * 
    * @param p
    *           Point location that is going to be revealed
    */
   public void reveal(Point p) {
      mRevealed[p.x][p.y] = true;
   }

   /**
    * Removes the opponent at point location
    * 
    * @param p
    *           Point location that is going to be removed
    */
   public void removeOppAtLoc(Point p) {
      mMap[p.x][p.y] = 'n';
      mRevealed[p.x][p.y] = true;
   }

}