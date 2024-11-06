package Stepes;

import FabricaDeDriver.DriverFactory;
import Pages.CarrinhoDeCompraPage;
import io.cucumber.java.en.*;
import static FabricaDeDriver.DriverFactory.screenshotPage;

public class CarrinhoDeCompraStepe {

    private CarrinhoDeCompraStepe() {

    }

    static DriverFactory driverFatctory;

    @When("selecionar primeio produto")
    public void selecionar_primeio_produto() {
        CarrinhoDeCompraPage.primeiroProduto();
        screenshotPage("selecionar primeio produto");

    }
    @And("selecionar segundo produto")
    public void selecionar_segundo_produto() {
        CarrinhoDeCompraPage.segundoProduto();
        screenshotPage("selecionar segundo produto");

    }
    @Then("conferir o carinho")
    public void conferir_o_carinho() {
        CarrinhoDeCompraPage.conferirCarinho(driverFatctory.getPage());
        screenshotPage("conferir o carinho");

    }

}
