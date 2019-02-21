package edu.yu.intro;

import java.util.Scanner;

/** "SqrtApproximation" for Yeshiva University.
*
* @author Ophir Amon
*/

public class SqrtApproximation{
	public static void main(final String[] args){
	
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter 'a' -- I will approxiate 'sqrt(a)': ");
		double a = input.nextDouble();
		double currentX = a / 2;
		double newX = 0;
		int numberOfIterations = 1;
		
		if (a < 0){
			System.out.println("The square root of a negative is undefined");
			System.exit(0);
		}
		if (a == 0){
			System.out.println("Number must be greater than zero");
			System.exit(0);
		}
			
		
		while (true){
			newX = 0.5 * (currentX + (a / currentX));
			
			if (Math.abs(currentX - newX) < 0.0001){
				break;
			}
			else{
				currentX = newX;
			}
			numberOfIterations++;
		}
		double difference = Math.abs(newX - Math.sqrt(a));
		System.out.println("*************************************************");
		System.out.printf("sqrt(%.3f) = %.3f after %d iteration(s): [difference from Math.sqrt = %.8f]%n", a, newX, numberOfIterations, difference);
		System.out.println("*************************************************");
	}
}