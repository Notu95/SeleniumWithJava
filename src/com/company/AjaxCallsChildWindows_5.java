package com.company;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjaxCallsChildWindows_5 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SOURAV\\chrmDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		//WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(8));
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		Actions a =new Actions(driver);
		WebElement SignIn = driver.findElement(By.cssSelector("span#nav-link-accountList-nav-line-1"));
		WebElement Searchbox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		
//		a.moveToElement(SignIn).build().perform();
		a.moveToElement(Searchbox).click().keyDown(Keys.SHIFT).sendKeys("Cricket Bat").doubleClick().build().perform();
		a.moveToElement(SignIn).contextClick().build().perform();
	}

}
