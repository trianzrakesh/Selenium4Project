package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.NoSuchElementException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class InitiateBrowser {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("about:blank");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		  .withTimeout(Duration.ofSeconds(30))
		  .pollingEvery(Duration.ofSeconds(5))
		  .ignoring(NoSuchElementException.class);
		driver.get("http://thetestingworld.com/testings");
		WebElement username =  driver.findElement(By.name("fld_username"));
		username.sendKeys("trainer@way2automation.com");
		driver.findElement(By.name("fld_email")).sendKeys("trainer@way2automation.com");
		driver.findElement(By.name("fld_password")).sendKeys("G00gle004");
		driver.findElement(By.name("fld_cpassword")).sendKeys("G00gle004");
		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[1]/a")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name("phone"))).sendKeys("+918888812345");
		driver.findElement(By.name("address")).sendKeys("Delhi");
		driver.findElement(By.xpath("//input[@name='add_type'][@value='office']")).click();
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		
		driver.close();
		driver.quit();

	}

}
