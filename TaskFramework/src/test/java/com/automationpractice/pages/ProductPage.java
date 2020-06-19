package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actions.SeleniumActions;

public class ProductPage {

	@FindBy(css = "#quantity_wanted")
	WebElement textQuantity;
	@FindBy(css = "#group_1")
	WebElement selectSize;
	@FindBy(css = "#add_to_cart > button")
	WebElement btnAddToCart;
	@FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a")
	WebElement btnProceedToCheckout;
	@FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > span")
	WebElement crossCloseMiniBasket;
	@FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a > span.ajax_cart_quantity")
	WebElement textCartQuantity;

	SeleniumActions selenium;

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		selenium = new SeleniumActions();
	}

	public boolean validateAddToCartFromProductPage(WebDriver driver) {
		//selenium.scrollToContent(0, 400, driver);
		selenium.clear(textQuantity);
		selenium.setText(textQuantity, "2");
		selenium.setDropDown(selectSize, "L");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		selenium.click(btnAddToCart);


		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//selenium.clickUsingJS(btnProceedToCheckout, driver);

		//selenium.refresh(driver);

		selenium.click(crossCloseMiniBasket);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return selenium.validateText(textCartQuantity, driver, "2");
	}

}
