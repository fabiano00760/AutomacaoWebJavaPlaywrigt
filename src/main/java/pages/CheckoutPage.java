package pages;

import fabricaDeDriver.DriverFactory;
import com.microsoft.playwright.Page;

public class CheckoutPage {

   static DriverFactory driverFatctory;

    public static void telaYourCart() {
        driverFatctory.getPage().click("//a[@class='shopping_cart_link']");
    }

    public static void btnCheckout() {
        driverFatctory.getPage().click("//button[contains(@id,'checkout')]");
    }//button[contains(@id,'checkout')]

    public static void campoNome(String Nome) {
      driverFatctory.getPage().fill("//input[@id='first-name']", Nome);

    }

    public static void campoSobreNome(String Sobrenome) {
       driverFatctory.getPage().fill("//input[@id='last-name']", Sobrenome);

    }

    public static void CaixaPostal(String cep) {
       driverFatctory.getPage().fill("//input[@id='postal-code']", cep);

    }

    public static void btnContinuar() {
       driverFatctory.getPage().click("//input[@id='continue']");
    }


    public static void checarProduto(Page page) {
        String textoElemento = page.locator("//span[@class='title'][contains(.,'Checkout: Overview')]").innerText();

        if (!textoElemento.contains("Checkout: Overview")) {
            throw new AssertionError("A página não contém o texto esperado: 'CHECKOUT: OVERVIEW'.");
        }
    }
    public static void btnFinish() {
       driverFatctory.getPage().click("//button[@id='finish']");
    }

    public static void chechoutCompleto(Page page) {
        String textoElemento = page.locator("//h2[contains(.,'Thank you for your order!')]").innerText();
        if (!textoElemento.contains("Thank you for your order!")) {
            throw new AssertionError("A página não contém o texto esperado:THANK YOU FOR YOUR ORDER");
        }

    }

}
