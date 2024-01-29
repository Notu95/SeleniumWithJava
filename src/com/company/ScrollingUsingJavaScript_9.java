package com.company;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingUsingJavaScript_9 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SOURAV\\chrmDriver\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		WebElement element= driver.findElement(By.cssSelector(".tableFixHead"));
		//scrolling the page down
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView(true);", element);
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(1000L);
		//scrolling with in that table:
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		
		/* sum all the value in amounts column in that table */
		List<WebElement> amounts= driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		for(WebElement amount:amounts) {
		String Amount =amount.getText();
		System.out.println(Amount);
		sum=sum+ Integer.parseInt(Amount);
		
		
		}
		System.out.println("Summation of Amounts is:"+ sum);
		
	}

}
