package stepes;

import pages.CarrinhoDeCompraPage;
import io.cucumber.java.en.*;
import static fabricaDeDriver.DriverFactory.screenshotPage;

public class CarrinhoDeCompraStep {

    CarrinhoDeCompraPage carrinhoPage = new CarrinhoDeCompraPage();

    @When("selecionar primeio produto")
    public void selecionar_primeio_produto() {
        carrinhoPage.primeiroProduto();
        screenshotPage("selecionar primeiro produto");
    }

    @And("selecionar segundo produto")
    public void selecionar_segundo_produto() {
        carrinhoPage.segundoProduto();
        screenshotPage("selecionar segundo produto");
    }

    @Then("conferir o carinho com {string} itens")
    public void conferir_o_carinho_com_itens(String string) {
        CarrinhoDeCompraPage carrinhoPage = new CarrinhoDeCompraPage();
        carrinhoPage.conferirCarrinhoComQuantidadeEsperada("2");
        screenshotPage("conferir o carinho");
    }

}