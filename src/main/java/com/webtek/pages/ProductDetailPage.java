package com.webtek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductDetailPage {

	private WebDriver driver;

	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = ".span_link.no-print")
	public static WebElement imageViewInLargeScreen;

	@FindBy(how = How.CSS, using = ".btn.btn-default.button-minus.product_quantity_down>span")
	public static WebElement decreaseQuantity;

	@FindBy(how = How.CSS, using = ".btn.btn-default.button-plus.product_quantity_up")
	public static WebElement increaseQuantity;

	@FindBy(how = How.CSS, using = ".fancybox-item.fancybox-close")
	public static WebElement imageViewInNormalScreen;

	@FindBy(how = How.ID, using = "send_friend_button")
	public static WebElement sendToAFriend;

	@FindBy(how = How.ID, using = "friend_name")
	public static WebElement friendName;

	@FindBy(how = How.ID, using = "friend_email")
	public static WebElement friendEmail;

	@FindBy(how = How.ID, using = "sendEmail")
	public static WebElement sendEmail;

	@FindBy(how = How.CSS, using = "#send_friend_form_content>p>a")
	public static WebElement cancel;

	@FindBy(how = How.CSS, using = "#add_to_cart>button")
	public static WebElement addToCart;

	@FindBy(how = How.ID, using = "group_1")
	public static WebElement dropDownField;

	@FindBy(how = How.CSS, using = ".btn.btn-default.button.button-medium>span")
	public static WebElement proceedToChekOutInProductDetailPage;

}
