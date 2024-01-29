package com.company;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;

public class Screenshot_11 {

	public static void main(String[] args) throws IOException {
		ChromeOptions options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SOURAV\\chrmDriver\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://expired.badssl.com/");
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\SOURAV\\RoughTestingDelete\\abc.png"));
		
		
		

	}

}
