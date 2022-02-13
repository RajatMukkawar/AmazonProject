package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MainPageHeader {
	WebDriver driver123;
	Actions act;
	
	@FindBy (xpath ="//select[@title='Search in']") 
	private WebElement searchdropdown;
	
	@FindBy (xpath ="//input[@type='text']") 
	private WebElement searchbox;
	
	@FindBy (xpath ="//input[@type='text']") 
	private WebElement searchbox1;
	
	@FindBy (xpath ="//input[@type='submit']") 
	private WebElement search;
	
	/*
	 * @FindBy (xpath ="//a[text()='Coupons']") private WebElement coupon;
	 */
	
	@FindBy (xpath ="//span[contains(@id,'nav-link-account')]") 
	private WebElement logoutPage1;
	
	@FindBy (xpath ="//span[text()='Sign Out']") 
	private WebElement logoutPage2;
	
	 public MainPageHeader(WebDriver driver)
		{
		PageFactory.initElements(driver, this);
		driver123=driver;
		act=new Actions(driver123);
		}

	    public void selectDropDown()   
	    {
		 Select set=new Select(searchdropdown);
		 set.selectByVisibleText("Electronics");
	      
	    }
	    
	    public void sendKeySearchBox(String iphone)    
	    {
	    	searchbox.sendKeys(iphone);
	    }
	    public void sendKeySearchBox1()    
	    {
	    	searchbox.clear();
	    }
	    
	    public void clickSearchBox()    
	    {
	    	search.click();
	    }
		/*
		 * public void clickCoupon() { coupon.click(); }
		 */
	  
	    public void clickLogout()    
	    {
	    	act.moveToElement(logoutPage1).perform();
	    }
	    public void clickLogout2()    
	    {
	    	act.moveToElement(logoutPage2).click().build().perform();
	    }

}
