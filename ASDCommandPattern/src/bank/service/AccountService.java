package bank.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import bank.command.Command;
import bank.command.DepositCommand;
import bank.command.TransferCommand;
import bank.command.WithDrawCommand;
import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;
import bank.domain.InterestStrategyHigh;
import bank.domain.InterestStrategyLow;


public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;
	
	public IAccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(IAccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public List<Command> getCommands() {
		return commands;
	}

	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}

	List<Command> commands= new ArrayList<>();

	
	public AccountService(){
		accountDAO=new AccountDAO();
	}

	public Account createAccount(String type, long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		if (type.equals("checking")){		   
		   account.setInterestStrategy(new InterestStrategyLow());
		}
		else {
		   account.setInterestStrategy(new InterestStrategyHigh());
		}
		account.setType(type);
		
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.saveAccount(account);
		return account;
	}

	public void deposit(long accountNumber, double amount) {
//		Account account = accountDAO.loadAccount(accountNumber);
//		account.deposit(amount);
//		accountDAO.updateAccount(account);
		Command depositCommand= new DepositCommand(accountNumber, amount,accountDAO);
		depositCommand.execute();
		commands.add(depositCommand);
	}

	public Account getAccount(long accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(long accountNumber, double amount) {
		Command withdraw= new WithDrawCommand(accountNumber, amount,accountDAO);
		withdraw.execute();
		commands.add(withdraw);
	}



	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		
		Command transfer= new TransferCommand(fromAccountNumber, toAccountNumber, amount, description,accountDAO);
		transfer.execute();
		commands.add(transfer);
		
	}
	
	public void addinterest(){
		Collection<Account> accounts = getAllAccounts();
		for (Account account: accounts){
			account.addInterest();
		}
	}

	@Override
	public void undo() {
		Command latestCommand=commands.get(commands.size()-1);
		latestCommand.undo();
		
		
	}

	@Override
	public void redo() {
		
		Command latestCommand=commands.get(commands.size()-1);
		latestCommand.execute();
	}
}
