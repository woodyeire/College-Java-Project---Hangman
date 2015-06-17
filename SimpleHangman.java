/**
SimpleHangman.java -- processing and functionality for SimpleHangmanApp which is a word guessing game.
@author:	John Murphy
studentID:	x14124807
@date:          23/04/2015
*/
package simplehangman;

import java.util.Scanner;
public class SimpleHangman {
    
    // begin declaring variables
    int numberOfLives;
    private String chosenWord;
    private char[] lettersChosen;
    private String[] words;
    private char[] wordInProgress;
    int gamesPlayed;
    int gamesWon;
    int gamesLost;
    private Scanner sc = new Scanner(System.in);
    private int rand;
    private String Word;
    private char guessedLetter;
    private boolean correctGuess = false;
    int numberOfLettersToChoose;
    
    // delcaring constructor. Call this from App class by use of "simpleHangman.<method>"
    // initializing some variables.
public SimpleHangman(){
lettersChosen = new char[26];
// filling char array with blank spaces
for (int i = 0; i < 26; i++){
lettersChosen[i] = ' ';
}
numberOfLives = 7;
words = new String[]{"programming", "serendipity", "exhaustive", "violin", "selection", "repetition","laptop", "instrument", "methodology", "convenient", "national", "college","ireland", "industrial", "space", "cowboy", "astronaut", "bonkers","database", "infidelity", "banana", "hunter", "salt", "inevitable","alcoholic", "spontaneous", "africa", "swahili", "supernatural", "canoe"};
gamesPlayed = 0;
gamesWon = 0;
gamesLost = 0;
}

    // Displays the Remaining number of lives
    public void displayNumberOfLives(){
        System.out.println("Lives Remaining: " + numberOfLives);
        
}

   // Displays the Word in Progress
    public void displayWordInProgress(){
        System.out.print("Word: ");
        // iterating through chosen word, displaying correctly guessed letters in their respective places
        for (int i = 0; i < Word.length(); i++){
            System.out.print(" " + wordInProgress[i] + " ");
            
        }
       
        }    
    
   // Displays all of the letters that have been guessed.
    public void displayLettersChosen(){
        System.out.print("Letters Guessed: ");
        for (int i = 0; i < 26; i++){
        if (lettersChosen[i] != ' '){
        System.out.print(lettersChosen);
        }
    }}
    
    
    // Chooses the word from the array, displays text indicating how many letters there are in the word.
    // Also, stores underscores in a character array called wordInProgress which is generated to the size of the chose word.
    
    public void chooseWord(){
        rand = (int)(Math.random()*29);
        Word = words[rand];
        System.out.println("A random word has been chosen. There are " + Word.length() + " letters.");
        wordInProgress = new char[Word.length()];
        // iterating through the chosen word, displaying underscores in place of each character in the word
        for (int i = 0; i < Word.length(); i++){
        wordInProgress[i] = '_';
        numberOfLettersToChoose = Word.length();
        }
    }
    
    // This prevents the player from guessing the same letter twice by use of a boolean.
    public boolean letterIsThere(char letter) {
        boolean letterExists = false;
        for (int i = 0; i < 26; i++){
            // checks if the guessed letter is already stored in the lettersChosen array
        if (letter == lettersChosen[i]){
        letterExists = true;
        System.out.println("Sorry, you've already used that letter. Please guess again.");
        }
        // if the letter does not exist in the array, it will store the letter in the array
        else if (lettersChosen[i] == ' '){
            lettersChosen[i] = letter;
            break;
        }
        
    }
        return letterExists;
    }
   
    
    
    // Checks the guessed letter to see if it is a match
    public void checkLetter(){
        correctGuess = false;
        do {
        System.out.print("Guess a letter: ");
        guessedLetter = sc.next().charAt(0);
        } while (letterIsThere(guessedLetter));
        // iterating through the chosen word to see if the guessed letter matches any of the letters in the word
            for (int i = 0; i < Word.length(); i++){
                if (guessedLetter == Word.charAt(i)){
                    // if the letter is a match, this stores it in the wordInProgress array
                    wordInProgress[i] = guessedLetter;
                    correctGuess = true;
                   // this reduces the amount of remaing letters the player has to guess by 1 for each character in wordInProgress that is not equal to "_"
                    if (wordInProgress[i] != '_'){
                        numberOfLettersToChoose--; 
                        
            }
         
            }       
                // this will end the round of the game if all of the letters have been guessed and displays the word.
                if (numberOfLettersToChoose == 0){
                    System.out.println("Congratulations, you've guessed the word!");
                    System.out.println("The word was: " + Word);
                    gamesWon++;
                    
            }
                
        }       // this will reduce the number of lives if the player was unable to guess the word.
            if (!correctGuess) {
                    numberOfLives--;
              
            }
            // this will inform the user if they have run out of lives and will display the word.
            // It will also set the number of lives to 0 to end the game.
            if (numberOfLives == 0){
                    System.out.println("Sorry, you were unable to guess the correct word this time!");
                    System.out.println("The word was: " + Word);
                    gamesLost--;
                    numberOfLettersToChoose = 0;
            }      
            
            
        }
}