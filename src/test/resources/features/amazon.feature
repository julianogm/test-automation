Feature: Automação simples
	
	@tag1
  Scenario: Pesquisar e verificar valor de produto
    Given estou na pagina inicial da amazon
    When insiro o nome do produto "mesa" na pesquisa
    And clico em pesquisar
    And clico no terceiro produto retornado
    Then verifico se o preço do produto é 8769 reais
