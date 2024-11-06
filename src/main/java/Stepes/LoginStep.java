package Stepes;

import FabricaDeDriver.DriverFactory;
import Pages.LoginPage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

import static FabricaDeDriver.DriverFactory.screenshotPage;


public class LoginStep {

    static DriverFactory driverFatctory;

    Pages.LoginPage LoginPage;

    public LoginStep(Pages.LoginPage loginPage) {
        LoginPage = loginPage;
    }


    @Given("que esteja na pagina home {string}")
    public void que_esteja_na_pagina_home(String url) {
        LoginPage.navigateToHomePage(url);
        System.out.println("Navegador aberto na URL: " + url);
        screenshotPage("que esteja na pagina home ");

    }

    @When("preencho o campo Usuario {string}")
    public void preencho_o_campo_usuario(String usuario) {
        LoginPage.enterUsername(usuario);
        System.out.println("Campo de usuário preenchido com: " + usuario);
        screenshotPage("preencho o campo Usuario ");
    }

    @And("preencho o campo Senha {string}")
    public void preencho_o_campo_senha(String senha) {
        LoginPage.enterPassword(senha);
        System.out.println("Campo de senha preenchido.");
        screenshotPage("preencho o campo Senha ");
    }

    @And("clico no btn Entra")
    public void clico_no_btn_entra() {
        LoginPage.clickLoginButton();
        System.out.println("Botão de login clicado.");
        screenshotPage("clico no btn Entra ");

    }

    @Then("entao login realizado com sucesso")
    public void entao_login_realizado_com_sucesso() {
        boolean isLoggedIn = LoginPage.getLoggedUserProduto();

    }
}