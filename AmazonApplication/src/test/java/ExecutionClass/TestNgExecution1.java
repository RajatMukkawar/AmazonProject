package ExecutionClass;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.PojoBrowser;
import Utilities.utility;
import pom.HomePage;
import pom.MainPageHeader;
import pom.SignInMail;
import pom.SignInPassword;

public class TestNgExecution1 extends PojoBrowser{
	private WebDriver driver;
	private MainPageHeader mainpageheader;
	private HomePage homepage;
	private SignInMail signinmail;
	private int Testid;
	private SignInPassword signinpassword;
	static  ExtentHtmlReporter reporter;
	static ExtentTest test;

	@BeforeTest
	@Parameters("Browsers1")
	public void ToLaunchAmazon(String browser) 
	{
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);

    	if (browser.equalsIgnoreCase("Chrome"))
		{	
    		 driver=chromeBrowser();
		}
		if (browser.equalsIgnoreCase("edge"))
		{
			 driver=edgeBrowser();
		}
		     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@BeforeClass
	public void allPomObjects() 
	{
		//System.out.println("Before Class1");
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "D:\\software\\Selenium File\\Chrome file\\chromedriver_win32\\chromedriver.exe"
		 * ); WebDriver driver=new ChromeDriver();
		 */
		/*
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 */
		      homepage = new HomePage(driver);
		      signinmail = new SignInMail(driver);
		      mainpageheader = new MainPageHeader(driver);
		      signinpassword = new SignInPassword(driver);
	}

	@BeforeMethod
	public void LoginAmazon() throws EncryptedDocumentException, IOException 
	{
		      System.out.println("BeforeMethod");
		      driver.get("https://www.amazon.in/ref=ap_frn_logo");
		
		      homepage.moveHelloSignIn();
		      homepage.clickSignIn();
		      String username=utility.getDataFromExcelSheet("Rajat", 1, 0);
		      signinmail.sendKeysMail(username);
		      signinmail.clickButton();
		      utility.getScreenshot(driver, Testid);
		/*
		 * if(signinmail.IsUsernameWrong()) { utility.getScreenshot(driver, Testid);
		 * Assert.fail(); }
		 */
		
		      String pass=utility.getDataFromExcelSheet("Rajat", 1, 1);
		      signinpassword.sendKeysPassword(pass); signinpassword.clickCheckBox();
		      signinpassword.clickButton();
		/*
		 * String pass=utility.getDataFromExcelSheet("Rajat", 1, 1);
		 * signinpassword.sendKeysPassword(pass); signinpassword.clickCheckBox();
		 * signinpassword.clickButton();
		 */

	}

	@Test
	public void headerPageAmazon() 
	{
		     Testid=202;
		     System.out.println("test1 ");
		     mainpageheader.selectDropDown();
		     String str = driver.getCurrentUrl();
		     System.out.println(str);
		     String title = driver.getTitle();
		     System.out.println(title);

		if (str.equals("https://www.amazon.in/ref=nav_signin?"))
		{
			System.out.println("Testcase pass");
		} 
		  else 
		  {
			  System.out.println("testcase Failed");
	   	  }
		if (title.equals(
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")) 
		{
			System.out.println("Test case pass");

		} else
		  {
			System.out.println("Test case failed");
		  }
		// mainpageheader.sendKeySearchBox("iphone13");
		/*
		 * mainpageheader.clickLogout(); mainpageheader.clickLogout2();
		 */
		//Assert.fail();
	}
	/*
	 * @Test public void coupon() { System.out.println("test1 "); mainpageheader=new
	 * MainPageHeader(driver); mainpageheader.clickCoupon(); }
	 */ // repeat hot aahe

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE==result.getStatus())
		{
			utility.getScreenshot(driver, Testid);
		}
		    System.out.println("afterMethod");
		    mainpageheader.clickLogout();
		    mainpageheader.clickLogout2();
	}

	@AfterClass
	public void clearPomObjects() 
	    {
		
		    homepage = null;
		    signinmail =null;
		    mainpageheader = null;
		
	    }
	@AfterTest
	public void afterTest() {
		    System.out.println("afterClass");
		    driver.quit();
		    driver=null;
		    System.gc();//To erase all objects
	}

}
