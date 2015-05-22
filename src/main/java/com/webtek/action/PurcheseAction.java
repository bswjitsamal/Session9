package com.webtek.action;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import com.webtek.utils.Log;
import com.webtek.pages.AddressDetailPage;
import com.webtek.pages.DashBoardPage;
import com.webtek.pages.LogOutPage;
import com.webtek.pages.OrderSummaryPage;
import com.webtek.pages.PaymentMethodPage;
import com.webtek.pages.ProductPage;
import com.webtek.pages.ShippingPage;
import com.webtek.pages.SummaryPage;
import com.webtek.test.SelTestCase;

public class PurcheseAction extends SelTestCase {

	// public static WebDriver driver;

	public static void execuite() throws Exception {

		// Mouse Hover action
		
		try {
			Actions action = new Actions(driver);
			WebElement mainMenu = DashBoardPage.mainManu;
			action.moveToElement(mainMenu).moveToElement(DashBoardPage.subMenu)
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
			Actions action1 = new Actions(driver);
			WebElement mainMenu1 = ProductPage.selecitngProduct;
			action1.moveToElement(mainMenu1)
					.moveToElement(ProductPage.addToCart).click().build()
					.perform();
			Log.info("Adding a product to cart done successfully");
		} catch (Exception e) {
			Log.error("Adding a product to cart not done successfully");
			throw (e);
		}

		try {
			ProductPage.addToCart.click();
			Reporter.log("Adding a product to cart");
			Log.info("Adding a product to cart");
		} catch (Exception e) {
			Log.error("Adding a product to cart element is not found");
			throw (e);
		}

		try {
			ProductPage.proceedToCheckOut.click();
			Reporter.log("purchesing the seleted product");
			Log.info("purchesing the seleted product");
		} catch (Exception e) {
			Log.error("purchesing the seleted product element is not found");
			throw (e);
		}

		try {
			SummaryPage.proceedToCheckOutInSummaryPage.click();
			Reporter.log("proceedToCheckOutInSummaryPage");
			Log.info("proceedToCheckOutInSummaryPage");

		} catch (Exception e) {
			Log.error("proceedToCheckOutInSummaryPage element is not found");
			throw (e);
		}

		try {
			AddressDetailPage.proceedToCheckOutInAddressDetailPage.click();
			Reporter.log("proceedToCheckOutInAddressDetailPage");
			Log.info("proceedToCheckOutInAddressDetailPage");
		} catch (Exception e) {
			Log.error("proceedToCheckOutInAddressDetailPage element is not found");
			throw (e);
		}

		try {
			ShippingPage.agreeTermsOfServices.click();
			ShippingPage.proceedTOCheckOutConfirmShippingPage.click();
			Reporter.log("proceedTOCheckOutConfirmShippingPage");
			Log.info("proceedTOCheckOutConfirmShippingPage");
		} catch (Exception e) {
			Log.error("proceedTOCheckOutConfirmShippingPage element is not found");
			throw (e);
		}

		try {
			PaymentMethodPage.payByCheque.click();
			Reporter.log("payByCheque");
			Log.info("payByCheque");
		} catch (Exception e) {
			Log.error("payByCheque element is not found");
			throw (e);
		}

		try {
			OrderSummaryPage.iConfirmMyOrder.click();
			Reporter.log("iConfirmMyOrder");
			Log.info("iConfirmMyOrder");
		} catch (Exception e) {
			Log.error("iConfirmMyOrder element is not found");
			throw (e);
		}

		try {
			LogOutPage.signOut.click();
			Reporter.log("Clicking on SignOut button");
			Log.info("Clicking on SignOut button");
		} catch (Exception e) {
			Log.info("SignOut button element is not found");
		}

	}

}
