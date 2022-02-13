package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {
	
	@FindBy (xpath ="(//input[@value='Delete'])[1]") 
	private WebElement delete;
	
	public ShoppingCart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickDelete()  //mouse action
	{
		delete.click();
	}

}
