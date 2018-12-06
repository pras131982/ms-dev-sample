package com.techm.ms.model.swagger;

import com.techm.ms.model.Account;
import com.techm.ms.model.representation.Resource;

/**
 * Swagger response class for the Account model object.
 * @param <T>
 * @param <T>
 */
public class AccountResponse extends Resource<Account> {
	
    /**
     * This constructor sets the content of the Account Response 
     * @param content Command line parameters if any
     * 
     */
	public AccountResponse(Account content) {
		super(content);
	}

    /**
     * This method gets the content of the Account Response 
     * @return content of the user Response
     * 
     */
	@Override
	public Account getContent() {
		return super.getContent();
	}

}