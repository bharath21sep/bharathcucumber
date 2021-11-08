package org.irctc;

import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.pom.SearchTrainPom;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTrain extends SearchTrainPom {
	
@BeforeClass
public void openBrowser() {
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	driver.manage().window().maximize();
}
@Test
public void loadUrl() throws InterruptedException {
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
	SearchTrainPom st = new SearchTrainPom();
	//st.getFromTxtBox().sendKeys("SALEM JN - SA");
	st.getToTxtBox().sendKeys("MGR CHENNAI CTL - MAS");
	//st.getDateTxtBox().click();
	st.getClassesDropDown().click();
	st.getClickSleeper().click();
	st.getAvailableCheckBox().click();
	//st.getSearchBtn().click();
	
	
	
}

}
