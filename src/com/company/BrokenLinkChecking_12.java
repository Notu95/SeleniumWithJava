package com.company;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class BrokenLinkChecking_12 {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SOURAV\\chrmDriver\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		Actions a = new Actions(driver);

		WebElement footerdriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		WebElement column1driver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[2]/ul"));
		System.out.println(column1driver.findElements(By.tagName("a")).size());

		SoftAssert sa=new SoftAssert();
		
		for (int i = 0; i < column1driver.findElements(By.tagName("a")).size(); i++) {

			String url = column1driver.findElements(By.tagName("a")).get(i).getAttribute("href");
			
			HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode=conn.getResponseCode();
			System.out.println(responseCode+ "  for  link by name:  "+ column1driver.findElements(By.tagName("a")).get(i).getText());
			sa.assertTrue(responseCode<400, "  for  link by name:  "+ column1driver.findElements(By.tagName("a")).get(i).getText()+" is a broken one  ");
		}
		
		sa.assertAll();
		
		
	}

}
