package TestPack;

import org.testng.annotations.Test;

import PageObjects.LoginPage;
import TestComponents.BaseTest;

public class LoginFunctionality extends BaseTest {
      
	@Test
	public void LoginTest() {
		LogPage.openLoginPage();
		LogPage.LoginToApplication();
	}
}
