package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonPage;

public class AmazonSteps {

	AmazonPage page = new AmazonPage();

	@Given("estou na pagina inicial da amazon")
	public void estou_na_pagina_inicial_da_amazon() {
		page.access_homepage();
	}

	@When("insiro o nome do produto {string} na pesquisa")
	public void insiro_o_nome_do_produto_na_pesquisa(String pesquisa) {
		page.fill_searchbox(pesquisa);
	}

	@When("clico em pesquisar")
	public void clico_em_pesquisar() {
		page.click_search();
	}

	@When("clico no {int}º produto retornado")
	public void clico_no_terceiro_produto_retornado(Integer position) {
		page.click_product(position);
	}

	@Then("verifico se o preço do produto é {int} reais")
	public void verifico_se_o_preco_do_produto_é_maior_que_reais(Integer valor) {
		page.check_price(valor);
	}
}
