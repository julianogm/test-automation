package interactions;

import org.openqa.selenium.WebElement;

public interface Interactions {
	default void waitLoad(Integer seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	default void click(WebElement element) {
		waitLoad(1);
		element.click();
	}
	
	default void fill_form(WebElement element, String text) {
		waitLoad(1);
		element.sendKeys(text);
	}
}
