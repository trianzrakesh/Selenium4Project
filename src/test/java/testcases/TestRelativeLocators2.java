package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class TestRelativeLocators2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("about:blank");
		driver.manage().window().maximize();
		driver.navigate().to("https://www.way2automation.com/way2auto_jquery/index.php#load_box");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(with(By.tagName("input")).above(By.tagName("select"))).sendKeys("trainer.way2automation.com");
		
		driver.findElement(with(By.tagName("input")).below(By.tagName("select"))).sendKeys("New Delhi");
		
		driver.findElement(with(By.xpath("//input[@type='password']")).toRightOf(By.tagName("label"))).sendKeys("myPassword");		
		
		driver.findElement(with(By.linkText("Signin")).toLeftOf(By.xpath("(//input[@type='submit'])[2]"))).click();
		
		driver.navigate().refresh();
		Thread.sleep(3000);

		driver.findElement(with(By.partialLinkText("THE")).near(By.linkText("Signin"))).click();
		
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		
		driver.close();
		driver.quit();

	}

}
