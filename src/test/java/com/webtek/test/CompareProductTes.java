package com.webtek.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.webtek.action.PriceCompareAction;
import com.webtek.pages.HomePage;
import com.webtek.pages.ProductComparePage;
import com.webtek.pages.ProductPage;

public class CompareProductTes extends SelTestCase{
	
	@Test
	public void compareTwoProductPrice(){
		
		PageFactory.initElements(driver, HomePage.class);
		PageFactory.initElements(driver, HomePage.HeaderPage.class);
		PageFactory.initElements(driver, HomePage.HeaderPage.DressesPage.class);
		PageFactory.initElements(driver, ProductPage.class);
		PageFactory.initElements(driver, ProductComparePage.class);
		
		try {
			PriceCompareAction.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
