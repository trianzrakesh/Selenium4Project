package testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class TestMultipleElementsRelativeLocators {
	
	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("about:blank");
		driver.manage().window().maximize();
		driver.navigate().to("https://www.way2automation.com/way2auto_jquery/index.php#load_box");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement above = driver.findElement(with(By.tagName("input")).above(By.tagName("select")));
		above.sendKeys("trainer.way2automation.com");
		File aboveScrn = above.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(aboveScrn, new File("./screenshot/above.jpg"));
		
		WebElement below = driver.findElement(with(By.tagName("input")).below(By.tagName("select")));
		below.sendKeys("New Delhi");
		File belowScrn = below.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(belowScrn, new File("./screenshot/below.jpg"));
		
		WebElement rightOf = driver.findElement(with(By.xpath("//input[@type='password']")).toRightOf(By.tagName("label")));		
		rightOf.sendKeys("myPassword");
		File rightScrn = rightOf.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(rightScrn, new File("./screenshot/right.jpg"));
		
		WebElement leftOf = driver.findElement(with(By.linkText("Signin")).toLeftOf(By.xpath("(//input[@type='submit'])[2]")));		
		File leftScrn = leftOf.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(leftScrn, new File("./screenshot/left.jpg"));
		leftOf.click();
		
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		driver.close();
		driver.quit();

	}

}
