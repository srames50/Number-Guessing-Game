// Shyam Ramesh
// This program is a guessing game where the computer generates a number between 1-100 and the user takes turns guessing the correct number
// The program tracks the users' stats such as total games, total guesses and best game which are all displayed once the user decides to stop playing
// accepted answers to keep playing are y, yes and yeehaw (none of which are case sensitive)

import java.util.*;

public class GuessingGame {
// In the main method we declare a scanner to collect user answers
// the playing boolean is used to check if the user still wants to play using a while loop
// on the outside I called the game method once for the first game to start, after that the number of games is conditional on user input
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalGames = 0;
        int totalGuess = 0;
        int bestGame = 10000; 
        String nextGame;
        boolean playing = true;
        
        totalGuess = game(input);
        totalGames += 1;
        System.out.print("Play again? ");
        nextGame = input.next();
        
        if(totalGuess < bestGame) {
    		bestGame = totalGuess;
    	}
        
        while (playing) {
        if(nextGame.equalsIgnoreCase("yes") || nextGame.equalsIgnoreCase("y") || nextGame.equalsIgnoreCase("yeehaw") ) {
        	System.out.println("");
        	totalGuess += game(input);
        	totalGames += 1;
        	
        	if(totalGuess < bestGame) {
        		bestGame = totalGuess;
        	}
        	
        	System.out.print("Play again? ");
            nextGame = input.next();
            
            
        } else {
        	
        	if(totalGuess < bestGame) {
        		bestGame = totalGuess;
        	}
        	
        	System.out.println("");
        	System.out.println("Your overall results: ");
        	System.out.printf("Total games = %d\n", totalGames);
        	System.out.printf("Total guesses = %d\n", totalGuess);
        	double tgu = totalGuess;
        	double tgm = totalGames;
        	double guessPer = tgu/tgm;
        	System.out.printf("Guesses/game = %.2f\n", guessPer);
        	System.out.printf("Best game = %d\n", bestGame);
        	playing = false;
        	
         }
        
        }
        
    }
    
    // this method is for the basic game function and it returns the number of total guesses for a single game
    public static int game(Scanner input) {
    	Random rand = new Random();
    	int answer = rand.nextInt(100) + 1;
    	boolean won = false;
    	int numGuesses = 0;
    	System.out.println("I'm thinking of a number between 1 and 100... ");
    	
    	while (!won) {
    		int gues;
    		System.out.print("Your guess? "); 
    		gues = input.nextInt();
    		numGuesses += 1;
    		if(gues > answer) {
    			System.out.println("It's lower.");
    		} else if(gues < answer) {
    			System.out.println("It's higher.");
    		} else if(gues == answer) {
    			won = true;
    			System.out.printf("You guessed it in %d guesses!\n", numGuesses);
    		}
    		
    		
    	}
    	return numGuesses;
    		
     }
    }
