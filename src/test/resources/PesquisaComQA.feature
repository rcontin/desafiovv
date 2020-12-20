Feature: PesquisaComQA

  Scenario: Preencher pesquisa com dados obrigatorios validos
    Given que eu acesse a pagina da VV Test 
    And acesse o menu Pesquisa - QA
    When eu preencher todos os campos obrigatorios
    Then deve ser direcionado para uma pagina de sucesso
