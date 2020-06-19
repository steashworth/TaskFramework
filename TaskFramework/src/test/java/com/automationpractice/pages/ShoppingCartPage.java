package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actions.SeleniumActions;
import config.PropertiesFile;

import com.automationpractice.pages.HomePage;

public class ShoppingCartPage {

	@FindBy(css = "#product_2_7_0_0 > td.cart_product > a")
	WebElement linkProduct;
	@FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a > span.ajax_cart_quantity")
	WebElement textCartQuantity;
	
	SeleniumActions selenium;

	public ShoppingCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		selenium = new SeleniumActions();
	}
	
	public static HomePage homePage;
	
	public boolean validateProductAddedToCart(WebDriver driver) {
		WebElement linksProduct = driver.findElement(By.cssSelector("#product_2_7_0_0 > td.cart_product > a"));
		String checkoutProductLinkValue = linksProduct.getAttribute("href");
		String expectedUrl = "http://automationpractice.com/index.php?id_product=2&controller=product#/size-s/color-black";
		String chosenProductLinkValue = PropertiesFile.getProperties("homePageProductLink");
		System.out.println("chosen product link: " + chosenProductLinkValue);
		System.out.println("checkout product link: " + checkoutProductLinkValue);
		System.out.println("expected url: " + expectedUrl);
		return selenium.validateUrl(checkoutProductLinkValue, driver, chosenProductLinkValue);
	}

}
