package com.company;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IFrames_6 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SOURAV\\chrmDriver\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		//WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(8));
		
		driver.get("https://jqueryui.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Droppable']")).click();
		List<WebElement> AllIFrames=driver.findElements(By.cssSelector("iframe"));
		System.out.println(AllIFrames.size());
		driver.switchTo().frame(0);
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		WebElement source =driver.findElement(By.cssSelector("div#draggable"));
		WebElement target =driver.findElement(By.cssSelector("div#droppable"));
		
		Actions a= new Actions(driver);
		a.dragAndDrop(source, target).build().perform();
		
		driver.switchTo().defaultContent();
		
		

	}

}
