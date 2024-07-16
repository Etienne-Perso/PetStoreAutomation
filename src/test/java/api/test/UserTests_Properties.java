package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints_Properties;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests_Properties {
	
	Faker f; 
	User userPayload;
	public Logger logger;  //for logs
	
	@BeforeClass
	void setup(){
		
		//Data payload
		f=new Faker(); 
		userPayload=new User();
		
		userPayload.setId(f.idNumber().hashCode());
		userPayload.setUsername(f.name().username());
		userPayload.setFirstName(f.name().firstName());
		userPayload.setLastName(f.name().lastName());
		userPayload.setEmail(f.internet().emailAddress());
		userPayload.setPassword(f.internet().password(5, 10));
		userPayload.setPhone(f.phoneNumber().cellPhone());
		
		//logs: 
		logger=LogManager.getLogger(this.getClass()); 
	}
	
	
	@Test(priority=1)
	public void test_createUser(){
		
		
		logger.info("******Creating User********");
		Response response=UserEndPoints_Properties.createUser(userPayload); 
		response.then().log().all(); 
		
		Assert.assertEquals(response.getStatusCode(), 200);	
		logger.info("******User is created********");
	}
	
	@Test(priority=2)
	public void test_getUserByName() {
		
		logger.info("******Getting User info********");
		Response response=UserEndPoints_Properties.getUser(userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("******User info are displayed********");
	}
	
	@Test(priority=3)
	public void test_updateUserByName() {
		
		logger.info("******Updating User info********");
		
		//Updating payload data
		userPayload.setFirstName(f.name().firstName());
		userPayload.setLastName(f.name().lastName());
		userPayload.setEmail(f.internet().emailAddress());
		
		Response response=UserEndPoints_Properties.updateUser(userPayload.getUsername(), userPayload);
		response.then().log().body(); 
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("******User info are updated********");
		
		//Checking the response after update: 
		Response responseAfterUpdate=UserEndPoints_Properties.getUser(userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
	}
	
	@Test(priority=4)
	public void test_deleteUserByName() {
		
		logger.info("******Deleting User********");
		
		Response response=UserEndPoints_Properties.deleteUser(userPayload.getUsername()); 
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("******User is deleted********");
		
		//Checking the response after delete: 
		Response responseAfterDeleteUser=UserEndPoints.getUser(userPayload.getUsername());
		Assert.assertEquals(responseAfterDeleteUser.getStatusCode(), 404);	
		
		
	}
}
