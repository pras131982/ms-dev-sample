package com.techm.ms.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.techm.ms.model.User;
import com.techm.ms.model.swagger.AccountResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This is the Interface definition for User Resource
 * 
 */
@Api("user")
@Path("/users")
@Produces({MediaType.APPLICATION_JSON})
public interface UserResource {

    /**
     * Service definition which returns all the users
     * @return User - Returns the details of the users being searched
     */
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value = "Get User Resource",
			notes = "Returns all the users in ResourceCollection representation format",
			response = UserResource.class)
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = "OK"),
					@ApiResponse(code = 204, message = "No Content")					
					})
	public Response findAllUsers();

	
	 /**
     * Service definition which creates a user
     * @return User - Returns 201 if success
     */
	@PUT
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/create")
	@ApiOperation(
			value = "Create User Resource",
			notes = "Creates user",
			response = UserResource.class)
	@ApiResponses(
			value = {
					@ApiResponse(code = 201, message = "OK"),
					@ApiResponse(code = 409, message = "Unable to create. A user with name already exists")					
					})
	public Status CreateUser(User user);
	//public Response CreateUser(User user);
	
	 /**
     * Service definition which returns all the users
     * @return User - Returns the details of the users being searched
     */
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/getuser/{userid}")
	@ApiOperation(
			value = "Get User Resource",
			notes = "Returns the user in ResourceCollection representation format",
			response = UserResource.class)
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = "OK"),
					@ApiResponse(code = 204, message = "No Content")					
					})
	public Response GetUser(@ApiParam(value = "Id that need to be searched", required = true) @PathParam("userid") long userid);


	
}