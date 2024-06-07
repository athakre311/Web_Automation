package com.qa.testCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver = new ChromeDriver();

	@BeforeMethod
	public void setup() throws InterruptedException {
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	driver.get("https://www.flipkart.com/");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[@title='Login']/span")).click();
	
	}
	
	@AfterMethod
	public void close001() {
		driver.close();
	}
	
	@Test
	public void loginWithIncorrectCredentials()
	{
		driver.findElement(By.xpath("//form/div/input[@type='text']")).sendKeys("123456789");
		driver.findElement(By.xpath("//div[@class='LSOAQH']/button")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='llBOFA']/span")).getText(), "Please enter valid Email ID/Mobile number", "Error");
	}

}
