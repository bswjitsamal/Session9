package com.webtek.test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.annotations.*;

import com.webtek.utils.Log;


public class SelTestCase {

	public static WebDriver driver;
	public static List<WebElement> elements;

	/*static Random rand = new Random();
	protected static String email = rand.nextInt(100) + "@t.com";*/

	@BeforeSuite
	public void SetUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		try {
			driver = new FirefoxDriver();
			driver.get("http://automationpractice.com/index.php");
			Log.info("Openign the browser with the given URL");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			Log.error("Opening browser is not happening");
			throw (e);
		}

	}

	@AfterSuite
	public void tearDown() {
		try {
			captureScreen();
			driver.close();
			driver.quit();
			Log.info("Closing the browser");
		} catch (Exception e) {
			Log.error("closing browser is not happening");
		}

	}

	public String captureScreen() {

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
		return path;

	}

}
