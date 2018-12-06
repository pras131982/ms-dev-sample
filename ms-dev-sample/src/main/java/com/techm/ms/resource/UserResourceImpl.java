package com.techm.ms.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.techm.ms.model.User;
import com.techm.ms.model.representation.ResourceCollection;
import com.techm.ms.service.UserService;

@Controller
public class UserResourceImpl implements UserResource {
	public static final Logger logger = LoggerFactory.getLogger(UserResourceImpl.class);

	@Autowired
	UserService userService; //Service which will do all data retrieval/manipulation work

	private static String baseUrl = "/users";

	@Override
	public Response findAllUsers() {
		logger.info("Received request in findAllUsers");
		List<User> users = userService.findAllUsers();		
		if (users == null) {
			return Response.noContent().build();
		}		
		Link link = Link.fromUri(baseUrl).rel("self").build();		
		ResourceCollection<User> resource = new ResourceCollection<>(users);
		return Response.ok(resource).links(link).build();
	}	

	@Override
	@RequestMapping(path="/create",method = RequestMethod.PUT)
	public Status CreateUser(@PathVariable User user) {
		logger.info("Received request in CreateUser");
		User newUser=null;
		if(user != null && userService.isUserExist(user)) {
			return Response.Status.CONFLICT;
		}
		if (userService.findById(user.getId()) == null || user.getId()<=0) {
			
			newUser=userService.createUser(user);
		}
		return Response.Status.OK;	
	
		
	}	

	
	@Override
	public Response GetUser(long userId) {
		logger.info("Received request in GetUser::"+userId);
		User user = userService.findById(userId);
		List<User> users = new ArrayList<User>();
		users.add(user);
		if (user == null) {
			return Response.noContent().build();
		}		
		Link link = Link.fromUri(baseUrl).rel("self").build();		
		ResourceCollection<User> resource = new ResourceCollection<>(users);
		return Response.ok(resource).links(link).build();
	}	

}
