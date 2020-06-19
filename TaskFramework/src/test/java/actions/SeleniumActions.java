package actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumActions {
	
	Actions action;
	
	public void clear(WebElement element) {
		element.clear();
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void clickUsingJS(WebElement element, WebDriver driver) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public String getAttribute(WebElement element, String attribute) {
		String attributeValue = null;
		attributeValue = element.getAttribute(attribute);
		return attributeValue;
	}
	
	public String getSelectedDropDownValue(WebElement selectOption) {
		Select s = new Select(selectOption);
		WebElement option = s.getFirstSelectedOption();
		String selectedOption = option.getText();
		return selectedOption;
	}
	
	public void performMouseHover(WebElement element, WebDriver driver) {
		action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void scrollToContent(int x, int y, WebDriver driver) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("scrollBy(" + x + ", " + y + ")");
	}
	
	public void pressEscape() {
		action.sendKeys(Keys.ESCAPE).build().perform();
	}
	
	public void setDropDown(WebElement selectOption, String text) {
		Select s = new Select(selectOption);
		s.selectByVisibleText(text);
	}
	
	public void setText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public boolean validateText(WebElement element, WebDriver driver, String expectedText) {
		String text = element.getText();
		if(text.equals(expectedText)) {
			return true;
		}
		return false;
	}
	
	public boolean validateUrl(String url, WebDriver driver, String expectedUrl) {
		if(url.equals(expectedUrl)) {
			return true;
		}
		return false;
	}

}
