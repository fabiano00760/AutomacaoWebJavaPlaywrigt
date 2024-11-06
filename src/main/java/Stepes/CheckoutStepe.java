package Stepes;
import FabricaDeDriver.DriverFactory;
import io.cucumber.java.en.*;
import Pages.CheckoutPage;
import static FabricaDeDriver.DriverFactory.screenshotPage;

public class CheckoutStepe {

    static DriverFactory driverFatctory;

    @Given("que eu esteja na tela YOUR CART")
    public void que_eu_esteja_na_tela_your_cart() {
        CheckoutPage.telaYourCart();
        screenshotPage("que eu esteja na tela YOUR CART");

    }

    @When("clico no btn checkout")
    public void clico_no_btn_checkout() {
        CheckoutPage.btnCheckout();
        screenshotPage("clico no btn checkou");

    }

    @And("preencho campo first name {string}")
    public void preencho_campo_first_name(String nome) {
        CheckoutPage.campoNome(nome);
        screenshotPage("preencho campo first name");

    }

    @And("preencho campo last name  {string}")
    public void preencho_campo_last_name(String sobreNome) {
        CheckoutPage.campoSobreNome(sobreNome);
        screenshotPage("preencho campo last name");


    }

    @And("preencho o campo postal {string}")
    public void preencho_o_campo_postal(String cep) {
        CheckoutPage.CaixaPostal(cep);
        screenshotPage("preencho campo last name");


    }

    @And("clico em continue")
    public void clico_em_continue() {
        CheckoutPage.btnContinuar();
        screenshotPage("clico em continue");

    }

    @And("e checo o produto selecionado")
    public void e_checo_o_produto_selecionado() {
        CheckoutPage.checarProduto(driverFatctory.getPage());
        screenshotPage("e checo o produto selecionado");

    }

    @And("clico no btn finish")
    public void clico_no_btn_finish() {
        CheckoutPage.btnFinish();
        screenshotPage("clico no btn finis");


    }

    @Then("checkout realizado com sucesso")
    public void checkout_realizado_com_sucesso() {
        CheckoutPage.chechoutCompleto(driverFatctory.getPage());
        screenshotPage("checkout realizado com sucesso");

    }

}
