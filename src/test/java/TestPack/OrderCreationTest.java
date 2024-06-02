package TestPack;

import org.testng.annotations.Test;

import PageObjects.LoginPage;
import TestComponents.BaseTest;

public class OrderCreationTest extends BaseTest {
  
	@Test
	public void createOrder() {
	   LoginPage logPage = new LoginPage(driver);
	   logPage.openLoginPage();
	   
	}
	
	
}
