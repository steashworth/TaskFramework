package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actions.SeleniumActions;
import config.PropertiesFile;

public class HomePage {

	@FindBy(css = "#homefeatured > li:nth-child(2) > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default")
	WebElement btnAddToCart;
	@FindBy(css = "#homefeatured > li:nth-child(2) > div > div.right-block > div.button-container > a.button.lnk_view.btn.btn-default")
	WebElement btnMore;
	@FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a")
	WebElement btnProceedToCheckout;
	@FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > span")
	WebElement crossCloseMiniBasket;
	@FindBy(css = "#index > div.fancybox-overlay.fancybox-overlay-fixed > div > div > a")
	WebElement crossCloseQuickView;
	@FindBy(css = "#homefeatured > li:nth-child(2) > div > div > div.product-image-container > a > img")
	WebElement itemImage;
	@FindBy(css = "#homefeatured > li:nth-child(2) > div > div.left-block > div > a.quick-view")
	WebElement linkQuickView;
	@FindBy(css = "#homefeatured > li:nth-child(2) > div")
	WebElement itemContainer;
	@FindBy(css = "#group_1")
	WebElement optionSelectedSize;
	@FindBy(css = "#color_to_pick_list > li.selected > a")
	WebElement optionSelectedColor;
	@FindBy(css = "#layer_cart_product_attributes")
	WebElement textAddedProductAttributes;
	@FindBy(css = "#layer_cart_product_price")
	WebElement textAddedProductPrice;
	@FindBy(css = "#layer_cart_product_quantity")
	WebElement textAddedProductQuantity;
	@FindBy(css = "#layer_cart_product_title")
	WebElement textAddedProductTitle;
	@FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a > span.ajax_cart_quantity")
	WebElement textCartQuantity;

	public String productLinkValue;
	public String productSelectedSize;
	public String productSelectedColor;

	public SeleniumActions selenium;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		selenium = new SeleniumActions();
	}

	public boolean validateAddToCartFromHomePage(WebDriver driver) {
		selenium.performMouseHover(itemContainer, driver);

		WebElement linkProductImage = driver.findElement(
				By.cssSelector("#homefeatured > li:nth-child(2) > div > div.left-block > div > a.product_img_link"));
		
		productLinkValue = selenium.getAttribute(linkProductImage, "href");

		System.out.println("productLinkValue right now is: " + productLinkValue);


		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		selenium.click(linkQuickView);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id,'fancybox-frame')]")));


		productSelectedColor = selenium.getAttribute(optionSelectedColor, "title");
		productSelectedColor = productSelectedColor.toLowerCase();
		//productSelectedSize = selenium.getAttribute(optionSelectedSize, "title");

		System.out.println("productSelectedColor right now is: " + productSelectedColor);

		//PropertiesFile.setProperties("homePageProductSelectedColor", productSelectedColor);
		
		productLinkValue = productLinkValue + "#/size-" + "s" + "/color-" + productSelectedColor;
		
		System.out.println("productLinkValue is updated to: " + productLinkValue);
		
		PropertiesFile.setProperties("homePageProductLink", productLinkValue);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//selenium.clickUsingJS(crossCloseQuickView, driver);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		selenium.pressEscape();
		
		driver.switchTo().defaultContent();

		selenium.performMouseHover(itemContainer, driver);

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

		if (selenium.validateText(textAddedProductTitle, driver, "Blouse")
				&& selenium.validateText(textAddedProductQuantity, driver, "1")
				&& selenium.validateText(textAddedProductPrice, driver, "$27.00")) {
			return true;
		} else {
			return false;
		}

		// return selenium.validateText(textCartQuantity, driver, "1");
	}

	public void navigateToShoppingCartPage(WebDriver driver) {
		selenium.clickUsingJS(btnProceedToCheckout, driver);
		selenium.refresh(driver);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

// productLinkValue was here

	public void closePopupWindow(WebDriver driver) {
		selenium.click(crossCloseMiniBasket);
	}

	public boolean validateProductAddedToCart(WebDriver driver) {
		return selenium.validateText(textCartQuantity, driver, "1");
	}

}
