package qaclickacademy;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class UptimizedAddToCartTest {
	@Test
	public  void UptimizedAddToCart() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		String[] NeededIteamsNames = {"Cucumber","Brocolli","Beetroot"};
			
		addItemToCart(driver, NeededIteamsNames);
		
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		
		//Explicitywait
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	
		
		
		Select selectCountry = new Select(driver.findElement(By.xpath("//div[@class='wrapperTwo']/div/select")));
		selectCountry.selectByVisibleText("India");
		
		
		driver.findElement(By.xpath("//input[@class='chkAgree']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		
		System.out.println(driver.getTitle());
		driver.close();
		
		}
		
		
	private static void addItemToCart(WebDriver driver, String[] NeededIteamsNames ) throws InterruptedException {
		int iteamselectedcount=0;
		int lenthofArray=NeededIteamsNames.length;
	

		List<WebElement> retrivedIteam =driver.findElements(By.xpath("//h4[@class='product-name']"));
		
		//Convert array to array list
		List ListofNeededIteamsNames = Arrays.asList(NeededIteamsNames);
		
		for(int i=0; i<retrivedIteam.size();i++) {
			String[] RetrivedIteamName=retrivedIteam.get(i).getText().split("-");
			String FormatedRerquiredname =RetrivedIteamName[0].trim();
			System.out.println(FormatedRerquiredname);
			Thread.sleep(3000);
			
			
			if(ListofNeededIteamsNames.contains(FormatedRerquiredname)) {
				iteamselectedcount++;
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				Thread.sleep(3000);
				if(iteamselectedcount==lenthofArray) {
					break;
				}
				
			}
		}
	}}
	
	
	

	


