package edu.yu.intro;

import java.util.Scanner;

/** "IterativeFactorial" for Yeshiva University.
*
* @author Ophir Amon
*/

public class IterativeFactorial{
	public static void main(final String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter 'n' -- counterwill calculate 'factorial(n)': ");
		long yourNumber = input.nextInt();
		long counter = yourNumber; 
		long result = 1;
		
		if (yourNumber < 0){
			System.out.println("Sorry, counter can only compute factorials of positive integers");
			System.exit(0);
		}
		while (counter > 0){
			result = result * counter;
			counter = counter - 1;
		}
		System.out.println("*************************************************");
		System.out.println("factorial(" + yourNumber + ") = " + result);
		System.out.println("***************************************************");		
	}
}