package org.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchTrainPom {
	public static WebDriver driver;
	public SearchTrainPom(){
		PageFactory.initElements(driver, this);
		
	}
	@CacheLookup
	@FindBy(xpath="//input[@role='searchbox'])[1]")
	private WebElement fromTxtBox;
	@CacheLookup
	@FindBy(xpath="(//input[@role='searchbox'])[2]")
	private WebElement toTxtBox;
	@CacheLookup
	@FindBy(xpath="(//a[contains(text(),20)]")
	private WebElement dateTxtBox;
	@CacheLookup
	@FindBy(xpath="(//input[@type='text'])[4]")
	private WebElement classesDropDown;
	public WebElement getClickSleeper() {
		return clickSleeper;
	}
	@CacheLookup
	@FindBy(xpath="//span[text()='Sleeper (SL)']")
	private WebElement clickSleeper;
	@CacheLookup
	@FindBy(xpath="(//input[@type='text'])[5]")
	private WebElement quotaDropDown;
	@CacheLookup
	@FindBy(xpath="//label[text()='Train with Available Berth ']")
	private WebElement availableCheckBox;
	@CacheLookup
	@FindBy(xpath="//button[@class='search_btn train_Search']")
	private WebElement searchBtn;

	public WebElement getFromTxtBox() {
		return fromTxtBox;
	}
	public WebElement getToTxtBox() {
		return toTxtBox;
	}
	public WebElement getDateTxtBox() {
		return dateTxtBox;
	}
	public WebElement getClassesDropDown() {
		return classesDropDown;
	}
	public WebElement getQuotaDropDown() {
		return quotaDropDown;
	}
	public WebElement getAvailableCheckBox() {
		return availableCheckBox;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
}
