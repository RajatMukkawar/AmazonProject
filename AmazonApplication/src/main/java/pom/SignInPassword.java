package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPassword {
	@FindBy (xpath ="//input[@type='password']") 
	private WebElement password;
	
	@FindBy (xpath ="//input[@id='signInSubmit']") 
	private WebElement button1;
	
	@FindBy (xpath ="//input[@type='checkbox']") 
	private WebElement checkbox;

    public SignInPassword(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}

    public void sendKeysPassword(String passwordd)  
    {
	 password.sendKeys(passwordd);
    }
    public void clickButton()  
    {
    	button1.click();
    }
    public void clickCheckBox()  
    {
    	checkbox.click();
    }


}
