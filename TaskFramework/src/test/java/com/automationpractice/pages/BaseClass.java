package com.automationpractice.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static String baseUrl = PropertiesFile.getBaseUrl();
	public static String baseBrowser = PropertiesFile.getBaseBrowser();
		
	@BeforeClass
	@Parameters("browser")
	public static void setupTest(String browser) throws Exception {
		
	//	if (browser.equalsIgnoreCase("Not set")) {
			
		//	browser = PropertiesFile.getProperties();

			if (browser.equalsIgnoreCase("chrome")) {

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			}

			else if (browser.equalsIgnoreCase("firefox")) {

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			}

			else if (browser.equalsIgnoreCase("edge")) {

				String projectPath = System.getProperty("user.dir");
				System.setProperty("webdriver.edge.driver", projectPath + "/drivers/edgedriver/msedgedriver.exe");
				driver = new EdgeDriver();

			}

			else if (browser.equalsIgnoreCase("opera")) {

				WebDriverManager.operadriver().setup();
				driver = new OperaDriver();

			}

			else if (browser.equalsIgnoreCase("ie")) {

				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();

			}

			else {

				// If no browser passed throw exception
				throw new Exception("Browser is not correct");

			}

	//	}

	//	else {

			// If no browser passed throw exception
	//		throw new Exception("Browser is not correct");

	//	}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterClass
	@Parameters("browser")
	public void tearDownTest(String browser) throws Exception {
		
		String productLinkValue = "blank";
		String productSelectedColor = "blank";
		PropertiesFile.setProperties("homePageProductLink", productLinkValue);
		PropertiesFile.setProperties("homePageProductSelectedColor", productSelectedColor);
		// driver.close();
		driver.quit();

		System.out.println("Test completed successfully");

	}

}
