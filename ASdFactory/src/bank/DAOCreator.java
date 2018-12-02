package bank;

import java.util.ArrayList;
import java.util.List;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;

public class DAOCreator {
	
	public static IAccountDAO accountDao()
	{
		return new AccountDAO();
	}
	

}
