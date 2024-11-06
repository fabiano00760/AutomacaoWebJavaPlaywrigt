package Pages;

import FabricaDeDriver.DriverFactory;
import com.microsoft.playwright.Page;

import static Pages.CheckoutPage.driverFatctory;

public class LoginPage {

    private Page page;

    public LoginPage() {
        page = DriverFactory.getPage();
    }

    public void navigateToHomePage(String url) {
        page.navigate(url);
    }

    public void enterUsername(String username) {
        page.fill("//input[@id='user-name']", username);
    }

    public void enterPassword(String password) {
        page.fill("//input[@id='password']", password);
    }

    public void clickLoginButton() {
        page.click("//input[@id='login-button']");
    }

    public boolean getLoggedUserProduto() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String productsText = DriverFactory.getPage().textContent("//span[contains(.,'Products')]");
        return productsText.contains("Products");
    }
}
