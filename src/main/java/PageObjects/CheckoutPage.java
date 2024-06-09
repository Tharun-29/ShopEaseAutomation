package PageObjects;



import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutPage {
	WebDriver driver;
	Actions builder;
         
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		builder = new Actions(driver);
	}
	
	
	@FindBy(xpath = "//div[@data-test='inventory-item-name']")
	List<WebElement> CheckoutProducts;
	
	@FindBy(id = "checkout")
	WebElement checkoutButton;
	
	public void ValidateProducts(String prod) {
		for(int i=0;i<CheckoutProducts.size();i++) {
			if(CheckoutProducts.get(i).getText().contains(prod)) {
	    		Assert.assertTrue(true);
	    	}else {
	    		Assert.assertTrue(false);
	    	}
		}
	}
	
	
	public void CheckoutOrder() {
		builder.moveToElement(checkoutButton);
		builder.click();
		builder.perform();
	}
	
	
	
}
