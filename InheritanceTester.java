/* 
Trevon Herman         
Inheritance Tester 1.0

 								Work to do:

1) add toString method to BankAccount and SavingsAccount classes
2) Override the withdraw() in SavingsAccount so that it will not withdraw more money than is 
currently in the account.
3) Provide constructors for SavingsAccount
4) Add this feature to SavingsAccount: If you withdraw more than 3 times you are charged $10 fee 
and the fee is immediately withdrawn from your account.once a fee is deducted you get another 3 free withdrawals.
5) Implement the Comparable Interface for SavingsAccount based on balance.
Once you finish adding/modifying the code make sure it compiles and run.
Submit your modified InheritanceTester.java file to the assignment folder

Warning: Notice that there are 3 classes in one file, and only one of them is public, 
and this public class name should be the filename. Be careful about the { } braces.
 */
public class InheritanceTester{
	public static void main(String[] args){
		SavingsAccount tom = new SavingsAccount(5000);
		SavingsAccount kim = new SavingsAccount();
		tom.withdraw(100);tom.withdraw(1000);tom.withdraw(200);
		kim.withdraw(100);//should print error message: Insufficient balance
		System.out.println(tom);//should print $3700 as balance
		tom.withdraw(1000);
		System.out.println(tom);//should print $2690 as balance, and fee charged
		tom.withdraw(1000);
		System.out.println(tom);//should print $1690 as balance
	}
}

class BankAccount
{
	private double balance;
	public BankAccount()
	{      balance = 0;   }

	public BankAccount(double initialBalance)
	{      balance = initialBalance;   }

	public void deposit(double amount)
	{      balance = balance + amount;   }

	public void withdraw(double amount)
	{      balance = balance - amount;   }

	public double getBalance()
	{      return balance;   }

	public int compareTo(SavingsAccount p2) //Added this method so the compareTo method from the book could work
	{
		return 0;
	}


}

class SavingsAccount extends BankAccount{ //add code

	private double balance;
	private double deposit;

	public SavingsAccount(double initialBalance)
	{
		this.balance = initialBalance;
	}

	public SavingsAccount() //sets the balance to 0
	{
		balance = 0;
	}

	public void withdrawFee() //withdrawal fee
	{
		balance = balance - 10;
		deposit = 0;
	}

	public void withdraw(double amount) // checks to see if withdrawal amount is 3 or more
	{
		if ((balance - amount < 0))
		{
			System.out.println("Insufficient balance");
		}
		else
		{
			balance = balance - amount; // checks if money was withdrawn more than 3 times 
			deposit++;
			if(deposit > 3)
			{
				withdrawFee();
			}
		}
	}

	public String toString() //toString method to print out the balance 
	{
		return ("Savings Account balance is " + balance + " dollars.");
	}

	public static void test(BankAccount p1, SavingsAccount p2) //my attempt to do a compareTo method, I tried but im having problems looking at the book method for this problem.
	{
		int result = p1.compareTo(p2);
		if (result < 0)
		{
			System.out.println("more");
		}
		else if (result == 0)
		{
			System.out.println("same");
		}

	}
}




/* 
 
Output 
Insufficient balance
Savings Account balance is 3700.0 dollars.
Savings Account balance is 2690.0 dollars.
Savings Account balance is 1690.0 dollars.

Not sure how to do the compareTo method.

 */


