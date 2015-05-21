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

	public static void execute(String DATA, String CUSTOMEREMAIL,String ORDER,String MESSAGE) {

		/**
		 * CLICK ON CONTACTUS LINK ON HOME PAGE TO REDIRECT
		 */

		HomePage.contact_us.click();

		/**
		 * ASSERTING WE ARE ON CONTACT US PAGE
		 */
		
		if(driver.getTitle().equals("Contact us - My Store")){
			Log.info("We are in contact us page");
		}else{
			Log.info("We are not in contact us page");
		}
		
		
		/**
		 * IMPLICIT WAIT
		 */
		
		
		ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>(){
			public Boolean apply (WebDriver driver){
				//ContactUsPage.subjectHeading;
				driver.findElement(By.id("id_contact"));
				return Boolean.valueOf(true);
				
			}
		};
		
		WebDriverWait wait =  new WebDriverWait(driver,20);
		wait.until(e);
		
		
		Select select =  new Select(ContactUsPage.subjectHeading);
		select.deselectByVisibleText(DATA);
		
		ContactUsPage.email.sendKeys(CUSTOMEREMAIL);
		
		ContactUsPage.idOrder.sendKeys(ORDER);
		
		ContactUsPage.submitMessage.sendKeys(MESSAGE);
		
		ContactUsPage.submitMessage.click();

	}

}
