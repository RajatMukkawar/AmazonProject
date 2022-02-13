package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoToCart {
	WebDriver driver;
	Actions act;
	
	@FindBy (xpath ="//span[text()='74,900']") 
	private WebElement gocart;
	

	@FindBy (xpath ="//span[contains(@id,'nav-link-account')]") 
	private WebElement logoutPage3;
	
	@FindBy (xpath ="//span[text()='Sign Out']") 
	private WebElement logoutPage4;
	
	public GoToCart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		act=new Actions(driver);
	}
	
	public void clikcart()  
	{
		gocart.click();
	}
	 public void clickLogout()    
	    {
	    	act.moveToElement(logoutPage3).perform();
	    }
	    public void clickLogout2()    
	    {
	    	act.moveToElement(logoutPage4).click().build().perform();
	    }
	
	
	

}
