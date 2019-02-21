package edu.yu.intro;

import java.util.Scanner;

public class CelsiusToFahrenheit{
	public static void main(final String[] args){
		Scanner input = new Scanner(System.in); 
		System.out.print("Enter temperature in Celsius: ");
		double celsius = input.nextDouble();
		double fahrenheit = celsius * 9 / 5 + 32;
		System.out.printf("%.1f C = %.1f F", celsius, fahrenheit);
	}
}