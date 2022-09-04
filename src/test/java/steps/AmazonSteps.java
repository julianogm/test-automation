package steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonSteps {

	public static WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Given("estou na pagina inicial da amazon")
	public void estou_na_pagina_inicial_da_amazon() {
		String url = "https://www.amazon.com.br/";
		driver.get(url);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("insiro o nome do produto {string} na pesquisa")
	public void insiro_o_nome_do_produto_na_pesquisa(String pesquisa) {
		WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		searchBox.sendKeys(pesquisa);
		Wait(5);
	}

	@When("clico em pesquisar")
	public void clico_em_pesquisar() {
		WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
		searchButton.click();
		Wait(5);
	}

	@When("clico no terceiro produto retornado")
	public void clico_no_terceiro_produto_retornado() {
		List<WebElement> elements = driver
				.findElements(By.xpath("//span[contains(@class,'a-size-base-plus a-color-base a-text-normal')]"));

		/*
		 * for (WebElement element : elements) { System.out.println(element.getText());
		 * }
		 */
		
		// clicar no terceiro item
		elements.get(2).click();
		Wait(5);
	}

	@Then("verifico se o preço do produto é {int} reais")
	public void verifico_se_o_preco_do_produto_é_maior_que_reais(Integer valor) {
		WebElement preco = driver.findElement(By.id("corePriceDisplay_desktop_feature_div"));

		String str = preco.getText();
		str = str.substring(2, str.length()-3);
		str = str.replace(".","");
		Assert.assertEquals(Integer.valueOf(str), valor);
	}

	@After
	public void tearDown() {
		Wait(3);
		driver.quit();
	}

	public static void Wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
