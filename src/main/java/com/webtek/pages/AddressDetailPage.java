package com.webtek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddressDetailPage {

	private WebDriver driver;

	public AddressDetailPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = "#center_column>form>p>button")
	public static WebElement proceedToCheckOutInAddressDetailPage;

}
