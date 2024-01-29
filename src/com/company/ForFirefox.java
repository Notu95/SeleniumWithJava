package com.company;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ForFirefox {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\SOURAV\\GeckoDriverForMozilla\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
//		driver.get("https://rahulshettyacademy.com/");
//		System.out.println(driver.getTitle());
//		System.out.println(driver.getCurrentUrl());
//		driver.close();
//		driver.quit();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Actions a =new Actions(driver);

		driver.get("https://www.path2usa.com/travel-companion/");
		
		WebElement element= driver.findElement(By.xpath("//div/input[@id='form-field-travel_comp_date']"));
		a.moveToElement(element).click().perform();
		
	}

}
