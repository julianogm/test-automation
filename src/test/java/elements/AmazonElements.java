package elements;

import org.openqa.selenium.By;

public abstract class AmazonElements {
	
	private By searchBox = By.xpath("//*[@id=\"twotabsearchtextbox\"]");
	private By searchButton = By.xpath("//*[@id=\"nav-search-submit-button\"]");
	private By productList = By.xpath("//span[contains(@class,'a-size-base-plus a-color-base a-text-normal')]");
	private By price = By.id("corePriceDisplay_desktop_feature_div");
	
	public By getSearchBox() {
		return searchBox;
	}
	
	public By getSearchButton() {
		return searchButton;
	}
	
	public By getProductList() {
		return productList;
	}
	
	public By getPrice() {
		return price;
	}
}
