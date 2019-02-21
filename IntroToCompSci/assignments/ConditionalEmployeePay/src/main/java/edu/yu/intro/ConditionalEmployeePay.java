package edu.yu.intro;

import java.util.Scanner;

/** "ConditionalEmployeePay" for Yeshiva University.
*
* @author Ophir Amon
*/

public class ConditionalEmployeePay{
	public static void main(final String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter employeeId, hrsWorked, wageRate, deductions: ");
		String employeeId = input.next();
		double hoursWorked = input.nextDouble();
		double wageRate = input.nextDouble();
		int deductions = input.nextInt();
		
		if (hoursWorked < 1.0){
			System.out.println("The minimum amount of hours you can work is 1 hour");
			System.exit(0);
		}
		if (wageRate < 15.0){
			System.out.println("The minimum hourly wage is $15 an hour");
			System.exit(0);
		}
		if (deductions < 0){
			System.out.println("deductions must be more than zero");
			System.exit(0);
		}
		else if (deductions >= 35){
			System.out.println("deductions cannot exceed $35");
			System.exit(0);
		}
		
		double grossPay = hoursWorked * wageRate;
		double taxes = grossPay * .15;
		double netPay = grossPay - taxes - deductions - (grossPay * .05);
		double averagePay = netPay / hoursWorked;
		
		if (netPay < 0){
			System.out.print("An error ocurred: net pay is a negative number. Please check your inputs and try again");
			System.exit(0);
		}
		
		String employeeIdString = "Employee Id:";
		String hoursWorkedString = "Hours Worked:";
		String wageRateString = "Wage Rate:";
		String deductionsString = "Deductions:";
		String grossPayString = "Gross Pay:";
		String taxesString = "Taxes:";
		String netPayString = "Net Pay:";
		String averagePayString = "Average Pay:";
		
		System.out.println("*************************************************");
		System.out.println("INPUT ...");
		System.out.printf("%-20s%s%n", employeeIdString, employeeId);
		System.out.printf("%-20s%.2f%n", hoursWorkedString, hoursWorked);
		System.out.printf("%-20s%.2f%n", wageRateString, wageRate);
		System.out.printf("%-20s%d%n", deductionsString, deductions);
		System.out.println("\n\n");
		System.out.println("OUTPUT ...");
		System.out.printf("%-20s%.2f%n", grossPayString, grossPay);
		System.out.printf("%-20s%.2f%n", taxesString, taxes);
		System.out.printf("%-20s%.2f%n", netPayString, netPay);
		System.out.printf("%-20s%.2f%n", averagePayString, averagePay);
		System.out.println("*************************************************");		
	}
}