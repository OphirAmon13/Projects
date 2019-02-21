package edu.yu.intro;

import java.util.Random;
import java.util.Scanner;

/** " Guess My Number " for Yeshiva University .
*
* @author Ophir Amon
*/
public class GuessMyNumber {
	public static void main (final String[] args){
		Random random = new Random();
		Scanner input = new Scanner(System.in);
		int randomNumber = random.nextInt(100) + 1;
		
		System.out.println("I'm thinking of a number between 1 and 100 (inclusive).");
		System.out.println("Can you guess what number it is?");
		System.out.print("Please type a number: ");
		
		int yourNumber = input.nextInt();
		
		System.out.println("You guessed: " + yourNumber);
		System.out.println("I was thinking of: " + randomNumber);
		System.out.println("You were off by: " + (randomNumber - yourNumber));
	}
}