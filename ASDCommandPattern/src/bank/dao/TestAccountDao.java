package bank.dao;

import java.util.ArrayList;
import java.util.Collection;

import bank.domain.Account;

public class TestAccountDao implements IAccountDAO {
	Collection<Account> accountlist = new ArrayList<Account>();

	public void saveAccount(Account account) {
		accountlist.add(account); // add the new
	}

	public void updateAccount(Account account) {
		Account accountexist = loadAccount(account.getAccountnumber());
		if (accountexist != null) {
			accountlist.remove(accountexist); // remove the old
			accountlist.add(account); // add the new
		}
		System.out.println("Update Account");

	}

	public Account loadAccount(long accountnumber) {
		for (Account account : accountlist) {
			if (account.getAccountnumber() == accountnumber) {
				return account;
			}
		}
		System.out.println("loadAccount");
		return null;
		
	}

	public Collection<Account> getAccounts() {
		return accountlist;
	}

}
