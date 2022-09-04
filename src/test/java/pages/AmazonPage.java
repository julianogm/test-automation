package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import drivers.DriverWeb;
import elements.AmazonElements;
import interactions.Interactions;

public class AmazonPage extends AmazonElements implements Interactions {

	public void access_homepage() {
		String url = "https://www.amazon.com.br/";
		DriverWeb.getDriver().get(url);
		DriverWeb.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void fill_searchbox(String object_name) {
		WebElement searchBox = DriverWeb.getDriver().findElement(getSearchBox());
		fill_form(searchBox, object_name);
		waitLoad(3);
	}

	public void click_search() {
		WebElement searchButton = DriverWeb.getDriver().findElement(getSearchButton());
		click(searchButton);
		waitLoad(3);
	}

	public void click_product(Integer position) {
		List<WebElement> productList = DriverWeb.getDriver().findElements(getProductList());
		
		// clicar no item na posicao desejada
		click(productList.get(position-1));
		waitLoad(3);
	}
	
	public void check_price(Integer price) {
		WebElement priceAmazon = DriverWeb.getDriver().findElement(By.id("corePriceDisplay_desktop_feature_div"));

		String value = priceAmazon.getText();
		value = value.substring(2, value.length()-3);
		value = value.replace(".","");
		
		Assert.assertEquals(Integer.valueOf(value), price);
	}
}
