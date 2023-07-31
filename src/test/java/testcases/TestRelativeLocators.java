package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class TestRelativeLocators {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("about:blank");
		driver.manage().window().maximize();
		driver.navigate().to("https://www.way2automation.com/way2auto_jquery/index.php#load_box");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement above = driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.tagName("select")));
		above.sendKeys("trainer.way2automation.com");
		
		WebElement below = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.tagName("select")));
		below.sendKeys("New Delhi");
		
		WebElement rightOf = driver.findElement(RelativeLocator.with(By.xpath("//input[@type='password']")).toRightOf(By.tagName("label")));		
		rightOf.sendKeys("myPassword");
		
		WebElement leftOf = driver.findElement(RelativeLocator.with(By.linkText("Signin")).toLeftOf(By.xpath("(//input[@type='submit'])[2]")));		
		leftOf.click();
		
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		
		driver.close();
		driver.quit();

	}

}
