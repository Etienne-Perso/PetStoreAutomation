package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/*
Created to perform Create, Read, Update, Delete requests in the user API 

CRUD concept


*/
public class UserEndPoints {
	
	
	public static Response createUser(User payload) {
		
		Response response=given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(payload)
		
							.when()
								.post(Routes.create_url);
		return response;
	}
	
	
	public static Response getUser(String userName) {
		
		Response response=given()
								.pathParam("username", userName)
		
							.when()
								.get(Routes.get_Url); 
		
		return response;
	}
	
	
	public static Response updateUser(String userName, User payload){
		
		Response response=given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.pathParam("username", userName)
								.body(payload)

							.when()
								.put(Routes.update_url);
		return response;

	}
	
	
	public static Response deleteUser(String userName) {
		
		Response response=given()
								.pathParam("username", userName)
		
							.when()
								.delete(Routes.delete_url);
		
		return response;
	
	}

}
