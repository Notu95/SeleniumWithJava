package com.company;

import java.awt.Container;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class StaticDropdowns_3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SOURAV\\chrmDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

//		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//		driver.manage().window().maximize();

		/*
		 * WebElement staticDropdown1=driver.findElement(By.id(
		 * "ctl00_mainContent_DropDownListCurrency"));
		 * 
		 * Select dropdown=new Select(staticDropdown1); dropdown.selectByIndex(3);
		 * 
		 * Assert.assertEquals("USD", dropdown.getFirstSelectedOption().getText());
		 * System.out.println(dropdown.getFirstSelectedOption().getText());
		 * dropdown.selectByVisibleText("AED");
		 * System.out.println(dropdown.getFirstSelectedOption().getText());
		 * dropdown.selectByValue("INR");
		 * System.out.println(dropdown.getFirstSelectedOption().getText());
		 */

		/*
		 * driver.findElement(By.id("divpaxinfo")).click(); try { Thread.sleep(2000L); }
		 * catch (InterruptedException e) {
		 * 
		 * e.printStackTrace(); } for(int adult=0;adult<4;adult++) {
		 * driver.findElement(By.id("hrefIncAdt")).click(); }
		 * 
		 * driver.findElement(By.id("btnclosepaxoption")).click();
		 */

		/*
		 * driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(
		 * ); driver.findElement(By.xpath("//a[@value='CCU']")).click();
		 * Thread.sleep(2000L);
		 * //driver.findElement(By.xpath("(//a[@value='IXB'])[2]")).click();
		 * 
		 * //driver.findElement(By.xpath(
		 * "//div[@id=\"glsctl00_mainContent_ddl_destinationStation1_CTNR\"]//a[@value='IXB']"
		 * )).click();
		 * 
		 * driver.findElement(By.xpath(
		 * "(//table[@id=\"citydropdown\"]//a[@value='IXB'])[2]")).click();
		 * System.out.println(driver.findElement(By.cssSelector(
		 * "a.ui-state-default.ui-state-highlight")).getText());
		 * driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).
		 * click();
		 * 
		 * 
		 * Thread.sleep(30000L); driver.close();
		 */

		/*
		 * driver.findElement(By.id("autosuggest")).sendKeys("ind");
		 * Thread.sleep(2000l); List<WebElement> options=
		 * driver.findElements(By.cssSelector("li[class='ui-menu-item'] "));
		 * //List<WebElement> options=
		 * driver.findElements(By.cssSelector("a[class='ui-corner-all'] "));
		 * 
		 * 
		 * for(WebElement option: options ) { System.out.println(option.getText()); }
		 * for(WebElement option: options ) {
		 * if(option.getText().equalsIgnoreCase("India")) { option.click(); break; } }
		 */

		/*
		 * System.out.println(driver.findElement(By.cssSelector("input[id*='IndArm']")).
		 * isSelected());
		 * driver.findElement(By.cssSelector("input[id*='IndArm']")).click();
		 * Thread.sleep(2000L);
		 * System.out.println(driver.findElement(By.cssSelector("input[id*='IndArm']")).
		 * isSelected()); System.out.println(driver.findElements(By.
		 * cssSelector("div[id='discount-checkbox'] input[type='checkbox']")).size() );
		 * Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='IndArm']")).
		 * isSelected()); Assert.assertEquals(driver.findElements(By.
		 * cssSelector("div[id='discount-checkbox'] input[type='checkbox']")).size(),
		 * 5); //List<WebElement> CheckBoxes=driver.findElements(By.
		 * cssSelector("div[id='discount-checkbox'] input[type='checkbox']")) ;
		 * 
		 * // for(WebElement CheckBox:CheckBoxes ) { //
		 * System.out.println(CheckBox.getText() ); // } List<WebElement>
		 * CheckBoxes1=driver.findElements(By.
		 * cssSelector("div[id='discount-checkbox'] div")) ;
		 * 
		 * for(WebElement CheckBox:CheckBoxes1 ) { System.out.println(CheckBox.getText()
		 * ); }
		 * 
		 * Thread.sleep(30000L); driver.close();
		 */

		/*
		 * if(driver.findElement(By.cssSelector("label[for*='Trip_1']")).getAttribute(
		 * "class").contains("select-label")) {
		 * System.out.println("rountrip button is checked"); }else
		 * {System.out.println("rountrip button is unchecked");}
		 * 
		 * 
		 * 
		 * driver.findElement(By.cssSelector("input[id*='Trip_1']")).click();
		 * 
		 * Thread.sleep(2000L);
		 * 
		 * //System.out.println(By.cssSelector("label[for*='Trip_1']")).getAttribute(
		 * "class") );
		 * 
		 * if(driver.findElement(By.cssSelector("label[for*='Trip_1']")).getAttribute(
		 * "class").contains("select-label")) {
		 * System.out.println("rountrip button is checked"); }else
		 * {System.out.println("rountrip button is unchecked");}
		 * 
		 * 
		 * 
		 * if(driver.findElement(By.cssSelector("#Div1")).getAttribute("style").contains
		 * ("0.5")) { System.out.println("The calender button is disabld"); } else {
		 * System.out.println("The calender button is enabld"); }
		 * 
		 * 
		 * Thread.sleep(10000L); driver.close();
		 * 
		 */

		String text = "Rahul";

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("name")).sendKeys(text);

		driver.findElement(By.cssSelector("[id='alertbtn']")).click();

		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().accept();

		driver.findElement(By.id("confirmbtn")).click();

		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().dismiss();
	}

}
