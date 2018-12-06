package com.techm.ms.service;


import java.util.List;

import com.techm.ms.model.Account;

public interface AccountService {
	
	Account findById(long id);
	
	Account findByName(String name);
	
	void saveAccount(Account account);
	
	List<Account> findAllAccounts();
	
	boolean isAccountExist(Account account);
	
}
