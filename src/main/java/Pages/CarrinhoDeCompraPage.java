package Pages;
import FabricaDeDriver.DriverFactory;
import com.microsoft.playwright.Page;

public class CarrinhoDeCompraPage {

    static DriverFactory driverFatctory;

    public static void primeiroProduto() {
        driverFatctory.getPage().click("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']");
    }

    public  static void segundoProduto() {
        driverFatctory.getPage().click("//button[@id='add-to-cart-sauce-labs-fleece-jacket']");
    }

    public  static void conferirCarinho(Page page) {
        String textoElemento = page.locator("//a[contains(.,'2')]").innerText();
        if (!textoElemento.contains("2")) {
            throw new AssertionError("O carrinho não contém a quantidade esperada.");
        }
    }

}
