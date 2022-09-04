@PesquisaValor
Feature: Automação simples

  @PesquisaMesa
  Scenario: Pesquisar e verificar valor de mesa
    Given estou na pagina inicial da amazon
    When insiro o nome do produto "mesa" na pesquisa
    And clico em pesquisar
    And clico no 3º produto retornado
    Then verifico se o preço do produto é 8769 reais

  @PesquisaNotebook
  Scenario: Pesquisar e verificar valor de notebook
    Given estou na pagina inicial da amazon
    When insiro o nome do produto "notebook" na pesquisa
    And clico em pesquisar
    And clico no 1º produto retornado
    Then verifico se o preço do produto é 3275 reais
