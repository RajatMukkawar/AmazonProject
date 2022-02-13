package ExecutionClass;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.GoToCart;
import pom.HomePage;
import pom.IphonePage;
import pom.MainPageHeader;
import pom.ShoppingCart;
import pom.SignInMail;
import pom.SignInPassword;

public class TestAmazon {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\software\\Selenium File\\Chrome file\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   driver.get("https://www.amazon.in/ref=ap_frn_logo");
		   driver.manage().window().maximize();
		   HomePage page2=new HomePage(driver);
			page2.moveHelloSignIn();
			page2.clickSignIn();
			SignInMail mail=new SignInMail(driver);
			mail.sendKeysMail("7972221015");
			mail.clickButton();
		    SignInPassword pass=new SignInPassword(driver); 
		   pass.sendKeysPassword("Rajat@2321998");
		   pass.clickCheckBox();
		   pass.clickButton();
	      // pass.clickCheckBox();
	     	MainPageHeader mainpage=new MainPageHeader(driver);
	     	mainpage.selectDropDown();
			Thread.sleep(5000);
			 // mainpage.clickLogout(); 
			 // Thread.sleep(5000);
			 // mainpage.clickLogout2();
			 
	     	mainpage.sendKeySearchBox("iphone13");
	     	
	     	//mainpage.clickLogout2();
	     	
	     	mainpage.clickSearchBox();
	     	 GoToCart cart=new GoToCart(driver);
	     	 cart.clikcart();
	     	 ArrayList<String> array=new ArrayList<String>(driver.getWindowHandles());
	     	driver.switchTo().window(array.get(1));
	     	IphonePage iphone=new IphonePage(driver);
	     	 iphone.clickGb(); 
	     	iphone.clickColor();
	     	 
	     	
	     	
	     	
		
		//((//div[@class='sg-col-inner'])[4]//span)[3]
		
		
		
		
		
		 // SignInPassword pass=new SignInPassword(driver); pass.sendKeysPassword();
		 // pass.clickButton(); pass.clickCheckBox(); 
		//MainPageHeader header=new
		  //MainPageHeader(driver);
		//header.selectDropDown(); header.sendKeySearchBox();
		 // header.clickSearchBox(); GoToCart cart=new GoToCart(driver); cart.clikcart();
			/*
			 * ArrayList<String> array=new ArrayList<String>(driver.getWindowHandles());
			 * driver.switchTo().window(array.get(1));
			 *  IphonePage iphone=new
			 * IphonePage(driver); iphone.clickGb(); iphone.clickColor();
			 * iphone.clickaddCart(); iphone.clickSkip(); ShoppingCart cart1=new
			 * ShoppingCart(driver); cart1.clickDelete();
			 */
		
		
		
		
		 
			
		
		
	}

}
