package PageObjects;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {

	WebDriver driver;
	Actions builder;

	public OverviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		builder = new Actions(driver);
	}

	@FindBy(xpath = "//div[@data-test='inventory-item-name']")
	List<WebElement> confirmedProducts;

	@FindBy(id = "finish")
	WebElement finishButton;

	public void ValidateOveriewPage(String prod) {
		for (int i = 0; i < confirmedProducts.size(); i++) {
			if (confirmedProducts.get(i).getText().contains(prod)) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
		builder.moveToElement(finishButton);
		builder.click().perform();
	}

}
