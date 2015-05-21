package com.webtek.action;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.webtek.utils.Log;
import com.webtek.pages.HomePage;
import com.webtek.test.SelTestCase;

public class SelectedItemOnCartAction extends SelTestCase {

	public SelectedItemOnCartAction(WebDriver driver) {
		this.driver = driver;
	}

	public static void execute() throws Exception {

		try {
			HomePage.clickOnLogo.click();
			Log.info("clickOnLogo element is found");
		} catch (Exception e) {
			Log.info("clickOnLogo element is not found");
			throw (e);
		}

		/**
		 * ADDING 1ST PRODUCT CART FORM HOME PAGE
		 */

		try {
			Actions action = new Actions(driver);
			WebElement selectItem = HomePage.BobyPage.shortSleeveTShirt;
			action.moveToElement(selectItem)
					.moveToElement(HomePage.BobyPage.shortSleeveTShirtAddToCart)
					.click().build().perform();
			Log.info("Selecting a product form home page and moving to detail about the product");
			HomePage.BobyPage.continueShopping.click();
			Log.info("Continue Shopping");
		} catch (Exception e) {
			Log.info("We did not move to product detail page");
			throw (e);
		}

		/**
		 * ADDMING 2ND PRODUCT TO THE CART FORM HOME PAGE
		 */

		try {
			Actions action = new Actions(driver);
			WebElement selectItem = HomePage.BobyPage.blouse;
			action.moveToElement(selectItem)
					.moveToElement(HomePage.BobyPage.blouseAddToCart).click()
					.build().perform();
			Log.info("Selecting a product form home page and moving to detail about the product");
			HomePage.BobyPage.continueShopping.click();
			Log.info("Continue Shopping");
		} catch (Exception e) {
			Log.info("We did not move to product detail page");
			throw (e);
		}

		/**
		 * CHECKING THE SELECTED ITEM SHOULD BE ON MINI CART
		 */

		Actions action = new Actions(driver);
		action.moveToElement(HomePage.HeaderPage.moveToCart).build().perform();// MouseOver
																				// on
																				// Cart

		/**
		 * EXPLICIT WAIT
		 */

		ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {
				driver.findElements(By.className("cart_block_product_name"));
				return Boolean.valueOf(true);
			}

		};

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(e);

		// elements = new ArrayList<WebElement>();
		try {

			elements = HomePage.HeaderPage.productTitleInMiniCart;
			for (WebElement element : elements) {

				String title = element.getAttribute("title");

				String selectedProductTitle = HomePage.BobyPage.shortSleeveTShirtProductTitle
						.getAttribute("title");
				Log.info("Selected product titiel is------> "
						+ selectedProductTitle);

				if (selectedProductTitle.equals(title)) {
					Log.info("Product title in cart------>" + title);
					Log.info("product Title Matches");
					break;
				} else {
					Log.info("Product title in cart------>" + title);
					Log.info("Selected item is not in cart");
				}

			}

			Log.info("Comparision of title is done successfully");

		} catch (Exception E) {
			Log.info("Comparision of title is not done successfully");
		}

		/**
		 * Checking the Summation of the amount in minicart.
		 */

		elements = (List<WebElement>) HomePage.HeaderPage.productPriceInMiniCart;
		float totalPrice = 0;
		for (WebElement element : elements) {
			String price = element.getText().replace("$", "")
					.replaceFirst(",", "");
			float allPrice = Float.parseFloat(price);

			Log.info("The prices of individual item is --->" + allPrice);
			totalPrice = totalPrice + allPrice;
		}

		Log.info("totalPrice is -->" + totalPrice);
		System.out.println(totalPrice);
		DecimalFormat df = new DecimalFormat("##.##");
		df.setRoundingMode(RoundingMode.DOWN);
		float expectedAmount = totalPrice + 2;
		Log.info("The expected price is-->" + df.format(expectedAmount));

		String actualPrice = HomePage.HeaderPage.totalPrice.getText()
				.replace("$", "").replaceFirst(",", "");
		float actualAmount = Float.parseFloat(actualPrice);
		Log.info("The Actual price is-->" + actualAmount);

		/**
		 * COMPARING THE TWO PRICE AND ASSERTING THEY ARE SAME OR NOT
		 */

		float epsilon = 000002;
		if (Math.abs(expectedAmount - actualAmount) < epsilon) {
			Log.info("The summation of price is done correctly");
		} else {
			Log.info("The summation of price is not done correctly");
		}

	}

}
