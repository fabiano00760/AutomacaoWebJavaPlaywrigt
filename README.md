# AutomacaoWebJavaPlaywrigt
AutomacaoWebJavaPlaywrigt

Automação Web com Java, Cucumber e Playwright

Este projeto tem como objetivo realizar a automação de testes em uma aplicação web utilizando Java, Cucumber para testes com BDD (Behavior Driven Development) e Playwright para automação da interação com o navegador.

Requisitos
Antes de rodar os testes, você precisa ter os seguintes requisitos instalados na sua máquina:

Java 17 ou superior: Download
Maven: Download
IDE (Recomendado IntelliJ IDEA ou Eclipse)
Playwright: A biblioteca será gerenciada pelo Maven.

Como Rodar o Projeto
Passo 1: Clonar o repositório
Clone o repositório para o seu computador usando o seguinte comando:

git clone git@github.com:fabiano00760/AutomacaoWebJavaPlaywrigt.git

Passo 2: Navegar até a pasta do projeto
Acesse o diretório do projeto:

cd nome-do-repositorio

Passo 3: Construir o projeto
Utilize o Maven para baixar as dependências e construir o projeto:

bash
Copiar código
mvn clean install

Passo 4: Executar os testes
Execute os testes utilizando o seguinte comando Maven:

bash
Copiar código
mvn test

Isso irá rodar os testes definidos no Cucumber. Os resultados serão gerados em um relatório HTML dentro da pasta target/cucumber-reports.

Estrutura do Projeto
A estrutura de diretórios e arquivos está organizada da seguinte maneira:

markdown
Copiar código
- src
  - main
    - java
      - steps                   # Implementação dos steps do Cucumber
        - LoginSteps.java        # Passos do cenário de login
        - CartSteps.java         # Passos do cenário de carrinho
        - CheckoutSteps.java     # Passos do cenário de checkout
      - utils                    # Utilitários (como gerenciador do navegador)
        - BrowserManager.java    # Classe que gerencia o navegador Playwright
    - resources
      - features                 # Arquivos de definição de testes (Cucumber)
        - login.feature          # Cenário de teste de login
        - cart.feature           # Cenário de teste de carrinho
        - checkout.feature       # Cenário de teste de checkout
  - test
    - java
      - runners                  # Classe de configuração para rodar os testes
        - TestRunner.java        # Runner que configura o Cucumber para execução


Claro! Aqui está um modelo de documentação README.md para o seu projeto de automação web com Java, Cucumber e Playwright:

Automação Web com Java, Cucumber e Playwright
Este projeto tem como objetivo realizar a automação de testes em uma aplicação web utilizando Java, Cucumber para testes com BDD (Behavior Driven Development) e Playwright para automação da interação com o navegador.

Requisitos
Antes de rodar os testes, você precisa ter os seguintes requisitos instalados na sua máquina:

Java 17 ou superior: Download
Maven: Download
IDE (Recomendado IntelliJ IDEA ou Eclipse)
Playwright: A biblioteca será gerenciada pelo Maven.
Como Rodar o Projeto
Passo 1: Clonar o repositório
Clone o repositório para o seu computador usando o seguinte comando:

bash
Copiar código
git clone https://github.com/seu-usuario/nome-do-repositorio.git
Passo 2: Navegar até a pasta do projeto
Acesse o diretório do projeto:

bash
Copiar código
cd nome-do-repositorio
Passo 3: Construir o projeto
Utilize o Maven para baixar as dependências e construir o projeto:

bash
Copiar código
mvn clean install
Passo 4: Executar os testes
Execute os testes utilizando o seguinte comando Maven:

bash
Copiar código
mvn test
Isso irá rodar os testes definidos no Cucumber. Os resultados serão gerados em um relatório HTML dentro da pasta target/cucumber-reports.

Estrutura do Projeto
A estrutura de diretórios e arquivos está organizada da seguinte maneira:

