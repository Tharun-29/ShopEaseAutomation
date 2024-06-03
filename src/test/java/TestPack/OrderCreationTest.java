package TestPack;

import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.ProductPage;
import TestComponents.BaseTest;

public class OrderCreationTest extends BaseTest {
  
	@Test
	public void createOrder() {
	   LogPage.openLoginPage();
	   LogPage.LoginToApplication();
	   
	   ProductPage pg = new ProductPage(driver);
	   pg.addProducts();
	   pg.checkoutProduct();
	   
	   
	}
	
	
}
