package edu.yu.intro;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;

/** "ExceptionalEmployeePay" for Yeshiva University.
*
* @author Ophir Amon
*/

public class ExceptionalEmployeePay{
	public static void main(final String[] args){
		if (args.length != 1) {
			final String msg = "Usage: ExceptionalEmployeePay name_of_input file";
			System.err.println(msg);
			throw new IllegalArgumentException(msg);
		}
		final String inputFileName = args [0];
		final File fileInput = new File(inputFileName);
		
		Scanner input = null;
		try{
			input = new Scanner(fileInput);
		}
		catch(FileNotFoundException e){
			System.out.println("Error occurred: file not found");
			System.exit(0);
		}
		
		double totalGrossPay = 0;
		double totalTaxPaid = 0;
		String highestGrossPaidEmployee = "";
		double highestGrossPayAmount = 0;
		
		int lineNumber = 0;
		
 			
		
		System.out.println("*************************************************");
		System.out.printf("%20s%15s%15s%15s%15s%n", "Id", "Gross Pay", "Taxes", "Net Pay", "Average Pay");
		
		while (input.hasNext()){
			lineNumber++;
			String errorMessage = "Problem at line # " + lineNumber + ": ";
			
			String line = input.nextLine();
			StringTokenizer tokens = new StringTokenizer(line);
			
			if (tokens.countTokens() != 4){
				System.out.println(errorMessage + "Expected 4 tokens per line, found " + tokens.countTokens() + ". Discarding input & advancing" );
				continue;
			}
			String next = "";
			String employeeId = tokens.nextToken();
			
			double hoursWorked;
			next = tokens.nextToken();
			try{
				hoursWorked = Double.parseDouble(next);
			}
			catch(NumberFormatException e){
				System.out.println(errorMessage + "Could not parse Hrs Worked ['" + next + "'] into valid input");
				continue;
			}
			double wageRate;
			next = tokens.nextToken();
			try{
				wageRate = Double.parseDouble(next);
			}
			catch(NumberFormatException e){
				System.out.println(errorMessage + "Could not parse Wage Rate ['" + next + "'] into valid input");
				continue;
			}
			int deductions;
			next = tokens.nextToken();
			try{
				deductions = Integer.parseInt(next);
			}
			catch(NumberFormatException e){
				System.out.println(errorMessage + "Could not parse Deductions ['" + next + "'] into valid input");
				continue;
			}
		
			
			
			if (hoursWorked < 1.0){
				System.out.println(errorMessage + "'hrs worked' must be at least 1.0 -- but found " + hoursWorked);
				continue;
			}
			if (wageRate < 15.0){
				System.out.println(errorMessage + "'wage rate' must be at least $15 -- but found " + wageRate);
				continue;
			}
			if (deductions < 0){
				System.out.println(errorMessage + "'deductions' too small -- " + deductions);
				continue;
			}
			else if (deductions >= 35){
				System.out.println(errorMessage + "'deductions' too big -- " + deductions);
				continue;
			}
			
			double grossPay = hoursWorked * wageRate;
			double taxes = grossPay * .15;
			double netPay = grossPay - taxes - deductions - (grossPay * .05);
			double averagePay = netPay / hoursWorked;
			
			if (netPay < 0){
				System.out.print(errorMessage + "net pay must be positive -- " + netPay);
				continue;				
			}
			
			totalGrossPay += grossPay;
			totalTaxPaid += taxes;
			if (grossPay > highestGrossPayAmount){
				highestGrossPayAmount = grossPay;
				highestGrossPaidEmployee = employeeId;
			}
			
			String employeeIdString = "Employee Id:";
			String hoursWorkedString = "Hours Worked:";
			String wageRateString = "Wage Rate:";
			String deductionsString = "Deductions:";
			String grossPayString = "Gross Pay:";
			String taxesString = "Taxes:";
			String netPayString = "Net Pay:";
			String averagePayString = "Average Pay:";
			
			System.out.printf("%20s%15.2f%15.2f%15.2f%15.2f%n", employeeId, grossPay, taxes, netPay, averagePay);			
		}
		System.out.printf("%n%40s%2.2f%n", "Total Gross Pay: ", totalGrossPay);
		System.out.printf("%40s%2.2f%n", "Total Taxes: ", totalTaxPaid);
		System.out.printf("%40s%2s%n", "Employee with Largest Gross Pay: ", highestGrossPaidEmployee);
		System.out.println("*************************************************");
				
	}
}