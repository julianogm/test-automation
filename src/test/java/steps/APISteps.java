package steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APISteps {

	private Response response;

	@Given("Faco uma requisicao no viacep com o cep {int}")
	public void faço_uma_requisição_no_viacep_com_o_cep(Integer cep) {
		RestAssured.baseURI = "https://viacep.com.br/ws/" + cep + "/json/";
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");
		response = request.get();
	}

	@Then("o codigo de resposta e {int}")
	public void o_código_de_resposta_é(int status) {
		Assert.assertEquals(status, response.getStatusCode());
	}
}
