package com.webtek.test;

import java.io.File;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtek.action.ContactUsAction;
import com.webtek.action.PurcheseFormHomePageAction;
import com.webtek.pages.ContactUsPage;
import com.webtek.pages.HomePage;
import com.webtek.utils.Excelutils;
import com.webtek.utils.Log;

public class SanityTest2 extends SelTestCase {

	@Test(dataProvider = "contactUs")
	public void contactUs(String data, String customerEmail, String order,String message) {
		PageFactory.initElements(driver, HomePage.class);
		PageFactory.initElements(driver, ContactUsPage.class);
       
		try{
			ContactUsAction.execute(data, customerEmail, order, message);
			Log.info("ContactUsAction done successfully");
			Log.endTestCase("THIS IS AN END");
		}catch(Exception e){
			Log.info("ContactUsAction not done successfully");
			e.printStackTrace();
		}
		
	}

	@DataProvider(name = "contactUs")
	public Object[][] getContactUsData() throws Exception {
		System.out.println(new File(".").getAbsolutePath());
		Object[][] cellData = Excelutils.getInstance().readData("src/test/resources/ContactUs.xls", 0);
		System.out.println("MMMMMM : " + cellData);
		return cellData;
	}

}
