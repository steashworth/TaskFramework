package com.automationpractice.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationpractice.pages.BaseClass;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.ShoppingCartPage;

public class AddToCartFromHomePageTest extends BaseClass {

	public static HomePage homePage;
	public static ShoppingCartPage shoppingCartPage;
	
		@Test
		@Parameters("browser")
		public static void validateAddToCartFromHomePage(String browser) throws InterruptedException {
			
			driver.get(baseUrl);
			driver.manage().window().maximize();
			
			if (browser.equalsIgnoreCase("firefox")) {

				homePage.selenium.scrollToContent(0, 800, driver);
				
			}
			
			homePage = new HomePage(driver);
			shoppingCartPage = new ShoppingCartPage(driver);
			Assert.assertTrue(homePage.validateAddToCartFromHomePage(driver));
		//	homePage.closePopupWindow(driver);
			
			//remove this
			homePage.navigateToShoppingCartPage(driver);
			
			Assert.assertTrue(shoppingCartPage.validateProductAddedToCart(driver));

		}

/*		
		
		@Test
		public static void validateProductAddedToCart() throws InterruptedException {

			Assert.assertTrue(homePage.validateProductAddedToCart(driver));

		}
*/

	}
