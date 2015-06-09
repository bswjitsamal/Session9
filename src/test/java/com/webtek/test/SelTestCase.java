package com.webtek.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import com.webtek.utils.Log;


public class SelTestCase {

	public static WebDriver driver;
	public static List<WebElement> elements;

	public String URL, Node;
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;

	@Parameters("browser")
	@BeforeTest
	public void SetUp(String browser) throws Exception, MalformedURLException {
		
		DOMConfigurator.configure("log4j.xml");
		String URL = "http://automationpractice.com/index.php";
		
		if (browser.equalsIgnoreCase("firefox")) {

			try {
				Log.info("Executing on Firefox");
				System.out.println("Executing on Firefox");
				String Node = "http://192.168.10.148:5555/wd/hub";
				DesiredCapabilities cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");

				driver = new RemoteWebDriver(new URL(Node), cap);
				// Puts an Implicit wait, Will wait for 10 seconds before
				// throwing
				// exception
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				// Launch website
				driver.navigate().to(URL);
				Log.info("Openign the browser with the given URL");
				driver.manage().window().maximize();
			} catch (Exception e) {
				Log.error("Opening browser is not happening");
				throw (e);
			}

		} else if (browser.equalsIgnoreCase("chrome")) {

			try {
				Log.info("Executing on Chrome");
				System.out.println(" Executing on CHROME");
				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				String Node = "http://192.168.10.148:6666/wd/hub";
				driver = new RemoteWebDriver(new URL(Node), cap);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				// Launch website
				driver.navigate().to(URL);
				Log.info("Openign the browser with the given URL");
				driver.manage().window().maximize();
			} catch (Exception e) {

				Log.error("Opening browser is not happening");
				throw (e);

			}

		}

		else if (browser.equalsIgnoreCase("ie")) {
			try {
				Log.info("Executing on IE");
				System.out.println(" Executing on IE");
				DesiredCapabilities cap = DesiredCapabilities
						.internetExplorer();
				cap.setBrowserName("ie");
				String Node = "http://192.168.10.145:6666/wd/hub";
				driver = new RemoteWebDriver(new URL(Node), cap);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				// Launch website
				driver.navigate().to(URL);
				driver.manage().window().maximize();

			} catch (Exception e) {

				Log.error("Opening browser is not happening");
				throw (e);

			}

		} else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
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