markdown
Copiar código
- src
  - main
    - java
      - steps                   # Implementação dos steps do Cucumber
        - LoginSteps.java        # Passos do cenário de login
        - CartSteps.java         # Passos do cenário de carrinho
        - CheckoutSteps.java     # Passos do cenário de checkout
      - utils                    # Utilitários (como gerenciador do navegador)
        - BrowserManager.java    # Classe que gerencia o navegador Playwright
    - resources
      - features                 # Arquivos de definição de testes (Cucumber)
        - login.feature          # Cenário de teste de login
        - cart.feature           # Cenário de teste de carrinho
        - checkout.feature       # Cenário de teste de checkout
  - test
    - java
      - runners                  # Classe de configuração para rodar os testes
        - TestRunner.java        # Runner que configura o Cucumber para execução
Descrição dos Arquivos
1. Arquivos .feature (Gherkin)
login.feature: Contém o cenário para testar o login na aplicação.
cart.feature: Contém o cenário para testar a funcionalidade de adicionar itens ao carrinho.
checkout.feature: Contém o cenário para testar o processo de checkout.
2. Arquivos de Steps (Java)
LoginSteps.java: Contém os passos de automação para o cenário de login.
CartSteps.java: Contém os passos de automação para o cenário de carrinho de compras.
CheckoutSteps.java: Contém os passos de automação para o cenário de checkout.
3. Arquivo de Utilitário
BrowserManager.java: Responsável por configurar o navegador Playwright e fornecer uma instância da página para os testes.
4. Runner do Cucumber
TestRunner.java: Classe principal que configura o Cucumber para rodar os testes. Aqui é onde as configurações do Cucumber (como localização dos arquivos .feature e dos steps) são definidas.

Cenários de Teste
1. Teste de Login
O cenário de login simula o processo de login na página de uma aplicação de exemplo:

gherkin
Copiar código
Scenario: teste de login
  Given que esteja na pagina home "https://www.saucedemo.com"
  When preencho o campo Usuario "standard_user"
  And preencho o campo Senha "secret_sauce"
  And clico no btn Entra
  Then entao login realizado com sucesso
2. Carrinho de Compras
O cenário de carrinho de compras simula a adição de produtos ao carrinho:

gherkin
Copiar código
Scenario: carrinho de compras
  Given que esteja na pagina home "https://www.saucedemo.com"
  When preencho o campo Usuario "standard_user"
  And preencho o campo Senha "secret_sauce"
  And clico no btn Entra
  When selecionar primeiro produto
  And selecionar segundo produto
  Then conferir o carinho
3. Checkout
O cenário de checkout simula a realização de uma compra:

gherkin
Copiar código
Scenario: realizar checkout
  Given que esteja na pagina home "https://www.saucedemo.com"
  When preencho o campo Usuario "standard_user"
  And preencho o campo Senha "secret_sauce"
  And clico no btn Entra
  And que eu esteja na tela YOUR CART
  And clico no btn checkout
  And preencho campo first name "Fabiano"
  And preencho campo last name "silva"
  And preencho o campo postal "04851-689"
  And clico em continue
  And e checo o produto selecionado
  And clico no btn finish
  Then checkout realizado com sucesso

  Resultados dos Testes
Após executar os testes com o comando mvn test, um relatório será gerado em:

bash
Copiar código
target/cucumber-reports/index.html
Você pode abrir este arquivo em um navegador para visualizar os detalhes da execução dos testes, como passos executados e resultados.

Dependências
Este projeto usa as seguintes dependências:

Playwright: Biblioteca para automação de navegação web.
Cucumber: Framework para testes baseados em BDD (Behavior Driven Development).
JUnit: Framework para execução de testes.
Essas dependências estão gerenciadas no arquivo pom.xml do Maven.

Contribuições
Se você deseja contribuir para o projeto, por favor, siga as etapas abaixo:

Faça um fork do projeto.
Crie uma branch para suas modificações (git checkout -b minha-modificacao).
Realize suas alterações e adicione testes, se necessário.
Faça um commit com suas mudanças (git commit -am 'Minha contribuição').
Envie a branch para o repositório remoto (git push origin minha-modificacao).
Crie um Pull Request.

Fabiani De Barros Silva 

