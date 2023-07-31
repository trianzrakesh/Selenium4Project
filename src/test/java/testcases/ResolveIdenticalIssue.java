package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;
;
public class ResolveIdenticalIssue {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("about:blank");
		Thread.sleep(3000);
		driver.navigate().to("https://www.way2automation.com/way2auto_jquery/index.php");
		Thread.sleep(5000);
		//resolve identical element issue using index 
		driver.findElement(RelativeLocator.with(By.xpath("(//input[@value='Submit'])[2]"))).click();
		Thread.sleep(5000);
		driver.findElement(RelativeLocator.with(By.name("name"))).sendKeys("Rocky");
		driver.findElement(RelativeLocator.with(By.name("phone"))).sendKeys("+918888812345");
		driver.findElement(RelativeLocator.with(By.name("email"))).sendKeys("trainer@way2automation.com");
		driver.findElement(RelativeLocator.with(By.xpath("//input[@type='text' and @name='city']"))).sendKeys("New Delhi");
		driver.findElement(RelativeLocator.with(By.xpath("(//input[@type='text'])[4]"))).sendKeys("trainer");
		Thread.sleep(5000);
		driver.close();
		driver.quit();
		
	}

}
