package edu.yu.intro;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;

/** "DepartmentalEmployeePay" for Yeshiva University.
*
* @author Ophir Amon
*/

public class DepartmentalEmployeePay{
	public static void main(final String[] args){
		if (args.length != 2) {
			final String msg = "Usage: DepartmentalEmployeePay employeeInputFile deptInputFile ";
			System.err.println(msg);
			throw new IllegalArgumentException (msg);
		}
		
		final String employeeInputFile = args [0];
		final String deptInputFile = args [1];
		
		final File employeeFile = new File(employeeInputFile);
		final File departmentFile = new File(deptInputFile);
		
		Scanner employeeInput = null;
		try{
			employeeInput = new Scanner(employeeFile);
		}
		catch(FileNotFoundException e){
			System.out.println("Error occurred: " + employeeInputFile + " not found");
			System.exit(0);
		}
		Scanner departmentInput = null;
		try{
			departmentInput = new Scanner(departmentFile);
		}
		catch(FileNotFoundException e){
			System.out.println("Error occurred: " + deptInputFile + " not found");
			System.exit(0);
		}
		
		String[] dept = new String[10];
		int arrayCounter = 0;
		
		while (departmentInput.hasNext()){
			if (arrayCounter == 10){
				final String msg = "Error: The maximimum number of departments is 10";
				System.err.println(msg);
			}
			String department = departmentInput.next();
			boolean duplicate = false;
			for(int i = 0; i < arrayCounter; i++){
				if (department.equals(dept[i])){
					System.out.println("Department: " + department + " has already been entered, disregarding duplicate department...\n");
					duplicate = true;
					break;
				}
			}
			if (duplicate){
				continue;
			}
			dept[arrayCounter] = department;
			arrayCounter++;
		}
		
		int[] numEmployeesInDept = new int[10];
		double[] deptGrossPay = new double[10];
		
		
		double totalGrossPay = 0;
		double totalTaxPaid = 0;
		String highestGrossPaidEmployee = "";
		double highestGrossPayAmount = 0;
		
		int lineNumber = 0;
		
		//System.out.println("*************************************************");
		//System.out.printf("%20s%15s%15s%15s%15s%n", "Id", "Gross Pay", "Taxes", "Net Pay", "Average Pay");
		
		
		while (employeeInput.hasNext()){
			lineNumber++;
			String errorMessage = "Problem at line # " + lineNumber + ": ";
			
			String line = employeeInput.nextLine();
			StringTokenizer tokens = new StringTokenizer(line);
			
			if (tokens.countTokens() != 5){
				System.out.println(errorMessage + "Expected 5 tokens per line, found " + tokens.countTokens() + ". Discarding input & advancing" );
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
			String department = tokens.nextToken();
			boolean exists = false;
			
			int index;
			
			for (index = 0; index < arrayCounter; index++){
				if (department.equals(dept[index])){
					exists = true;
					break;
				}
			}
			
			if (!exists){
				System.out.println("Department " + department + " associated with " + employeeId + " does not exist");
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
			
			//System.out.printf("%20s%15.2f%15.2f%15.2f%15.2f%n", employeeId, grossPay, taxes, netPay, averagePay);

			numEmployeesInDept[index]++;
			deptGrossPay[index] += grossPay;
			
		}
		//System.out.printf("%n%40s%2.2f%n", "Total Gross Pay: ", totalGrossPay);
		//System.out.printf("%40s%2.2f%n", "Total Taxes: ", totalTaxPaid);
		//System.out.printf("%40s%2s%n", "Employee with Largest Gross Pay: ", highestGrossPaidEmployee);
		
		System.out.println("*************************************************");
		System.out.printf("%20s%15s%20s%20s%n", "Department", "# Employees", "Total Gross Pay", "Average Gross Pay");
		for(int i = 0; i < arrayCounter; i++){
			int numEmployees = numEmployeesInDept[i];
			double departmentGrossPay = deptGrossPay[i];
			double averageGrossPay = 0;
			if(numEmployees != 0){
				averageGrossPay = departmentGrossPay / numEmployees;
			}
			System.out.printf("%20s%15d%20.2f%20.2f%n", dept[i], numEmployees, departmentGrossPay, averageGrossPay);
		}		
		System.out.println("*************************************************");
				
	}
}