package edu.yu.intro;

import java.util.Scanner;

/** "FermatsLastTheorem" for Yeshiva University.
*
* @author Ophir Amon
*/

public class FermatsLastTheorem{
	public static void main(final String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter four integers: ");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double n = input.nextDouble();
		
		System.out.println("*************************************************");
		System.out.println("INPUT ...");
		System.out.printf("   a: %.6f%n" , a);
		System.out.printf("   b: %.6f%n" , b);
		System.out.printf("   c: %.6f%n" , c);
		System.out.printf("(coefficient n): %.6f%n%n" , n);
		
		if (a < 1){
			System.out.println("Error: " + a + " is not a valid input. Please enter a positive integer");
			System.exit(0);			
		}
		if (b < 1){
			System.out.println("Error: " + b + " is not a valid input. Please enter a positive integer");
			System.exit(0);
		}
		if (c < 1){
			System.out.println("Error: " + c + " is not a valid input. Please enter a positive integer");
			System.exit(0);
		}
		if (n < 1){
			System.out.println("Error: " + n + " is not a valid input. Please enter a positive integer");
			System.exit(0);
		}
				
		int roundedA = (int) a;
		int roundedB = (int) b;
		int roundedC = (int) c;
 		int roundedN = (int) n;

		if (roundedA < a){
			System.out.println("Error: " + a + " is not a valid input. Please input an integer");
			System.exit(0);
		}
		if (roundedB < b){
			System.out.println("Error: " + b + " is not a valid input. Please input an integer");
			System.exit(0);
		}
		if (roundedC < c){
			System.out.println("Error: " + c + " is not a valid input. Please input an integer");
			System.exit(0);
		}
		if (roundedN < n){
			System.out.println("Error: " + n + " is not a valid input. Please input an integer");
			System.exit(0);
		}
				
		double aToTheN = Math.pow(a, n);
		double bToTheN = Math.pow(b, n);
		double cToTheN = Math.pow(c, n);		
		double sumOfPowers = aToTheN + bToTheN;
		
		System.out.println("OUTPUT ...");
		System.out.println("Evaluating " + (int) aToTheN + " + " + (int) bToTheN + " ==? " + (int) cToTheN + ": " + (sumOfPowers == cToTheN));
				
		if (n > 2 && sumOfPowers == cToTheN){
			System.out.println("Major discovery: I just proved that Fermat was wrong!.");
		}
		else if (n > 2 && sumOfPowers != cToTheN){
			System.out.println("Hmm ... you haven't disproved Fermat's theorem yet");
		}
		else if ((n == 1 || n == 2) && (sumOfPowers != cToTheN)){
			System.out.println("The sums are not equal but irrelevant to Fermat's theorem which applies to n > 2. (Note: there are an infinite number of positive integer solutions(they are known as \"Pythagorean triples\"); the input happened not to be one of those solutions.)");
		}
		else if ((n == 1 || n == 2) && (sumOfPowers == cToTheN)){
			System.out.println("The sums are equal, but irrelevant to Fermat's theorem which applies only to n > 2");
		}
		System.out.println("*************************************************");
	}
	
}