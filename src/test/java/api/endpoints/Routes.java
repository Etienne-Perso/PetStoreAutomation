package api.endpoints;

/*
Swagger URI --> https://petstore.swagger.io

Create user (Post)  : https://petstore.swagger.io/v2/user
Get user    (Get)   : https://petstore.swagger.io/v2/user/{username}
Update user (Put)   : https://petstore.swagger.io/v2/user/{username}
Delete user (Delete): https://petstore.swagger.io/v2/user/{username}

Framework development :
-----------------------

Pre-requisists:
---------------
Step 1: Create Maven Project
Step 2: Update pom.xml with required dependencies
Step 3: Create Folder structure
---------------
Step 4: Create Routes.java        ---->contains URL'S
Step 5: Create UserEndPoints.java ---->CRUD methods implementation
Step 6: Create Test cases
Step 7: Create Data driven test
		Excel sheet data 
		ExcelUtility
		DataProviders

Step 8: Generate extent reports
		Extent reportUtility
		testng.xml file 

Step 9: Add logs
		log4j2 dependency
		log4j2.xml --->src/test/ressources





*/

public class Routes {
	
	public static String base_url= "https://petstore.swagger.io/v2";
	
	//User module: 
	public static String create_url= base_url+"/user"; 
	
	public static String get_Url= base_url+"/user/{username}";
	
	public static String update_url= base_url+"/user/{username}";
	
	public static String delete_url= base_url+"/user/{username}";
	
	//Store module: 
		//create Store module URL'S
	
	
	//Pet module 
		//create Pet module URL'S
}
