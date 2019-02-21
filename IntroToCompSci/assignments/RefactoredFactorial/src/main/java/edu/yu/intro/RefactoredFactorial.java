package edu.yu.intro;

import java.util.Scanner;

/** "RefactoredFactorial" for Yeshiva University.
*
* @author Ophir Amon
*/

public class RefactoredFactorial{
	public static void main(final String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter 'n' -- counterwill calculate 'factorial(n)': ");
		int n = input.nextInt();
		try{
			long result = factorial(n);
		
			System.out.println("*************************************************");
			System.out.println("factorial(" + n + ") = " + result);
			System.out.println("***************************************************");
		}
		catch(IllegalArgumentException e){
			System.out.println(e);
		}
		
		
	}
	
	/** Returns the value of the factorial
	 * function for the given parameter .
	 *
	 * @param int n non - negative integer
	 * input to the factorial function
	 * @return factorial value of n
	 * @throws IllegalArgumentException if
	 * n is a negative integer
	 */
	public static long factorial(int n){
		long counter = n; 
		long result = 1;
		
		if (n < 0){
			String msg = "The factorial of a negative number is undefined";
			System.err.println(msg);
			throw new IllegalArgumentException(msg);
		}
		
		while (counter > 0){
			result = result * counter;
			counter = counter - 1;
		}
		
		return result;
	}
	
}