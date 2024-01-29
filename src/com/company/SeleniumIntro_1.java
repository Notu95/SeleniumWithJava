package com.company;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class SeleniumIntro_1 {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SOURAV\\chrmDriver\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
//		driver.close();
//		driver.quit();
	}
}
