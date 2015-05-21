package com.webtek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPage {

	private WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ".//*[@id='center_column']/ul/li[1]/div")
	public static WebElement selecitngProduct;

	@FindBy(how = How.CSS, using = "#center_column>ul>li:nth-of-type(1)>div>div:nth-of-type(2)>div:nth-of-type(2)>a:nth-of-type(1)>span")
	public static WebElement addToCart;

	@FindBy(how = How.CSS, using = "#layer_cart>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(4)>a>span")
	public static WebElement proceedToCheckOut;

}
