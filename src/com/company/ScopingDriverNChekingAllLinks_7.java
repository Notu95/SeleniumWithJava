package com.company;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ScopingDriverNChekingAllLinks_7 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SOURAV\\chrmDriver\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		Actions a = new Actions(driver);

		WebElement footerdriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		int x = footerdriver.findElements(By.tagName("a")).size();
		System.out.println(x);
		WebElement column1driver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(column1driver.findElements(By.tagName("a")).size());

		for (int i = 1; i < column1driver.findElements(By.tagName("a")).size(); i++) {

			String openInAnotherTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

			column1driver.findElements(By.tagName("a")).get(i).sendKeys(openInAnotherTab);

//			WebElement wb= column1driver.findElements(By.tagName("a")).get(i);
//			a.moveToElement(wb).contextClick().build().perform();

		}
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		
	
			Thread.sleep(5000L);
		
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

		// driver.close();

	}

}
