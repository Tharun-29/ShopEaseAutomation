package TestPack;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponents.BaseTest;

public class InvalidLoginTest extends BaseTest {

    // Test method to validate invalid login scenario
    @Test
    public void testInvalidLogin() {
        
        // Read invalid credentials from properties file
        String invalidUsername = configReader.getProperty("invalidUsername");
        String invalidPassword = configReader.getProperty("invalidPassword");

        // Step 1: Open the login page of the application
        LogPage.OpenLoginPage(configReader.getProperty("baseURL"));

        // Step 2: Attempt login with invalid credentials
        LogPage.LoginToApplication(invalidUsername, invalidPassword);

        // Step 3: Verify that an appropriate error message is displayed
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = LogPage.getErrorMessage(); // Fetch the error message displayed
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message does not match!"); // Assert that the error message matches the expected message
    }
}