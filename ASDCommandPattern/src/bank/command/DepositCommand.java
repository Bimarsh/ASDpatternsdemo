package bank.command;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;

public class DepositCommand implements Command {

	long accountNumber;
	IAccountDAO accountDao;
	Account account;
	double amount;
	public DepositCommand(long accountNumber, double amount,IAccountDAO accountDao) {
		this.accountNumber = accountNumber;
		this.accountDao=accountDao;
		this.account= accountDao.loadAccount(accountNumber);
		this.amount= amount;
	}

	@Override
	public void execute() {
		
		account.deposit(amount);
		accountDao.updateAccount(account);

	}

	@Override
	public void undo() {
		account.withdraw(amount);
		accountDao.updateAccount(account);
		
		// TODO Auto-generated method stub

	}

}
