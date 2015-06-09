package com.webtek.action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.webtek.utils.Log;
import com.webtek.pages.DashBoardPage;
import com.webtek.pages.HomePage;
import com.webtek.pages.ProductComparePage;
import com.webtek.pages.ProductPage;
import com.webtek.test.SelTestCase;

public class PriceCompareAction extends SelTestCase{

	public static void execute() throws Exception {

		/**
		 * ADDING EVENING DRESS TO THE COMPARE
		 */

		// Mouse Hover action

		try {
			Actions action = new Actions(driver);
			WebElement mainMenu = HomePage.HeaderPage.menu_dresses;
			action.moveToElement(mainMenu)
					.moveToElement(HomePage.HeaderPage.subMenuEveningDress)
					.click().build().perform();
			Log.info("Moving to product listing page by clicking on the submenu");
		} catch (Exception e) {
			Log.error("Navigation in between menu element is not found");
			throw (e);
		}

		// Scroll down
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0,350)");

		// Adding a product to a cart
		try {
			Actions action = new Actions(driver);
			WebElement mainMenu = ProductPage.selecitngProduct;
			action.moveToElement(mainMenu)
					.moveToElement(ProductPage.addToCompare).click().build()
					.perform();
			Log.info("Adding a product to compare done successfully");
		} catch (Exception e) {
			Log.error("Adding a product to compare not done successfully");
			throw (e);
		}

		Thread.sleep(1000);

		/**
		 * ADDING CASUAL DRESS TO COMPARE
		 */

		// Mouse Hover action

		try {
			Actions action = new Actions(driver);
			WebElement mainMenu = HomePage.HeaderPage.menu_dresses;
			action.moveToElement(mainMenu)
					.moveToElement(HomePage.HeaderPage.subMenuCasualDress)
					.click().build().perform();
			Log.info("Moving to product listing page by clicking on the submenu");
		} catch (Exception e) {
			Log.error("Navigation in between menu element is not found");
			throw (e);
		}

		// Adding a product to a cart
		try {
			Actions action1 = new Actions(driver);
			WebElement mainMenu = ProductPage.selecitngProduct;
			action1.moveToElement(mainMenu)
					.moveToElement(ProductPage.addToCompare).click().build()
					.perform();
			Log.info("Adding a product to compare done successfully");
		} catch (Exception e) {
			Log.error("Adding a product to compare not done successfully");
			throw (e);
		}

		Thread.sleep(1000);
		// Clicking on compare button

		ProductPage.compareButton.click();

		/**
		 * COMPARING THE PRICE AND SELECTING THE LOWSET ONE
		 * 
		 */
		
		
		/**
		 * EXPLICIT WAIT
		 */

		ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {
				driver.findElements(By.cssSelector(".price.product-price"));
				return Boolean.valueOf(true);
			}

		};

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(e);
		
		
		
		
		/**
		 * Checking the Summation of the amount in minicart.
		 */
		

		String price = ProductComparePage.priceOfFirstProduct.getText().replace("$", "").replace(",", "");
		System.out.println("----------------->" + price);
		
		


		String price1 = ProductComparePage.priceOfSecondProduct.getText()
				.replace("$", "").replace(",", "");
		System.out.println("----------------->" + price1);

		double dprice = Double.parseDouble(price);
		double dprice1 = Double.parseDouble(price1);

		if (dprice < dprice1) {

			ProductComparePage.addToCartButtonForFirstProduct.click();
			System.out.println(dprice);

		} else {
			ProductComparePage.addToCartButtonForSecondProduct.click();
			System.out.println(dprice1);
		}
		Thread.sleep(2000);
	}
}
