package ExecutionClass;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.PojoBrowser;
import pom.GoToCart;
import pom.HomePage;
import pom.IphonePage;
import pom.MainPageHeader;
import pom.SignInMail;
import pom.SignInPassword;

public class TestNgExecution2 extends PojoBrowser {
	private WebDriver driver;
	private GoToCart cart;
	private MainPageHeader mainpage;
	private HomePage homepage ;
	private  SignInMail signinmail;
	private  int Testid;
    @BeforeTest
    @Parameters("Browsers1")
    public void launchIphonemob(String browser1)
    {
    	if (browser1.equalsIgnoreCase("Chrome"))
		{	
    		driver=chromeBrowser();
		
		}
		if (browser1.equalsIgnoreCase("edge"))
		{
			driver=edgeBrowser();
			
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
	@BeforeClass
	public void SearchIphoneBox() {
		
	   mainpage = new MainPageHeader(driver);
	   cart = new GoToCart(driver);
	   homepage = new HomePage(driver);
	   signinmail = new SignInMail(driver);
	}

	@BeforeMethod
	public void mainPageHeader() {
		System.out.println("Before Method");
		System.out.println("BeforeMethod");
		driver.get("https://www.amazon.in/ref=ap_frn_logo");
		
		mainpage.selectDropDown();
		mainpage.sendKeySearchBox1();
		mainpage.sendKeySearchBox("iphone");
		mainpage.clickSearchBox();

	}

	@Test
	public void clickIphone() {
		Testid=203;
		
		  cart.clikcart();
		
		  ArrayList<String> list=new ArrayList<String>(driver.getWindowHandles());
		  driver.switchTo().window(list.get(1));
		  
		 
	}
	/*
	 * @Test public void clickIphone1() { cart = new GoToCart(driver);
	 * cart.clikcart();
	 * 
	 * ArrayList<String> list=new ArrayList<String>(driver.getWindowHandles());
	 * driver.switchTo().window(list.get(1)); }
	 */

	@AfterMethod
	public void afterMethod() {
		
		homepage.moveHelloSignIn();
		homepage.clickSignIn();
		
		signinmail.sendKeysMail("7972221015");
		signinmail.clickButton();
		SignInPassword signinpassword = new SignInPassword(driver);
		signinpassword.sendKeysPassword("Rajat@2321998");
		signinpassword.clickCheckBox();
		signinpassword.clickButton();
	}

	@AfterClass
	public void erasepomObject() {
		  mainpage = null;
		  cart = null;
		  homepage = null;
		  signinmail = null;
	}
	@AfterTest
	public void afterClass() {
		driver.quit();
		driver=null;
		System.gc();
	}
	

}
