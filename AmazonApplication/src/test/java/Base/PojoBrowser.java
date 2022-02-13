package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class PojoBrowser {
	public static  WebDriver chromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver",
				"D:\\software\\Selenium File\\Chrome file\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
    public static WebDriver edgeBrowser()
    {
    	System.setProperty("webdriver.edge.driver",
				"D:\\software\\Selenium File\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		return driver;
    }
}
