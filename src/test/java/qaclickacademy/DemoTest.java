package qaclickacademy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoTest {
	
	private static Logger log = LogManager.getLogger(DemoTest.class.getName());
	
	
	@Test
	public void Demo() {
	
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		
		log.info("This is info message");
		log.debug("This is debug message");
		log.error("This is error message");
		log.fatal("This is fatal message");
		
		
		String siteName=driver.getTitle();
		System.out.println(siteName);
		
		///String currentUrl=driver.getCurrentUrl();
		///System.out.println("Current URl is " + currentUrl);
		
		///System.out.println("Site name is "+ siteName);
		
		//String pagesource = driver.getPageSource();
		//System.out.println(pagesource);
		
		//driver.get("https://gaana.com/browse");
		
		/////String currentUrlgaana=driver.getCurrentUrl();
		///String siteNamegaana=driver.getTitle();
		///System.out.println("Current URl is " + currentUrlgaana);
		
		///System.out.println("Site name is "+ siteNamegaana);
		
		///driver.navigate().back();
		///System.out.println(driver.getCurrentUrl());
		
		///driver.navigate().forward();
		///System.out.println(driver.getCurrentUrl());
		
		
		
		
		driver.close();
	
	}

}
