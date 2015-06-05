package com.webtek.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class WebDriverListerners extends AbstractWebDriverEventListener {

	private By lastFindBy;
	private WebElement lastElement;
	private String originalValue;

	/**
	 * URL NAVIGATION | NAVIGATE() & GET()
	 */

	// PRINT THE URL BEFORE NAVIGATION TO SPECIFIC URL

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before Navigation To " + url + "my URL was"
				+ driver.getCurrentUrl());
	}

	// PRING THE CURRENT AFTER NAVIGATION TO SPECIFIC URL

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {

		System.out.println("After Navigation To" + url + "my URL is"
				+ driver.getCurrentUrl());

	}

	// PRINT BEFORE NAVIGATING BACK "navigate.back()"

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Before Navigating Back, I was at "
				+ driver.getCurrentUrl());
	}

	// PRINT AFTER NAVIGATING BACK "navigate.back()

	@Override
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("After Navigate back, I am in "
				+ driver.getCurrentUrl());
	}

	// PRINT URL BEFORE NAVIGATE FORWARD "navigate.forward()

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Before Navigating Forward, I was in"
				+ driver.getCurrentUrl());
	}

	// PRINT URL AFTER NAVIGATE BACKWORD "navigate.backword()

	@Override
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("After Navigating Forward, I am in "
				+ driver.getCurrentUrl());
	}

	/**
	 * ON EXCEPTION | SCREENSHOT, THROWING ERROR
	 */

	// TAKE SCREESHOT WHEN THERE IS AN EXCEPTION
	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		String path;
		try {
			WebDriver augmentedDriver = new Augmenter().augment(driver);
			File source = ((TakesScreenshot) augmentedDriver)
					.getScreenshotAs(OutputType.FILE);
			path = "./target/screenshots/" + source.getName();
			FileUtils.copyFile(source, new File(path));
		} catch (IOException e) {
			path = "Failed to capture screenshot: " + e.getMessage();
		}
		return;
	}

	/**
	 * FINDING ELELEMENT | FINDELEMENT() & FINDELEMENTS()
	 */

	// CALL BEFORE FIND ELEMENT(S)
	@Override
	public void beforeFindBy(By by, WebElement webelement, WebDriver driver) {
		lastFindBy = by;
		System.out.println("Trying to Find " + lastFindBy + ".");
	}

	// CALL AFTER FIND ELEMENT(S)
	@Override
	public void afterFindBy(By by, WebElement webelement, WebDriver driver) {
		lastFindBy = by;
		System.out.println("Found " + lastFindBy + ".");
	}

	/**
	 * CLICK|CLICK()
	 */

	// CALLL BEFORE CLICK ON AN ELEMENT
	@Override
	public void beforeClickOn(WebElement webelement, WebDriver driver) {
		System.out.println("Trying to click on element " + webelement);
		// HIGHLIGHT ELEMENT BEFORE CLICK
		for (int i = 0; i < 1; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					webelement, "color: black; border: 3px solid black;");
		}
	}

	// CALLED AFTER CLICKING AN ELEMENT
	@Override
	public void afterClickOn(WebElement webelement, WebDriver driver) {
		System.out.println("Clicked element with " + webelement + "");
	}

	/**
	 * CHANGING THE VALUES | CLEAR & SENDKEYS()
	 */

	// BEFORE CHANGING VALUES
	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		lastElement = element;
		originalValue = element.getText();

		// WAHT IF THE ELEMENT IS VISIBLE ANYMORE
		if (originalValue.isEmpty()) {
			originalValue = element.getAttribute("value");
		}
	}

	// AFTER CHANGING VALUES
	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		lastElement = element;
		String changedValue = "";
		try {
			changedValue = element.getText();

		} catch (Exception e) {
			System.out
					.println("Could not log change of element , because of stale element"
							+ "element referance exception");
			return;
		}

		// WHAT IF THE ELEMENT IS NOT VISIBLE ANYMORE
		if (changedValue.isEmpty()) {
			changedValue = element.getAttribute("value");
		}
		System.out.println("Changing value in element found " + lastElement
				+ "from" + originalValue + "to" + changedValue + "");

	}

}
