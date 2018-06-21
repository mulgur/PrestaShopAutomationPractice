package com.prestashop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NegativeScenarios {
	WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com");
		driver.findElement(By.className("login")).click();

		
	}
	
	@Test
	public void wrongCredentials() {
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("cybertek123");
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
		
		String expected = "Authentication failed.";
		String actual = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
		Assert.assertTrue(actual.contains(expected));	
	}
	@Test
	public void invalidEmail() {
		driver.findElement(By.id("email")).sendKeys("abc gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("cybertek123");
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
		
		String expected = "Invalid email address.";
		String actual = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
		Assert.assertTrue(actual.contains(expected));	}
	
	@Test
	public void blankEmail() {
		driver.findElement(By.id("passwd")).sendKeys("cybertek123");
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
		
		String expected = "An email address required.";
		String actual = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
		Assert.assertTrue(actual.contains(expected));	
	}
	@Test
	public void blankPassword() {
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
		
		String expected = "Password is required.";
		String actual = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
		Assert.assertTrue(actual.contains(expected));	
	}


		




		
		
	}


