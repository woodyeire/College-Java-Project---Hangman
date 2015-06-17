/**
SimpleHangmanApp.java -- A simple word guessing game.
@author:	John Murphy
studentID:	x14124807
@date:          23/04/2015
*/
package simplehangman;

import java.util.Scanner;
public class SimpleHangmanApp {
    private boolean doYouWantToPlay;
    public static void main(String[] args){
    // declaring object of class Simple Hangman
    SimpleHangman simpleHangman = new SimpleHangman();
    boolean doYouWantToPlay = true;
    Scanner sc = new Scanner(System.in);
    
  // begins game
    while (doYouWantToPlay){
           // calls the method chooseWord to choose a random word
           simpleHangman.chooseWord();
           do {
           System.out.println();
           // calls the method displayNumberOfLives to display the number of remining lives.
           simpleHangman.displayNumberOfLives();
           System.out.println();
           // calls the method displayWordInProgress to display the word as underscores, but amending it to include all correct guessed letters.
           simpleHangman.displayWordInProgress();
           System.out.println();
           System.out.println();
           // displays all of the chosen letters. There is a bug that this is displaying duplicate arrays for each guess made. 
           simpleHangman.displayLettersChosen();
           System.out.println();
           System.out.println();
          
            // input 
            simpleHangman.checkLetter();  
         } 
           
           while (simpleHangman.numberOfLettersToChoose != 0);
        simpleHangman.gamesPlayed++;
        // allows user to play again or to quit the game
        System.out.println("Do you want to play again? Y/N: ");
        String answer;
        answer = sc.next();
        // if the user decides to quit, this will display game statistics and quit the application
        if ("n".equals(answer)){
            System.out.println("Game Statistics: ");
            System.out.println("Games Played: " + simpleHangman.gamesPlayed);
            System.out.println("Games Won: " + simpleHangman.gamesWon);
            System.out.println("Games Lost: " + simpleHangman.gamesLost);
            doYouWantToPlay = false;             
    }   
        // if the user decides to play again, this will reset the number of lives to 7 and restart the game
        if ("y".equals(answer)){
            simpleHangman.numberOfLives = 7;
            
            doYouWantToPlay = true;
    }
    }
}
}