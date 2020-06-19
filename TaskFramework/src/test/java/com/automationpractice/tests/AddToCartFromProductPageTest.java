package com.automationpractice.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationpractice.pages.BaseClass;
import com.automationpractice.pages.ProductPage;

public class AddToCartFromProductPageTest extends BaseClass {

	public static ProductPage page;

	@Test
	@Parameters("browser")
	public static void validateAddToCartFromProductPage(String browser) throws InterruptedException {
		
		driver.get(baseUrl + "?id_product=2&controller=product");
		driver.manage().window().maximize();
		page = new ProductPage(driver);
		Assert.assertTrue(page.validateAddToCartFromProductPage(driver));
				
	}

}
