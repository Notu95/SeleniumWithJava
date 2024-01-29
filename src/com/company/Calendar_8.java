package com.company;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

 class Calendar_8 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SOURAV\\chrmDriver\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Actions a =new Actions(driver);

		driver.get("https://www.path2usa.com/travel-companion/"); 
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		
		WebElement element= driver.findElement(By.xpath("//div/input[@id='form-field-travel_comp_date']"));
		//scrolling the page down
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000L);
		a.moveToElement(element).click().perform();
		
		driver.findElement(By.cssSelector("span[class*='cur-month']")).click();
		String month=driver.findElement(By.cssSelector("span[class*='cur-month']")).getText();
		System.out.println(month);
		while(!month.equalsIgnoreCase("December")) {
			driver.findElement(By.cssSelector("span[class*='flatpickr-next-month']")).click();
			Thread.sleep(1000L);
					
				}
		
		driver.findElement(By.cssSelector("span[class*='cur-month']")).click();
		List<WebElement> date=driver.findElements(By.cssSelector("span[class*='flatpickr-day']"));
		int count=driver.findElements(By.cssSelector("span[class*='flatpickr-day']")).size();
		for(int i=0;i< count;i++){

			if(date.get(i).getText().equalsIgnoreCase("23")) {
				date.get(i).click();
				
			}
			
		}
		
		
		
	}

}
