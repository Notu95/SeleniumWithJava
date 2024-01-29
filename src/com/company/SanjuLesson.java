package com.company;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SanjuLesson {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SOURAV\\chrmDriver\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
	}

}
