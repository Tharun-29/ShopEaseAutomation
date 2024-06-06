package TestPack;

import org.testng.annotations.Test;

import TestComponents.BaseTest;

public class LogoutFunctionality extends BaseTest{
     
	@Test
	public void LogoutTest() {
		LogPage.OpenLoginPage();
		LogPage.LoginToApplication();
		
		//Accessing LogoutFromApplication Method to perform Logout actions
		LogPage.LogoutFromApplication();
	}
	
	
}
