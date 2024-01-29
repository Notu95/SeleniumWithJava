package com.company;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class GreenKartNSynchhronization_4 {
	

	public static void main(String[] args) {
		WebDriver driver;
		//WebDriverManager.chromedriver().setup();
		String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",
				projectPath+"\\SeleniumWithJava\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SOURAV\\chrmDriver\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(8));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();

		String[] productYouWant = { "cucumBer", "bRocolli", "Tomato", "Brinjal", "carrot","PotAto" };
		// List<String> itemNames = Arrays.asList(productYouWant);
		String promoCode="rahulshettyacademy";
		
		addToCart(driver,productYouWant);
		placeOrder(driver,w,promoCode);
		
		}
	

	private static void placeOrder(WebDriver driver,WebDriverWait w, String promoCode) {
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector(".promoCode")).sendKeys(promoCode);
		driver.findElement(By.cssSelector(".promoBtn")).click(); 
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Code applied ..!']"))); 
		
		driver.findElement(By.xpath("//button[text()='Place Order']")).click(); 
		
		
	}





	private static void addToCart(WebDriver driver, String[] productYouWant) {
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		int k = 0;

		for (int i = 0; i < products.size(); i++) {
			String product = products.get(i).getText().toLowerCase();

			for (int j = 0; j < productYouWant.length; j++) {
				String itemName = productYouWant[j].toLowerCase();

				if (product.contains(itemName)) {
					driver.findElements(By.xpath("//a[@class='increment']")).get(i).click();
					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
					k++;
				}
			}
			if (k == productYouWant.length) {
				break;
			}
		}
	}
}
