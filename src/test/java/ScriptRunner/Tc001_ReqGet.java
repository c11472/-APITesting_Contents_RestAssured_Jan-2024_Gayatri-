package ScriptRunner;

import java.io.FileReader;
import java.util.Properties;
import java.util.Scanner;

import LibPak.LibTest;

public class Tc001_ReqGet {
	// create the object for the lib class

	static LibTest obj1;

	public static void main(String[] args) throws Exception {
		Scanner c = new Scanner(System.in);
		// TODO Auto-generated method stub
		obj1 = new LibTest();
		// Set the properties to validate the method name
		FileReader f1 = new FileReader("./ConfigData/config1.properties");
		Properties p1 = new Properties();
		p1.load(f1);

		String actmethod, expmethod;
		System.out.println("Enter the method name to be performed in api :");
		expmethod = c.nextLine(); // input
		actmethod = p1.getProperty("Method1");

		// validate the method name

		if (actmethod.equals(expmethod)) {
			String responsebodytest = obj1.testGetRequest001();
			System.out.println(responsebodytest);
		} else {
			// System.out.println("Invalid method to perform the operration :");
			obj1.postRequest_002();
		}

		// obj1.postRequest_002();

	}

}
