package com.prestashop.tests;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PositiveScenarios {
	WebDriver driver;
	StringBuilder sb = new StringBuilder(20);
	
	@BeforeMethod
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get( "http://automationpractice.com");
		driver.findElement(By.className("login")).click();
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		sb.append("");
		Random random = new Random();
		for (int j = 0; j < 6; j++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
	}
	
	
	@Test
    public void loginClick() throws InterruptedException {
        
        System.out.println(sb.toString());
    
        driver.findElement(By.id("email_create")).sendKeys(sb.toString().substring(1)+"@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
        driver.manage().window().fullscreen();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys(sb.toString());
        Thread.sleep(2000);
        System.out.println(sb.toString());
        driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys(sb.toString());
        Thread.sleep(2000);
        driver.findElement(By.id("passwd")).sendKeys("11111");
        Thread.sleep(2000);
        driver.findElement(By.id("firstname")).sendKeys(sb.toString());
        Thread.sleep(2000);
        driver.findElement(By.id("customer_lastname")).sendKeys(sb.toString());
        Thread.sleep(2000);
        driver.findElement(By.id("address1")).sendKeys("aaaa");
        Thread.sleep(2000);
        driver.findElement(By.id("city")).sendKeys("Virginia");
        Thread.sleep(2000);
        driver.findElement(By.id("id_state")).sendKeys("USA");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"postcode\"]")).sendKeys("22022");
        Thread.sleep(2000);
        driver.findElement(By.id("id_country")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("phone_mobile")).sendKeys("1234567890");
        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span")).click();
        String expected=sb.toString();
        String actual=driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).getText();
        Assert.assertTrue(actual.contains(expected));
        System.out.println("passed");
    }
	
	
	


}