package edu.yu.intro;

import java.util.Scanner;

/** "RefactoredSqrtApproximation" for Yeshiva University.
*
* @author Ophir Amon
*/

public class RefactoredSqrtApproximation{
	public static void main(final String[] args){
	
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter 'n' -- I will calculate all square roots from 0 to n (inclusive) using Babylonian approximation algorithm: ");
		int n = input.nextInt();
		
		try{
			double[] sqrts = calculateSquareRoots(n);
					
			System.out.println("*************************************************");
			for (int i = 0; i < sqrts.length; i++){
				System.out.printf("sqrt(%d) = %.3f%n", i, sqrts[i]);
			}
			System.out.println("*************************************************");
		}
		catch(IllegalArgumentException e){
			System.out.println(e);
			System.exit(0);
		}
	}
	
	/** If a is less than 0 , the method should
	 * throw an IllegalArgumentException
	 */
	public static double sqrt(double a){
		double currentX = a / 2;
		double newX = 0;
		
		if (a < 0){
			String msg = "The square root of a negative is undefined";
			System.err.println(msg);
			throw new IllegalArgumentException (msg);
		}
		if (a == 0){
			return 0;
		}
			
		
		while (true){
			newX = 0.5 * (currentX + (a / currentX));
			
			if (Math.abs(currentX - newX) < 0.0001){
				break;
			}
			else{
				currentX = newX;
			}
		}
		
		return newX;
	}

	/** This method calculates the square roots
	 * of all positive integers from 0 to n
	 * inclusive ( the input parameter ). The
	 * results are placed in the return value
	 * such that Array [i] contains the square
	 * root of i.
	 */
	public static double[] calculateSquareRoots(int n){
		if (n < 0){
			String msg = "n cannot be negative";
			throw new IllegalArgumentException (msg);
		}
		double[] sqrts = new double[n + 1];
		for(int i = 0; i <= n; i++){
			sqrts[i] = sqrt(i);
		}
		return sqrts;
	}
}
