package com.webtek.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.webtek.pages.ContactUsPage;
import com.webtek.pages.HomePage;
import com.webtek.test.SelTestCase;
import com.webtek.utils.Log;

public class ContactUsAction extends SelTestCase {

	public static void execute(String DATA, String CUSTOMEREMAIL, String ORDER,
			String MESSAGE) {

		/**
		 * CLICK ON CONTACTUS LINK ON HOME PAGE TO REDIRECT
		 */

		HomePage.contact_us.click();

		/**
		 * ASSERTING WE ARE ON CONTACT US PAGE
		 */

		if (driver.getTitle().equals("Contact us - My Store")) {
			Log.info("We are in contact us page");
		} else {
			Log.info("We are not in contact us page");
		}

		/**
		 * EXPLICIT WAIT
		 */

		ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				// ContactUsPage.subjectHeading;
				driver.findElement(By.id("id_contact"));
				return Boolean.valueOf(true);

			}
		};

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(e);

		/**
		 * ENTERING DATA IN FIELDS FORM EXCEL FILE
		 */

		Select select = new Select(ContactUsPage.subjectHeading);
		select.selectByVisibleText(DATA);

		try {
			ContactUsPage.email.clear();
			ContactUsPage.email.sendKeys(CUSTOMEREMAIL);
			Log.info("Customer Email text box element is found");
		} catch (Exception e1) {
			Log.info("Customer Email text box element is not found");

		}

		try {
			ContactUsPage.idOrder.sendKeys(ORDER);
			Log.info("Order text box element is found");
		} catch (Exception e1) {
			Log.info("Order text box element is not found");
		}

		try {
			ContactUsPage.message.sendKeys(MESSAGE);
			Log.info("Message text are element is found");
		} catch (Exception e1) {
			Log.info("Message text are element is not found");
		}

		try {
			ContactUsPage.submitMessage.click();
			Log.info("Sumbit button element is found");
		} catch (Exception e1) {
			Log.info("Sumbit button element is not found");
		}

	}

}
