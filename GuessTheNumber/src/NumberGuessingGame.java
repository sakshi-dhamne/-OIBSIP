/*The fun and easy project �Guess the Number� is a short Java project that allows the user to
 guess the number generated by the computer & involves the following steps:
The system generates a random number from a given range, say 1 to 100.
The user is prompted to enter their given number in a displayed dialogue box.
The computer then tells if the entered number matches the guesses number or it is higher/lower than the generated number.
The game continues under the user guessing the number.
You can also incorporate further details as:
Limiting the number of attempts.
Adding more rounds.
Displaying score.
Giving points based on the number of attempts.*/


import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
	
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    Random random = new Random();
	    
	    int range = 100;
	    int rounds = 5;
	    int max_attempts = 10;
	    int score = 100;
	    for (int i = 0; i < rounds; i++) {
	      int correct_guess = random.nextInt(range) + 1;
	      int attempts = 0;
	      boolean win = false;
	  
	      System.out.println("Round " + (i + 1));
	      System.out.println("Guess a number between 1 and " + range);
	        
	      while (!win && attempts < max_attempts) {
	        attempts++;
	        int guess1 = sc.nextInt();
	        if (guess1 == correct_guess) {
	          win = true;
	          System.out.println("Hurray!! You win!");
	          System.out.println("Attempts: " + attempts);
	          score = (max_attempts - attempts) * 10;
	          System.out.println("Score:" + score);
	         
	        } else if (guess1 > correct_guess) {
	          System.out.println("Too high. Try again.");
	        } else {
	          System.out.println("Too low. Try again.");
	        }
	      }
	      if (!win) {
	        System.out.println("Alas! You lose. The number was " + correct_guess);
	      }
	    }
	    System.out.println("Final Score: " + score);
	    sc.close();
	  }
	}