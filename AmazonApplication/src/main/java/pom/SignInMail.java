package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInMail {
    	@FindBy (xpath ="//input[@type='email']") 
    	private WebElement email;
    	
    	@FindBy (xpath ="//input[@id='continue']") 
    	private WebElement button;
    	
    	@FindBy (xpath ="//h4[text()='There was a problem']") 
    	private WebElement wrongEmail;
	
	    public SignInMail(WebDriver driver)
		{
		PageFactory.initElements(driver, this);
    	}
	
	    public void sendKeysMail(String mail)  // mouse action
	    {
		email.sendKeys(mail);
	    }
	    public void clickButton()  // mouse action
	    {
	    	button.click();
	    }
	    public boolean IsUsernameWrong()  
	    {
	    	if(wrongEmail.isDisplayed())
	    	{
	    		return true;
	    	}
	    	return false;
	    }
 
}
