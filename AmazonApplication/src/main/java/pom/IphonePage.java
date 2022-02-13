package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IphonePage {
	
	@FindBy (xpath ="//p[text()='128GB']") 
	private WebElement gb;
	
	@FindBy (xpath ="(//img[@class='imgSwatch'])[2]") 
	private WebElement color;
	
	@FindBy (xpath ="(//input[@type='submit'])[2]") 
	private WebElement addww;
	
	@FindBy (xpath ="(//input[@class='a-button-input'])[29]") 
	private WebElement skip;
	
	public IphonePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickGb()  //mouse action
	{
		gb.click();
	}
	public void clickColor()  //mouse action
	{
		color.click();
	}
	
	//(//input[@type='submit'])[2]
	/*
	 * public void clickaddCart() //mouse action { addcart.click(); } public void
	 * clickSkip() //mouse action { skip.click(); }
	 */
	

}
