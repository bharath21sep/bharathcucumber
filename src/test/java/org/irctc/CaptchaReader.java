package org.irctc;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class CaptchaReader {
	
		@Test
		public void openBrowser() throws IOException, InterruptedException, TesseractException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("https://www.irctc.co.in/nget/train-search");
	    String windowHandle = driver.getWindowHandle();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		for (String s : windowHandles) {
			if(!s.equals(windowHandle)) {
			driver.switchTo().window(s);
			}
		}
		WebElement alertWindow = driver.findElement(By.xpath("//button[text()='OK']"));
		alertWindow.click();
		driver.switchTo().window(windowHandle);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//a[text()=' LOGIN ']")).click();
	    driver.findElement(By.id("userId")).sendKeys("bh77bh");
	    driver.findElement(By.id("pwd")).sendKeys("QwePoi@123");
	    Thread.sleep(3000);
	File src= driver.findElement(By.xpath("(//*[@id='nlpImgContainer']//following::img)[2]")).getScreenshotAs(OutputType.FILE);
	File per = new File("G:\\selenium\\IrctcTicketBooking\\screenshot\\captcha2.png");		FileHandler.copy(src, per);
	Thread.sleep(3000);
		ITesseract image = new Tesseract();
String imageText = image.doOCR(new File ("G:\\selenium\\IrctcTicketBooking\\screenshot\\captcha2.png"));
		System.out.println(imageText);
	String finalText = imageText.split("below")[1].replaceAll("[^a-zA-Z0-9]","");
	System.out.println(finalText);
driver.findElement(By.id("nlpAnswer")).sendKeys(finalText);	
Thread.sleep(10000);
	driver.findElement(By.xpath("//button[text()='SIGN IN']")).click();
	 driver.findElement(By.xpath("//*[@id=\'origin\']/span/input")).sendKeys("MGR CHENNAI CTL - MAS");
		driver.findElement(By.xpath("(//input[@role='searchbox'])[2]")).sendKeys("SALEM JN - SA");
		WebElement dateBox = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		dateBox.click();
		WebElement refresh = driver.findElement(By.xpath("//a[contains(text(),27)]"));
		refresh.click();
		WebElement classBox = driver.findElement(By.xpath("//*[@id=\'journeyClass\']"));
		classBox.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Sleeper (SL)']")).click();
		
		driver.findElement(By.xpath("//label[text()='Train with Available Berth ']")).click();
		driver.findElement(By.xpath("//button[@class='search_btn train_Search']")).click();	
		
		Thread.sleep(10000);
		Set<String> window2=driver.getWindowHandles();
		Thread.sleep(3000);
		WebElement table = driver.findElement(By.xpath("(//td[@class='ng-star-inserted'])[2]"));
		table.click();
		Thread.sleep(3000);
		table.click();
	
		driver.findElement(By.xpath("(//button[text()=' Book Now '])[1]")).click();
		Set<String> window3=driver.getWindowHandles();
		for (String string : window3) {
			if(!string.equals(window2))
				driver.switchTo().window(string);
			
		}
		WebElement agreeBox = driver.findElement(By.xpath("//span[text()='I Agree']"));
		agreeBox.click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@role='searchbox']")).click();
		driver.findElement(By.xpath("//li[@role='option']")).click();
		driver.findElement(By.id("mobileNumber")).sendKeys("9080235290");
		driver.findElement(By.id("aaa1")).sendKeys("Ayothiyapattinam");
		driver.findElement(By.id("aaa4")).sendKeys("636103");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);		
		Thread.sleep(10000);
		WebElement postOffice = driver.findElement(By.name("address-postOffice"));
		Select s= new Select(postOffice);
		s.selectByValue("Ayodhiyapattinam East B.O");
		driver.findElement(By.xpath("(//div[@role='radio'])[2]")).click();
		//driver.findElement(By.xpath("(//div[@role='radio'])[3]")).click();
		driver.findElement(By.xpath("(//button[text()='Continue '])[1]")).click();
		}
		
		}

	
