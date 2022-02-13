package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	private WebDriver driver123;
	private Actions action;
	
	
	@FindBy (xpath ="(//a[@data-ux-jq-mouseenter='true'])[1]") 
	private WebElement helloSignIn;
	
	@FindBy (xpath ="//span[text()='Sign in']") 
	private WebElement signIn;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		driver123=driver;
		action=new Actions(driver123);
		  
	}
	
	public void moveHelloSignIn()  
	{
		
		action.moveToElement(helloSignIn).perform();
	}
	public void clickSignIn()  
	{
		action.moveToElement(signIn).click().build().perform();
	}
	
	
	
	

}
