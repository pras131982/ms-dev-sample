package com.techm.ms.component;

import static org.junit.Assert.*;

import java.net.InetAddress;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.techm.ms.model.User;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserResourceComponentTest {

	@LocalServerPort
	protected int randomServerPort;
	
	private String uri ="/users";
	
	@Before
	public void setUp() throws Exception {
		RestAssured.baseURI = "http://" + InetAddress.getLocalHost().getHostName() + ":" + randomServerPort + "/api";
	}
	
	private  RequestSpecification givenBaseSpec() {
		return RestAssured.given()
						  .accept(ContentType.JSON)
						  .contentType(ContentType.JSON);
	}
	
	@Test
	public void testFindAllUser_success() {
		givenBaseSpec()
				.when()
				.get(uri)
				.then()
				.statusCode(200);
	}
	
	@Test
	public void testCreateUser_success() {
		User user = new User();
		user.setName("pras");
		user.setId(12);
		user.setAccountId(12);
		user.setAge(12);
		givenBaseSpec()
				.when()
				.body(user)
				.put(uri+"/create")
				.then()
				.statusCode(200);
	}
	@Test
	public void testGetUser_success() {
		givenBaseSpec()
				.when()
				.get(uri+"/getuser/3")
				.then()
				.statusCode(200);
	}
}
