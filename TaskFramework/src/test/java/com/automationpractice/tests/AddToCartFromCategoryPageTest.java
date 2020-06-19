package com.automationpractice.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationpractice.pages.BaseClass;
import com.automationpractice.pages.CategoryPage;

public class AddToCartFromCategoryPageTest extends BaseClass {

	public static CategoryPage page;

	@Test
	@Parameters("browser")
	public static void validateAddToCartFromCategoryPage(String browser) throws InterruptedException {

		driver.get(baseUrl + "?id_category=7&controller=category");
		driver.manage().window().maximize();
		
		if (browser.equalsIgnoreCase("firefox")) {

			page.selenium.scrollToContent(0, 700, driver);
			
		}
		
		page = new CategoryPage(driver);
		Assert.assertTrue(page.validateAddToCartFromCategoryPage(driver));

	}

}
