package com.webtek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShippingPage {

	private WebDriver driver;

	public ShippingPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "cgv")
	public static WebElement agreeTermsOfServices;

	@FindBy(how = How.CSS, using = ".button.btn.btn-default.standard-checkout.button-medium")
	public static WebElement proceedTOCheckOutConfirmShippingPage;

	@FindBy(how = How.CSS, using = ".fancybox-item.fancybox-close")
	public static WebElement cancelAlertMessage;

}
