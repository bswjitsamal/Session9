package com.webtek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderSummaryPage {

	private WebDriver driver;

	public OrderSummaryPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = "#cart_navigation>button")
	public static WebElement iConfirmMyOrder;

	@FindBy(how = How.CSS, using = ".button-exclusive.btn.btn-default")
	public static WebElement otherPaymentMethods;

	@FindBy(how = How.CSS, using = ".alert.alert-success")
	public static boolean orderCompleteMessage;
}
