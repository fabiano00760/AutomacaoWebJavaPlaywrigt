package pages;

import com.microsoft.playwright.Page;
import fabricaDeDriver.DriverFactory;

public class BasePage {
    protected static Page page;



    // Metodo para iniciar a página usando DriverFactory
    public static void iniciar(){
    DriverFactory.init(); // Inicializa Playwright, navegador e página
        page = DriverFactory.getPage();
    }

    // Metodo para clicar em um elemento
    public void clicar(String locator) {
        page.locator(locator).click();
    }

    // Metodo para preencher um campo de texto
    public void preencher(String locator, String valor) {
        page.locator(locator).fill(valor);
    }

    // Metodo para verificar se um elemento está visível
    public boolean isVisivel(String locator) {
        return page.locator(locator).isVisible();
    }

    // Metodo para obter o texto de um elemento
    public String obterTexto(String locator) {
        return page.locator(locator).textContent();
    }

    // Metodo para esperar que um elemento esteja visível
    public static void esperarVisibilidade(String locator) {
        page.locator(locator).waitFor();
    }





}
