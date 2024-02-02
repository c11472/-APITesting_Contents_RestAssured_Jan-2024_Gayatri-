package LibPak;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LibTest {

	public String testGetRequest001() throws IOException {

		/*
		 * fr = new FileReader("./ConfigData/config1.properties");
		 * 
		 * pr.load(fr);
		 */
		/*
		 * RestAssured.baseURI = "https://reqres.in/"; // hardcoded
		 * 
		 * // Send a GET request to the endpoint
		 * 
		 * Response response = RestAssured.get("/api/user/2"); // hardcoded
		 * 
		 * String BodyDoc = response.getBody().asString();
		 * 
		 * System.out.println(BodyDoc);
		 */

		Properties properties = new Properties();
		FileInputStream input = new FileInputStream("./ConfigData/config2.properties");
		properties.load(input);

		// Set base URI
		RestAssured.baseURI = properties.getProperty("api.baseurl");

		// Set endpoint
		String endpoint = properties.getProperty("api.endpoint");
		Response response = RestAssured.get(endpoint);

		String resultBody = response.getBody().asString();

		return resultBody;

	}

	public void postRequest_002() throws IOException {
		// test the post api
		// body details

		Properties properties1 = new Properties();
		FileInputStream input1 = new FileInputStream("./ConfigData/configbody.properties");
		properties1.load(input1);

		RestAssured.baseURI = "https://reqres.in/";

		// String requestbody = "{\name\":\"morpheus\",\"job\":\"leader\"}";

		String requestbody1 = properties1.getProperty("rbody");

		Response response = RestAssured.given().contentType(ContentType.JSON).body(requestbody1).post("/api/users");

		System.out.println(response.getBody().asString());

	}

}
