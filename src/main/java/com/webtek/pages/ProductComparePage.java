package com.webtek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductComparePage {

	private WebDriver driver;

	public ProductComparePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = ".price.product-price")
	public static WebElement priceOfProduct;

	@FindBy(how = How.XPATH, using = ".//*[@id='product_comparison']/tbody/tr[1]/td[3]/div[3]/span")
	public static WebElement priceOfFirstProduct;

	@FindBy(how = How.XPATH, using = ".//*[@id='product_comparison']/tbody/tr[1]/td[2]/div[3]/span")
	public static WebElement priceOfSecondProduct;

	@FindBy(how = How.XPATH, using = ".//*[@id='product_comparison']/tbody/tr[1]/td[2]/div[5]/div/div/a[1]/span")
	public static WebElement addToCartButtonForFirstProduct;

	@FindBy(how = How.XPATH, using = ".//*[@id='product_comparison']/tbody/tr[1]/td[3]/div[5]/div/div/a[1]/span")
	public static WebElement addToCartButtonForSecondProduct;

	@FindBy(how = How.XPATH, using = "//a[@class='button lnk_view btn btn-default'][@title='View']")
	public static WebElement viewProduct;

	@FindBy(how = How.CSS, using = ".button.lnk_view.btn.btn-default>span>i")
	public static WebElement continueShopping;

}
