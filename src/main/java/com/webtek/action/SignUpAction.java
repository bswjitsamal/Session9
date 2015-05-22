package com.webtek.action;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.webtek.test.SelTestCase;
import com.webtek.utils.Log;
import com.webtek.pages.HomePage;
import com.webtek.pages.LoginPage;
import com.webtek.pages.SignUpPage;

public class SignUpAction {

	 /*
	 * static Random rand = new Random(); static String email =
	 * rand.nextInt(999) + "@test.com";
	 */
	public static String emailTest=null;
	
	public static void execute(String email, String firstName, String lastName,
			String password, String myfirstname, String mylastname,
			String mycompany, String myAddressField1, String myAddressField2,
			String myCity, String myPostCode, String myPhone,
			String myAliasAddress) {

		emailTest=email;
		HomePage.sign_in.click();
		Reporter.log("Clicking on SignIn link");
		Log.info("Clicking on SignIn link");

		LoginPage.emailCreate.sendKeys(email);
		Reporter.log("Entering an email to register");
		Log.info("Entering an email to register");

		LoginPage.submitCreate.click();
		Reporter.log("Clicking on Register button");
		Log.info("Clicking on Register button");

		SignUpPage.titleMr.click();
		Reporter.log("Clicked on Title radio button");
		Log.info("Clicked on Title radio button");

		SignUpPage.firstName.sendKeys(firstName);
		Reporter.log("Enterd first name in the text field");
		Log.info("Enterd first name in the text field");

		SignUpPage.lastName.sendKeys(lastName);
		Reporter.log("Enterd last name in the text field");
		Log.info("Enterd last name in the text field");

		SignUpPage.password.sendKeys(password);
		Reporter.log("Enterd password in the text field");
		Log.info("Enterd password in the text field");

		Select dropDownDays = new Select(SignUpPage.days);
		dropDownDays.selectByValue("5");
		Reporter.log("Selecting days for Date of birth form the Dropdown");
		Log.info("Selecting days for Date of birth form the Dropdown");

		Select dropDownMonths = new Select(SignUpPage.months);
		dropDownMonths.selectByVisibleText("August ");
		Reporter.log("Selecting Months for Date of birth form the Dropdown");
		Log.info("Selecting Months for Date of birth form the Dropdown");

		Select dropDownYears = new Select(SignUpPage.years);
		dropDownYears.selectByVisibleText("1984  ");
		Reporter.log("Selecting Years for Date of birth form the Dropdown");
		Log.info("Selecting Years for Date of birth form the Dropdown");

		SignUpPage.myfirstname.sendKeys(myfirstname);
		Reporter.log("Entering first name for shipping details");
		Log.info("Entering first name for shipping details");

		SignUpPage.mylastname.sendKeys(mylastname);
		Reporter.log("Entering last name for shipping details");
		Log.info("Entering last name for shipping details");

		SignUpPage.mycompany.sendKeys(mycompany);
		Reporter.log("Entering company name for shipping details");
		Log.info("Entering company name for shipping details");

		SignUpPage.myAddressField1.sendKeys(myAddressField1);
		Reporter.log("Entering address1 for shipping details");
		Log.info("Entering address1 for shipping details");

		SignUpPage.myAddressField2.sendKeys(myAddressField2);
		Reporter.log("Entering address2 for shipping details");
		Log.info("Entering address2 for shipping details");

		SignUpPage.myCity.sendKeys(myCity);
		Reporter.log("Entering city for shipping details");
		Log.info("Entering city for shipping details");

		Select dropDownState = new Select(SignUpPage.myState);
		dropDownState.selectByVisibleText("Nevada");
		Reporter.log("Entering state for shipping details");
		Log.info("Entering state for shipping details");

		SignUpPage.myPostCode.sendKeys(myPostCode);
		Reporter.log("Entering zip code for shipping details");
		Log.info("Entering zip code for shipping details");

		Select dropDownCountry = new Select(SignUpPage.myCountry);
		dropDownCountry.selectByVisibleText("United States");
		Reporter.log("Entering country for shipping details");
		Log.info("Entering country for shipping details");

		SignUpPage.myPhone.sendKeys(myPhone);
		Reporter.log("Entering Mobile Number for shipping details");
		Log.info("Entering Mobile Number for shipping details");

		SignUpPage.myAliasAddress.sendKeys(myAliasAddress);
		Reporter.log("Entering alias address for shipping details");
		Log.info("Entering alias address for shipping details");

		SignUpPage.register.click();
		Reporter.log("Clicking on Register button");
		Log.info("Clicking on Register button");

	}



}
