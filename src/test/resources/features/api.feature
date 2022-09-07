Feature: Exemplo requisicao API

  @api
  Scenario Outline: ViaCep
    Given Faco uma requisicao no viacep com o cep <numero>
    Then o codigo de resposta e <status>

	  Examples:
	  | numero | status |
	  | 00010010 | 400 |
	  | 01001000 | 200 |