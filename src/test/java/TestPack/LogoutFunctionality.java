package TestPack;

import org.testng.annotations.Test;

import TestComponents.BaseTest;

public class LogoutFunctionality extends BaseTest{
     
	@Test
	public void LogoutTest() {
		LogPage.OpenLoginPage(configReader.getProperty("baseURL"));
		LogPage.LoginToApplication(configReader.getProperty("username"),configReader.getProperty("password"));
		
		//Accessing LogoutFromApplication Method to perform Logout actions
		LogPage.LogoutFromApplication();
	}
	
	
}
