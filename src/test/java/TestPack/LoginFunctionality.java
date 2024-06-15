package TestPack;

import org.testng.annotations.Test;

import PageObjects.LoginPage;
import TestComponents.BaseTest;
import config.ConfigReader;

public class LoginFunctionality extends BaseTest {
      
    // Test method to validate login functionality
    @Test
    public void LoginTest() {
        // Step 1: Open the login page of the application
        LogPage.OpenLoginPage(configReader.getProperty("baseURL"));
        
        // Step 2: Perform login using valid credentials
        LogPage.LoginToApplication(configReader.getProperty("username"), configReader.getProperty("password"));
    }
}