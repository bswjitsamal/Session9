package com.webtek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaymentMethodPage {

	private WebDriver driver;

	public PaymentMethodPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = ".cheque")
	public static WebElement payByCheque;

	@FindBy(how = How.CSS, using = ".bankwire")
	public static WebElement payByBankWire;
}
