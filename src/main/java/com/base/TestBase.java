package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.util.TestUtil;
import com.util.WebEventListener;

public class TestBase {

	public static EventFiringWebDriver e_driver;
	// public static WebEventListener eventListener;
	public static com.util.WebEventListener eventListener;
	public static Properties prop;
	public static WebDriver driver;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("resources\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {

		String browserName = prop.getProperty("browserName");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		// Fire event
		e_driver = new EventFiringWebDriver(driver); // to register with eventFiringWebdriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

}
