package bank.command;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;

public class WithDrawCommand implements Command{
	
	long accountNumber;
	IAccountDAO accountDao;
	Account account;
	double amount;
	
	public WithDrawCommand(long accountNumber, double amount,IAccountDAO accountDao) {
		this.accountNumber = accountNumber;
		this.accountDao = accountDao;
		this.account= accountDao.loadAccount(accountNumber);
		this.amount= amount;
	}

	@Override
	public void execute() {
		account.withdraw(amount);
		accountDao.updateAccount(account);
		
	}

	@Override
	public void undo() {
		account.deposit(amount);
		accountDao.updateAccount(account);
		
	}

}
