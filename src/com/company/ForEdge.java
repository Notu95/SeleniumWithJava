package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ForEdge {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver","C:\\Users\\SOURAV\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
//		driver.close();
//		driver.quit();
		

	}

}
