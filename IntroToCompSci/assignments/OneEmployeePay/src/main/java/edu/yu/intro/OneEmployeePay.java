package edu.yu.intro;

import java.util.Scanner;

/** "OneEmployeePay" for Yeshiva University.
*
* @author Ophir Amon
*/

public class OneEmployeePay{
	public static void main(final String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter employeeId, hrsWorked, wageRate, deductions: ");
		String employeeId = input.next();
		double hoursWorked = input.nextDouble();
		double wageRate = input.nextDouble();
		int deductions = input.nextInt();
		
		double grossPay = hoursWorked * wageRate;
		double taxes = grossPay * .15;
		double netPay = grossPay - taxes - deductions - (grossPay * .05);
		double averagePay = netPay / hoursWorked;
		
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