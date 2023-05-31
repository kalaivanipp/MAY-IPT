package com.RestAssuredAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



public class RestExample {
	
	
	@Test
	private void postRequest() {
		
		JSONObject request=new JSONObject();
		
		request.put("name", "kalaivani");
		request.put("job", "testor");
		

		baseURI="https://reqres.in/api";
		
		
		given().body(request.toJSONString())
		.when().post("/users")
		.then().statusCode(201)
		.log().all();
	}

}
