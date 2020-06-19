package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actions.SeleniumActions;

public class CategoryPage {

	@FindBy(css = "#center_column > ul > li > div > div.left-block > div > a.product_img_link > img")
	WebElement itemImage;
	@FindBy(css = "#center_column > ul > li > div")
	WebElement productContainer;
	@FindBy(css = "#center_column > ul > li > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default")
	WebElement btnAddToCart;
	@FindBy(css = "#center_column > ul > li > div > div.right-block > div.button-container > a.button.lnk_view.btn.btn-default")
	WebElement btnMore;
	@FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a")
	WebElement btnProceedToCheckout;
	@FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a > span.ajax_cart_quantity")
	WebElement textCartQuantity;

	public SeleniumActions selenium;

	public CategoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		selenium = new SeleniumActions();
	}

	public boolean validateAddToCartFromCategoryPage(WebDriver driver) {
		//selenium.scrollToContent(0, 700, driver);
		selenium.performMouseHover(itemImage, driver);
		
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
		
		selenium.clickUsingJS(btnProceedToCheckout, driver);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		selenium.refresh(driver);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return selenium.validateText(textCartQuantity, driver, "1");
	}

}
