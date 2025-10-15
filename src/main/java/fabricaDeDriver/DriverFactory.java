package fabricaDeDriver;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DriverFactory {

    private static Browser browser;
    private static Page page;
    private static Page.ScreenshotOptions screenshotOptions;
    private static Playwright playwright;

    @Before
    public static void init() {
        try {
            // Inicializando o Playwright e configurando o navegador
            playwright = Playwright.create();
            setDriverOptions();
            setBrowser();
            setPage();
            setScreenshotOptions();
        } catch (Exception e) {
            System.err.println("Erro ao inicializar o Playwright: " + e.getMessage());
            e.printStackTrace(); // Opcional: imprime o stack trace completo
        }

    }


    @BeforeEach
    public void resetPage() {
        // Garantir que uma nova página seja criada antes de cada teste
        if (page != null) {
            page.close();
        }
        setPage();
    }

    @After
    public static void close() {
        // Fechar o navegador de forma adequada
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

    // Configurações do navegador
    private static void setDriverOptions() {
        // Opções para o navegador, como o modo 'headless' e outras configurações
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(false) // Defina como 'true' para execução sem interface gráfica
                .setSlowMo(700);

    }

    private static void setBrowser() {
        // Inicializa o navegador com as opções definidas
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    private static void setPage() {
        // Cria uma nova página no navegador
        page = browser.newPage();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(false) // Defina como 'true' para execução sem interface gráfica
                .setSlowMo(700);
    }

    private static void setScreenshotOptions() {
        // Define as opções de captura de tela (full page, etc.)
        screenshotOptions = new Page.ScreenshotOptions().setFullPage(true);
    }

    // Metodos getter para acessar as instâncias de Browser e Page
    public static Browser getBrowser() {
        return browser;
    }

    public static Page getPage() {
        return page;
    }

    // Método para fazer capturas de tela
    public static void screenshotPage(String stepName) {
        String fileName = generateScreenshotFileName(stepName);
        screenshotOptions.setPath(Paths.get(fileName));
        page.screenshot(screenshotOptions);
    }

    // Gera o nome do arquivo para a captura de tela
    private static String generateScreenshotFileName(String stepName) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy-HH-mm-ss");
        String timestamp = LocalDateTime.now().format(formatter);
        return String.format("evidence/%s-%s.png", stepName, timestamp);
    }




}
