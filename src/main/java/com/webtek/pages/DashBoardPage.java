package com.webtek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashBoardPage {

	private WebDriver driver;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ".//*[@id='block_top_menu']/ul/li[2]/a")
	public static WebElement mainManu;

	@FindBy(how = How.CSS, using = "#block_top_menu>ul>li:nth-of-type(2)>ul>li:nth-of-type(3)>a")
	public static WebElement subMenu;

}
