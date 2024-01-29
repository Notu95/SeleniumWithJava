package com.company;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCertificationHandling_10 {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SOURAV\\chrmDriver\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();

	}

}
