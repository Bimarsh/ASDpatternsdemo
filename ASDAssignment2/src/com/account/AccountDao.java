package com.account;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AccountDao {

	static Map<String, Account> mapOfAccounts = new HashMap<>();
	static List<AccountEntry> entries = new ArrayList<>();
	static {

		AccountEntry entry1 = new AccountEntry(LocalDate.now(), "100", "sdf", "asdf", "afdfsdf");
		AccountEntry entry2 = new AccountEntry(LocalDate.now(), "100", "sdf", "asdf", "afdfsdf");
		entries.add(entry1);
		entries.add(entry2);

		mapOfAccounts.put("1", new Account("1", new Customer("Bimarsh"), entries));
		mapOfAccounts.put("2", new Account("1", new Customer("Bimarsh"), entries));
	}

	void saveAccount(Account account) {
		mapOfAccounts.put(account.getAccountNumber(), account);
	}

	void updateAccount(Account account) {
		mapOfAccounts.get(account.getAccountNumber());
		mapOfAccounts.put(account.getAccountNumber(), account);
	}

	Account loadAccount(String accountNumber) {

		return mapOfAccounts.get(accountNumber);
	}

	List<Account> getAccounts() {

		return mapOfAccounts.keySet().stream().map(x -> mapOfAccounts.get(x)).collect(Collectors.toList());
	}

}
