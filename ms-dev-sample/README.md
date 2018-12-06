# ms-dev-sample

Sample Spring Boot Application for Micro Services Developer evaluation

## Pre Requisites (Provided by Tech Mahindra)
* **Download the JDK 1.8** 
	* [Windows - 64 Bit](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
	
* **Download the Eclipse Oxygen Release 3**
	* [Windows - 64 Bit](http://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/oxygen/3/eclipse-jee-oxygen-3-win32-x86_64.zip)

* **Download and Install Spring Tools Suite from Market Place (Optional)**
	* [Market Place](https://marketplace.eclipse.org/content/spring-tools-aka-spring-ide-and-spring-tool-suite)
	
* **Clone the GitHub Project**
	* [GitHub Project](https://github.com/JayaprakashRavindran/ms-dev-sample)

## Developer Tasks

### Setup the Local Workspace Environment
	* Install JDK 1.8
	* Install Eclipse Oxygen
	* Configure Eclipse with JDK 1.8
	* Create a Fork and Checkout the [GitHub Code](https://github.com/JayaprakashRavindran/ms-dev-sample)
	* Start the Spring Boot Application and ensure that it comes up successfully 
		* Sample Url  - /api/accounts url
		* Swagger Url - /index.html
	* Once the development is complete, please check the code back into the fork and submit a pull request for the merge
	
### Microservice Development Tasks
	* Create a User	Resource Interface and provide the UserResourceImpl for the following functionality
		* CreateUser
			* Create a new user and returns 201 if success
			* If User with that name already exists then return Http error code 409(CONFLICTED) with a custom message "Unable to create. A Account with name already exist"
		* GetUser
			* Returns the User object for a given userId with status as success
			* If User does not exist then return 404 with custom error with message and error code e.g. {"errorMessage": "Account with id 123 not found", "errorCode": "NOT_FOUND" }
	* Check List
		* Create necessary Interface, Implementation & Helper classes to attain the functionality
		* Java Doc
		* JUnit Test
		* Swagger Documentation
		* Run the following using Maven
			* Execute all the JUnit Test Cases
			* Create the Spring Boot Fat Jar
		* Start the Spring Boot Fat Jar command line
		* Test the new end poitns developed successfully using any Rest Client (Postman, Curl, Browser etc.,)
		
## Additional Information
	* User any simple in memory java Collection for storage and retrieval (No need for database implementation)
	* Utilize appropriate HTTP Methods and HTTP Codes
	* Handle and Implement negative scenarios
	* Create JUnit test cases for all the possible conditions (Complete test case coverage) – One Java Service Class is enough
