import java.io.*;
import java.util.*;

public class AccountClient {

	public static void main(String[] args) {
		ArrayList<BankAccount> accts = new ArrayList<BankAccount>();
		loadAccounts(accts);		// reads a file from disk, creates a bunch of accounts, and puts them in accts

		// 1. Perform the following five transactions on the first account in the accts array list
		//		deposit $10, withdraw $30, withdraw $40, deposit $1122.45, withdraw $0.15

		// 2. Perform end of month processing by calling endOfMonth() on every account in the list

		// 3. Print the master list of all accounts by calling .toString on each account, implicitly (this can be included with #2)

		// 4. Calculate and print the sum of all accounts at the bank (this can be included with #2).  The answer should be: $101,942.26

		// 5. Answer this question, right here in the code, in the comments:
		//	  
		//    Of the following methods, some you called directly from this client, some were called as a result of you calling 
		//    something else.  Next to each method name below, type one of "inherited" "overridden" or "unique to child", depending
		//    on whether the method was inherited from the parent (and unchanged), inherited from the parent and overridden, or written
		//    in the child only:
		//    a. CheckingAccount.depost() 
		//    b. CheckingAccount.withdraw()	
		//    c. SavingsAccount.depost()
		//    d. SavingsAccount.withdraw() 
		//    e. endOfMonth() 
		//    f. toString()	
		//    g. getBalance() 
		//    h. deductFees()	
		//    i. addInterest()	

		// 6. Of the above list of methods, which ones represent object oriented "polymorphism" in this client?

	}

	public static void loadAccounts(ArrayList<BankAccount> accts) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("accts.txt"));
			String line = in.readLine();
			while (line != null) {
				String[] parts = line.split("\t");	// lines are tab delimited in the file, split up the parts
				BankAccount a = null;
				if (parts[0].equals("S"))
					a = new SavingsAccount(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]), parts[3], parts[4]);
				else
					a = new CheckingAccount(Double.parseDouble(parts[1]), parts[2], parts[3]);
				accts.add(a);
				line = in.readLine();
			}
			
		}
		catch (Throwable t){
			t.printStackTrace();
			System.exit(1);
		}
		finally {
			try { in.close(); }
			catch(Throwable t){}
		}
	}

}
