package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Account account;

		System.out.print("Enter account number: ");
		int number = sc.nextInt();
		
		System.out.print("Enter account holder: ");
		sc.nextLine(); // Clear buffer from previous input
		String name = sc.nextLine();
		
		char flag = ' ';
		do {			
			System.out.print("Is there a initial deposit (y/n)? ");
			flag = sc.next().charAt(0);
		} while(flag != 'y' && flag != 'n');
				
		if (flag == 'y') {
			System.out.print("Enter initial deposit value: ");
			double initialDeposit = sc.nextDouble();
			account = new Account(number, name, initialDeposit);
		} else {
			account = new Account(number, name);
		}
		
		
		System.out.println();
		System.out.println("Your account: ");
		System.out.println(account.toString());
		
		System.out.println();
		char operation = ' ';
		while(true) {
			System.out.print("Operation (d - deposit / w - withdraw): ");
			sc.nextLine();
			operation = sc.nextLine().charAt(0);				
			
			if (operation == 'd') {			
				System.out.println();
				System.out.print("Enter a deposit value: ");
				double value = sc.nextDouble();
				account.deposit(value);
				System.out.println(account.toString());
				System.out.println();
			} else if (operation == 'w') {
				System.out.println();
				System.out.print("Enter a withdraw value: ");
				double value = sc.nextDouble();
				account.withdraw(value);
				System.out.println(account.toString());		
				System.out.println();
			} else {
				break;
			}
		}
		
		sc.close();
	}

}
