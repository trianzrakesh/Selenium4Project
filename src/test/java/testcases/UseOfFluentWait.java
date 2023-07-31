package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UseOfFluentWait {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
			
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		System.out.println("URL before login: " + driver.getCurrentUrl());
		System.out.println("Page Title before login: " + driver.getTitle());
		System.out.println("************************************************************");
		//wait for username field to appear to enter credentials
		wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		System.out.println("URL after login: " + driver.getCurrentUrl());
		System.out.println("Page Title after login: " + driver.getTitle());
		System.out.println("************************************************************");
		//wait for user to appear on the top right corner so that I can click to logout
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span")));
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span")).click();
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("URL after logout: " + driver.getCurrentUrl());
		System.out.println("Page Title after logout: " + driver.getTitle());
		driver.close();
		driver.quit();
		
		}

}
