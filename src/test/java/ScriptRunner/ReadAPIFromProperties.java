package ScriptRunner;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReadAPIFromProperties {
	public static void main(String args[]) throws IOException {
		Properties properties = new Properties();
		FileInputStream input = new FileInputStream("./ConfigData/config2.properties");
		properties.load(input);

		// Set base URI
		RestAssured.baseURI = properties.getProperty("api.baseurl");

		// Set endpoint
		String endpoint = properties.getProperty("api.endpoint");
		Response response = RestAssured.get(endpoint);

		String resultBody = response.getBody().asString();

		System.out.println(resultBody);

	}

}
