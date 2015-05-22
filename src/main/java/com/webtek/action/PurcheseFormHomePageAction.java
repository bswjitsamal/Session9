package com.webtek.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.webtek.utils.Log;
import com.webtek.pages.AddressDetailPage;
import com.webtek.pages.HomePage;
import com.webtek.pages.LoginPage;
import com.webtek.pages.OrderSummaryPage;
import com.webtek.pages.PaymentMethodPage;
import com.webtek.pages.ProductDetailPage;
import com.webtek.pages.ShippingPage;
import com.webtek.pages.SummaryPage;
import com.webtek.test.SelTestCase;

public class PurcheseFormHomePageAction extends SelTestCase {

	// private WebDriver driver;

	public PurcheseFormHomePageAction(WebDriver driver) {
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

		try {
			Actions action = new Actions(driver);
			WebElement selectItem = HomePage.BobyPage.shortSleeveTShirt;
			action.moveToElement(selectItem)
					.moveToElement(HomePage.BobyPage.shortSleeveTShirtDetails)
					.click().build().perform();
			Log.info("Selecting a product form home page and moving to detail about the product");
		} catch (Exception e) {
			Log.info("We did not move to product detail page");
			throw (e);
		}

		// Sending an email to the friend
		try {
			ProductDetailPage.sendToAFriend.click();
			Log.info("sendToAFriend element is found");
		} catch (Exception e) {
			Log.info("sendToAFriend element is not found");
			throw (e);
		}

		try {
			ProductDetailPage.friendName.sendKeys("Biswajit");
			Log.info("friendName is found");
		} catch (Exception e) {
			Log.info("friendName element is not found");
		}

		try {
			String email1 = null;
			email1 = SignUpAction.emailTest;
			ProductDetailPage.friendEmail.sendKeys(email1);
			Log.info("friendEmail element is found");
		} catch (Exception e) {
			Log.info("friendEmail element is not found");
		}

		try {
			ProductDetailPage.cancel.click();
			Log.info("cancel element is found");
		} catch (Exception e) {
			Log.info("cancel element is not found");
		}

		// Increatese the Quantity
		try {
			for (int i = 1; i < 3; i++) {
				ProductDetailPage.increaseQuantity.click();
				Log.info("Increasing the product quantity");
			}
			Log.info("increaseQuantity element is found");
		} catch (Exception e) {
			Log.info("increaseQuantity element is not found");
		}

		// Decrease the Quantity
		try {
			for (int j = 1; j < 2; j++) {
				ProductDetailPage.decreaseQuantity.click();
				Log.info("Decreasing the product quantity");
			}
			Log.info("decreaseQuantity element is found");
		} catch (Exception e) {
			Log.info("decreaseQuantity element not found");
		}

		// Selecting size
		try {
			Select sel = new Select(ProductDetailPage.dropDownField);
			sel.selectByVisibleText("S");
			Log.info("dropDownField element is found");
		} catch (Exception e) {
			Log.info("dropDownField element is not found");
		}

		// Clicking on Add To Cart
		try {
			ProductDetailPage.addToCart.click();
			Log.info("addToCart element is found");
		} catch (Exception e) {
			Log.info("addToCart element is not found");
		}

		try {
			ProductDetailPage.proceedToChekOutInProductDetailPage.click();
			Log.info("proceedToChekOutInProductDetailPage element is found");
		} catch (Exception e) {
			Log.info("proceedToChekOutInProductDetailPage element is not found");
		}

		try {
			SummaryPage.proceedToCheckOutInSummaryPage.click();
			Log.info("proceedToCheckOutInSummaryPage element found");
		} catch (Exception e) {
			Log.info("proceedToCheckOutInSummaryPage element is not found");
		}

		try {
			String email1 = null;
			email1 = SignUpAction.emailTest;
			LoginPage.enterEmail.sendKeys(email1);
			Log.info("enterEmail element found");
		} catch (Exception e) {
			Log.info("enterEmail element is not found");
		}

		try {
			LoginPage.enterPassword.sendKeys("password");
			Log.info("enterPassword element found");
		} catch (Exception e) {
			Log.info("enterPassword element is not fond");
		}

		try {
			LoginPage.signin_button.click();
			Log.info("signin_button element is found");
		} catch (Exception e) {
			Log.info("signin_button element is not found");
		}

		try {
			AddressDetailPage.proceedToCheckOutInAddressDetailPage.click();
			Log.info("proceedToCheckOutInAddressDetailPage element is found");
		} catch (Exception e) {
			Log.info("proceedToCheckOutInAddressDetailPage element is not found");
		}

		try {
			ShippingPage.agreeTermsOfServices.click();
			Log.info("agreeTermsOfServices element found");
		} catch (Exception e) {
			Log.info("agreeTermsOfServices element is not found");
		}

		try {
			ShippingPage.proceedTOCheckOutConfirmShippingPage.click();
			Log.info("proceedTOCheckOutConfirmShippingPage element is found");
		} catch (Exception e) {
			Log.info("proceedTOCheckOutConfirmShippingPage element is not found");
		}

		try {
			PaymentMethodPage.payByCheque.click();
			Log.info("payByCheque element is found");
		} catch (Exception e) {
			Log.info("payByCheque element is not found");
		}

		try {
			OrderSummaryPage.iConfirmMyOrder.click();
			Log.info("iConfirmMyOrder element is found");
		} catch (Exception e) {
			Log.info("iConfirmMyOrder element is not found");
		}

		if (OrderSummaryPage.orderCompleteMessage = true) {
			Log.info("Order complete successfully");
		} else {
			Log.info("There is some problem");
		}

	}

}
