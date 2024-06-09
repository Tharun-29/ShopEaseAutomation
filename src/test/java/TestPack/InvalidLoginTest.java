package TestPack;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponents.BaseTest;

public class InvalidLoginTest extends BaseTest {

	@Test
	public void testInvalidLogin() {

		// Read invalid credentials from properties file
		String invalidUsername = configReader.getProperty("invalidUsername");
		String invalidPassword = configReader.getProperty("invalidPassword");

		// Perform login with invalid credentials
		LogPage.OpenLoginPage(configReader.getProperty("baseURL"));
		LogPage.LoginToApplication(invalidUsername, invalidPassword);

		// Verify that an appropriate error message is displayed
		String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
		String actualErrorMessage = LogPage.getErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message does not match!");
	}

}
