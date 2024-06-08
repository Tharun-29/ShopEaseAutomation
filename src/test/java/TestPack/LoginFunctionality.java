package TestPack;

import org.testng.annotations.Test;

import PageObjects.LoginPage;
import TestComponents.BaseTest;
import config.ConfigReader;

public class LoginFunctionality extends BaseTest {
      
	@Test
	public void LoginTest() {
		LogPage.OpenLoginPage(configReader.getProperty("baseURL"));
		LogPage.LoginToApplication(configReader.getProperty("username"),configReader.getProperty("password"));
	}
}
