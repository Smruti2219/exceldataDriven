import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDynamicDropdowns {

	public static <WebDriver> void main(String[] args) throws InterruptedException {
		
	
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Automate From(BLR) and To(MAA) dropdown and select city  
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='ctl00_mainContent_ddl_originStation1_CTXTaction']")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).sendKeys("BLR");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@id,'destinationStation1_CTXT')]")).sendKeys("MAA");
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		
		
		//Automate Country Search field – search for 'Ind'
		
		WebElement element2 = driver.findElement(By.xpath("//input[@id='autosuggest']"));
		element2.click();
		
		Thread.sleep(2000);
		element2.sendKeys("Ind");
		
	//Get all the suggested items & Find for India and click
	 
		 List<WebElement> sug = driver.findElements(By.className("ui-corner-all"));
		
		 for(WebElement el : sug)
		 {
			 Thread.sleep(2000);
			 System.out.println(el.getText());
		 }
		
		 for (WebElement sug1 : sug) {
			
		    if (sug1.getText().contains("India")) {
		    	Thread.sleep(1000);
		        sug1.click();
		        
		      
		    }
		 }
		 /*WebElement topBarCountryElement = driver.findElement(By.cssSelector(".topbar-right .flag-flag-1"));

         // Get the text of the country name
         String countryName = topBarCountryElement.getText();
         System.out.println("Country Name in Top Bar: " + countryName);*/
		 JavascriptExecutor jsresult=(JavascriptExecutor) driver;
	        System.out.print("Select Country name is: ");
	        System.out.println(jsresult.executeScript("return document.getElementById('autosuggest').value"));
	        driver.quit();
		
		}
	}
	 
	 