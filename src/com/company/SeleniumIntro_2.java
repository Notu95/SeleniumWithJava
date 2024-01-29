package com.company;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;

public class SeleniumIntro_2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SOURAV\\chrmDriver\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.className("form_input")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauc");
		driver.findElement(By.name("login-button")).click();
		System.out.println(driver.findElement(By.cssSelector("h3[data-test='error']")).getText());
		System.out.println(driver.findElement(By.xpath("//h3[@data-test='error']")).getText());
		//Assert.assertEquals(driver.findElement(By.xpath("//h3[@data-test='error']")).getText(), "Epic sadface: Username and password do not match any user in this service");
		System.err.println(driver.findElement(By.xpath("/input[3]")).getAttribute("id"));
	}

}
