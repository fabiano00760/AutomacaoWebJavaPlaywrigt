package Stepes;

import Pages.ItemCompraPage;
import io.cucumber.java.en.*;

import static FabricaDeDriver.DriverFactory.screenshotPage;

public class ItemComprasStep {


    @When("selecionar todos os produtos de na page")
    public void selecionar_todos_os_produtos_de_na_page() {
        ItemCompraPage.todosProdutosCarrinho();
        screenshotPage("selecionar todos os produtos de na page");
    }
    @When("conferir o carinho com todos os items")
    public void conferir_o_carinho_com_todos_os_items() {
        ItemCompraPage.conferirCarinhoComTodosItem();
        screenshotPage("conferir o carinho com todos os items");
    }
    @When("valido lista de compra")
    public void valido_lista_de_compra() {
        ItemCompraPage.validarListaDeCompra();
        screenshotPage("valido lista de compra");
    }
    @Then("clico no btn finish e valido  Thank you for your order!")
    public void clico_no_btn_finish_e_valido_thank_you_for_your_order() {
        ItemCompraPage.btnFinishEValidoMenssagem();
        screenshotPage("clico no btn finish e valido  Thank you for your order!");
    }

}
