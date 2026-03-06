package com.main;
/*
 * --------------------------------Main Class------------------------------------
 * 
 * Entry point of Use Case 1.
 * 
 * Execution Flow:
 * 	1. Take input from user
 * 	2. Validate user input
 * 	3. Create objects
 * 	4. Persist data
 * 	5. Display Confirmation
 * 
 * @author Preetham
 * @version 1.0
 */

import java.io.IOException;
import java.util.Scanner;

import com.employeeregistration.Employee;
import com.employeeregistration.UserAccount;
import com.validation.ValidationException;
import com.validation.Validator;


public class EmployeePayrollApp {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=== EMPLOYEE REGISTRATION ===");
		try {
			System.out.println("Enter name: ");
			String name = scanner.nextLine();
			System.out.println("Enter phone: ");
			String phone = scanner.nextLine();
			System.out.println("Enter email: ");
			String email = scanner.nextLine();
			System.out.println("Enter your password: ");
			String password = scanner.nextLine();
			Validator.validateEmail(email);
			Validator.validatePhone(phone);
			UserAccount userAccount = new UserAccount(email, password);
			Employee employee = new Employee(name, email, phone, userAccount);
			employee.persist();
		} catch(ValidationException e) {
			System.out.println("\nValidation Failed: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("\nError saving employee data!");
		}
		
		scanner.close();
	}
}