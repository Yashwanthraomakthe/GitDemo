package qaclickacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDownTest {
	@Test
	public  void DropDown() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		
		Select selectcurrency = new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']")));
		selectcurrency.selectByVisibleText("USD");
		Thread.sleep(5000);
		
		selectcurrency.selectByValue("INR");
		Thread.sleep(5000);
		
		selectcurrency.selectByIndex(0);
		Thread.sleep(5000);
		
		driver.close();

	}

}
