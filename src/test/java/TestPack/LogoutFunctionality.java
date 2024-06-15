package TestPack;

import org.testng.annotations.Test;

import TestComponents.BaseTest;

public class LogoutFunctionality extends BaseTest {
     
    // Test method to validate logout functionality
    @Test
    public void LogoutTest() {
        // Step 1: Open the login page of the application
        LogPage.OpenLoginPage(configReader.getProperty("baseURL"));
        
        // Step 2: Perform login using valid credentials
        LogPage.LoginToApplication(configReader.getProperty("username"), configReader.getProperty("password"));
        
        // Step 3: Perform logout using the LogoutFromApplication method
        LogPage.LogoutFromApplication();
    }
}