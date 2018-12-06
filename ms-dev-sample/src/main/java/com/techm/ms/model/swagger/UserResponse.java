package com.techm.ms.model.swagger;

import com.techm.ms.model.Account;
import com.techm.ms.model.User;
import com.techm.ms.model.representation.Resource;
/**
 * Swagger response class for the Account model object.
 * @param <T>
 * @param <T>
 */
public class UserResponse  extends Resource<User>{
		
	    /**
	     * This constructor sets the content of the User Response 
	     * @param content Command line parameters if any
	     * 
	     */
		public UserResponse(User content) {
			super(content);
		}

	    /**
	     * This method gets the content of the User Response 
	     * @return content of the user Response
	     * 
	     */
		@Override
		public User getContent() {
			return super.getContent();
		}

}