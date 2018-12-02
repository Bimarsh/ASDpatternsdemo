package bank.command;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;

public class TransferCommand implements Command {

	IAccountDAO accountDao;
	Account fromAccount;
	double amount;
	Account toAccount;
	String description;
	
	
	public TransferCommand(long fromAccountNumber, long toAccountNumber, double amount, String description, IAccountDAO accountDao) {
		
		this.accountDao = accountDao;
		this.fromAccount= accountDao.loadAccount(fromAccountNumber);
		this.toAccount= accountDao.loadAccount(toAccountNumber);
		this.amount= amount;
		this.description=description;
		
	}
	@Override
	public void execute() {
		
		fromAccount.transferFunds(toAccount, amount, description);
		accountDao.updateAccount(fromAccount);
		accountDao.updateAccount(toAccount);
		
	}

	@Override
	public void undo() {
		toAccount.transferFunds(fromAccount, amount, description);
		accountDao.updateAccount(toAccount);
		accountDao.updateAccount(fromAccount);
		
	}

}
