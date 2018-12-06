package com.techm.ms.resource;

import java.util.List;

import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.techm.ms.model.Account;
import com.techm.ms.model.representation.Resource;
import com.techm.ms.model.representation.ResourceCollection;
import com.techm.ms.service.AccountService;

/**
 * This is the Controller class for Account mService
 */
@Controller
public class AccountResourceImpl implements AccountResource {
	
	public static final Logger logger = LoggerFactory.getLogger(AccountResourceImpl.class);

	@Autowired
	AccountService accountService; //Service which will do all data retrieval/manipulation work

	private static String baseUrl = "/accounts";

	@Override
	public Response findAllAccounts() {
		logger.info("Received request in findAllAccounts");
		List<Account> accounts = accountService.findAllAccounts();		
		if (accounts == null) {
			return Response.noContent().build();
		}		
		Link link = Link.fromUri(baseUrl).rel("self").build();		
		ResourceCollection<Account> resource = new ResourceCollection<>(accounts);
		return Response.ok(resource).links(link).build();
	}

	@Override
	public Response findAccountByName(String username) {
		logger.info("Received request in findAccountByName");
		Account account = accountService.findByName(username);
		System.out.println("user name:::"+username);
		if (account == null) {
			return Response.noContent().build();
		}		
		Link link = Link.fromUri(baseUrl).rel("self").build();		
		Resource<Account> resource = new Resource<>(account);
		return Response.ok(resource).links(link).build();
	}	

}