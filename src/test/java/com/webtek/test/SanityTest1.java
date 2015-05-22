package com.webtek.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.webtek.utils.Log;
import com.webtek.action.PurcheseFormHomePageAction;
import com.webtek.action.SelectedItemOnCartAction;
import com.webtek.pages.AddressDetailPage;
import com.webtek.pages.HomePage;
import com.webtek.pages.LoginPage;
import com.webtek.pages.OrderSummaryPage;
import com.webtek.pages.PaymentMethodPage;
import com.webtek.pages.ProductDetailPage;
import com.webtek.pages.ShippingPage;
import com.webtek.pages.SummaryPage;
import com.webtek.pages.HomePage.HeaderPage;

public class SanityTest1 extends SelTestCase {

	@Test
	public void firstAddProductThenCheckOutWithSign() {

		PageFactory.initElements(driver, HomePage.class);
		PageFactory.initElements(driver, HomePage.BobyPage.class);
		PageFactory.initElements(driver, ProductDetailPage.class);
		PageFactory.initElements(driver, SummaryPage.class);
		PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, AddressDetailPage.class);
		PageFactory.initElements(driver, ShippingPage.class);
		PageFactory.initElements(driver, PaymentMethodPage.class);
		PageFactory.initElements(driver, OrderSummaryPage.class);

		try {
			PurcheseFormHomePageAction.execute();
			Log.info("PurcheseFormHomePageAction done successfully");
		} catch (Exception e) {
			Log.info("PurcheseFormHomePageAction not done successfully");
			e.printStackTrace();
		}

	}

	@Test(priority = 2)
	public void verifyItemPresentInCartAndSummation() throws Exception {

		PageFactory.initElements(driver, HomePage.class);
		PageFactory.initElements(driver, HomePage.BobyPage.class);
		PageFactory.initElements(driver, HeaderPage.class);
		PageFactory.initElements(driver, SummaryPage.class);

		try {
			SelectedItemOnCartAction.execute();
			Log.info("SelectedItemOnCartAction done successfully");
		} catch (Exception e) {
			Log.info("SelectedItemOnCartAction not done successfully ");
		}

	}

}
