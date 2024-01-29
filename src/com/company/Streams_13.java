package com.company;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.google.common.collect.Streams;

public class Streams_13 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SOURAV\\chrmDriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//thead/tr/th[1]")).click();
		List<WebElement> list1 = driver.findElements(By.xpath("//tr/td[1]"));
		list1.stream().map(s -> s.getText()).forEach(n -> System.out.println(n));
		List<String> originalList = list1.stream().map(s -> s.getText()).collect(Collectors.toList());
		List<String> sortedList = list1.stream().map(s -> s.getText()).sorted().collect(Collectors.toList());
		// Assert.assertEquals(list1, sortedList);
		Assert.assertTrue(originalList.equals(sortedList));
		System.out.println("sourav");

		/* Getting price of each respective Veggie: */

		Stream<String> veggie = list1.stream().map(s -> s.getText());
		
		Stream<String> price = list1.stream().map(n -> getPrice(n)); // mapping to price column
		
		Stream<String> Result= Streams.concat(veggie,price);
		
		Result.forEach(s ->System.out.println(s));
	
		/*********concating respective element**********/
		List<String> veggie2 = list1.stream().map(s -> s.getText()).collect(Collectors.toList());
		
		List<String> price2 = list1.stream().map(n -> getPrice(n)).collect(Collectors.toList());;
		List<String> Result2 = IntStream.range(0,Math.min(veggie2.size(),price2.size()))
				.mapToObj(i -> veggie2.get(i)+price2.get(i))
				.collect(Collectors.toList());;
		for (String rs:Result2 ) {
			System.out.println(rs);
		}
		/***********Getting price of a single Item from the list **************/
		Stream<String> veggie3 = list1.stream().map(s -> s.getText());
		
		Stream<String> price3 = list1.stream().filter(s ->s.getText().contains("Beans"))
				.map(n -> getPrice(n)); // mapping to price column
		price3.forEach(s ->System.out.println(s));
		/***********Pagination **************/
		List<String> price4; 
		do {
			List<WebElement> list2 = driver.findElements(By.xpath("//tr/td[1]"));
		price4 = list2.stream().filter(s ->s.getText().contains("Potato"))
				.map(n -> getPrice(n)).collect(Collectors.toList()); // mapping to price column
		
		if(price4.size()==0) {
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			
			//continue;
		}
		price4.forEach(s ->System.out.println(s));
		}while(price4.size()==0);
		
		
		
		
		
		
	}
	private static String getPrice(WebElement w) {
		String price= w.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
		
	}

}
