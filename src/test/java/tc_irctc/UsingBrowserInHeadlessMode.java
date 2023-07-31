package tc_irctc;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.awt.HeadlessException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsingBrowserInHeadlessMode {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		
		WebDriver driver = WebDriverManager.chromedriver().capabilities(co).create();
		Dimension d = new Dimension(1350, 1024);
//		driver.get("about:blank");
		driver.manage().window().setSize(d);	
		driver.get("https://www.irctc.co.in/nget/train-search");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.findElement(with(By.id("origin"))).click();
		WebElement fromStation = driver.findElement(with(By.id("origin")));
		fromStation.sendKeys("New Delhi");
		
		Thread.sleep(3000);
		
		driver.close();
		driver.quit();

	}

}
