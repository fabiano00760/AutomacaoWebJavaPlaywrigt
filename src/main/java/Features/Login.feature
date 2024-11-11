@WEB

Feature: Automatic WEB

  @Login
  Scenario: teste de login
    Given que esteja na pagina home "https://www.saucedemo.com"
    When preencho o campo Usuario "standard_user"
    And preencho o campo Senha "secret_sauce"
    And clico no btn Entra
    Then entao login realizado com sucesso

  @Compras
  Scenario: carrinho de compras
    Given que esteja na pagina home "https://www.saucedemo.com"
    When preencho o campo Usuario "standard_user"
    And preencho o campo Senha "secret_sauce"
    And clico no btn Entra
    When selecionar primeio produto
    And selecionar segundo produto
    Then conferir o carinho


  @checkout
  Scenario: realizar checkout
    Given que esteja na pagina home "https://www.saucedemo.com"
    When preencho o campo Usuario "standard_user"
    And preencho o campo Senha "secret_sauce"
    And clico no btn Entra
    And que eu esteja na tela YOUR CART
    And clico no btn checkout
    And preencho campo first name "Fabiano"
    And preencho campo last name  "silva"
    And preencho o campo postal "04851-689"
    And clico em continue
    And e checo o produto selecionado
    And clico no btn finish
    Then checkout realizado com sucesso

  @intemCompras
  Scenario: carrinho de compras
    Given que esteja na pagina home "https://www.saucedemo.com"
    When preencho o campo Usuario "standard_user"
    And preencho o campo Senha "secret_sauce"
    And clico no btn Entra
    When selecionar todos os produtos de na page
    And conferir o carinho com todos os items
    And clico no btn checkout
    And preencho campo first name "Fabiano"
    And preencho campo last name  "silva"
    And preencho o campo postal "04851-689"
    And clico em continue
    And valido lista de compra
    Then  clico no btn finish e valido  Thank you for your order!
