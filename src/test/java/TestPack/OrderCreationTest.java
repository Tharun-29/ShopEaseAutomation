package TestPack;

import org.testng.annotations.Test;

import PageObjects.CheckoutPage;
import PageObjects.InformationPage;
import PageObjects.LoginPage;
import PageObjects.OrderConfirmationPage;
import PageObjects.OverviewPage;
import PageObjects.ProductPage;
import TestComponents.BaseTest;

public class OrderCreationTest extends BaseTest {
  
	@Test
	public void createOrder() {
		LogPage.OpenLoginPage(configReader.getProperty("baseURL"));
		LogPage.LoginToApplication(configReader.getProperty("username"),configReader.getProperty("password"));
	   
	   ProductPage pg = new ProductPage(driver);
	   pg.addProducts();
	   pg.checkoutProducts();
	   
	   CheckoutPage cp = new CheckoutPage(driver);
	   cp.ValidateProducts();
	   cp.CheckoutOrder();
	   
	   InformationPage ip = new InformationPage(driver);
	   ip.UserInformationSubmission("Jackie", "Chan", "China");
	   
	   
	   OverviewPage op = new OverviewPage(driver);
	   op.ValidateOveriewPage();
	   
	   OrderConfirmationPage ocp = new OrderConfirmationPage(driver);
	   ocp.ValidateOrderConfirmation();
	   
	}
	
	
}
