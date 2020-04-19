package qaclickacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SpicejetFilightSearchWithCurrentDateTest {
	
	@Test(groups="Failed")
	public  void SpicejetFilightSearchWithCurrentDate() throws InterruptedException {
		
		
		//Set property to launch chrome driver
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		
		//Select source of traveling
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.xpath("//a[@text='Chennai (MAA)']")).click();
		Thread.sleep(2000);
		
		//Select Destination of traveling
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
		driver.findElement(By.xpath("(//a[@text='Goa (GOI)'])[2]")).click();
		Thread.sleep(2000);
		
		
		//Select the current Date
		//driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active.ui-state-hover")).click();
		
		//Select the passengers count
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		Select selectadult = new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Adult']")));
		selectadult.selectByVisibleText("2");
		Thread.sleep(3000);
		
		Select selectchild = new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Child']")));
		selectchild.selectByVisibleText("2");
		Thread.sleep(3000);
		
		Select selectinfact = new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Infant']")));
		selectinfact.selectByVisibleText("2");
		Thread.sleep(3000);
		
		//Select the dollar type
		Select selectcurrency = new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']")));
		selectcurrency.selectByVisibleText("INR");
		Thread.sleep(5000);
		
		//Click on Search button to get the available filights
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();
		Thread.sleep(2000);
		
		System.out.println("filight searched successfully");
		
		driver.close();
		
	}

}
