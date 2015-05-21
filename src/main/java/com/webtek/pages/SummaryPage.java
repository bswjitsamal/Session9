package com.webtek.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SummaryPage {

	private WebDriver driver;

	public SummaryPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = ".button.btn.btn-default.standard-checkout.button-medium>span")
	public static WebElement proceedToCheckOutInSummaryPage;

	@FindBy(how = How.CSS, using = ".cart_total>span")
	public static List<WebElement> totalPriceOfIndividualproduct;

	@FindBy(how = How.CSS, using = "#total_price")
	public static WebElement totalPrice;

}
