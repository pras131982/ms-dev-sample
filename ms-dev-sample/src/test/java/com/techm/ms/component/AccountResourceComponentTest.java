package com.techm.ms.component;

import java.net.InetAddress;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountResourceComponentTest {
	
	@LocalServerPort
	protected int randomServerPort;
	
	private String uri ="/accounts/allAccounts";
	
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
	public void testfindAllAccount_success() {
		givenBaseSpec()
				.when()
				.get(uri)
				.then()
				.statusCode(200);
		Response response = givenBaseSpec().when().get(uri);
		System.out.println("response::"+response.getBody().asString());
		System.out.println("status code::"+response.getStatusCode());
		
	}
}
