package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		Double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		Double withdrawLimit = sc.nextDouble();
		
		Account acc = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		Double amount = sc.nextDouble();
		
		try {
		acc.withdraw(amount);
		System.out.printf("New balance: %.2f%n", acc.getBalance());
		System.out.println();
		System.out.print("Would you like to make another withdrawal (y/n): ");
		char asw = sc.next().charAt(0);
		if (asw == 'y') {
			System.out.print("Enter amount for withdraw: ");
			amount = sc.nextDouble();
			acc.newwithdraw(amount);
			System.out.printf("New balance: %.2f%n", acc.getBalance());
		}else {
			System.out.printf("Shutting down");
		}
		}
		catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		
		
		sc.close();
	}

}
