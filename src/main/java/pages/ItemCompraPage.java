package pages;

import fabricaDeDriver.DriverFactory;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;

import java.util.List;
import static fabricaDeDriver.DriverFactory.getPage;


public class ItemCompraPage {

    static DriverFactory driverFatctory;


    public static void todosProdutosCarrinho() {

        String xpath = "//button[text()='Add to cart']"; // Ou modifique conforme necessário, como por exemplo, "//button[@name='SeuNome']"

        // Buscar todos os botões com o XPath definido
        List<ElementHandle> botoes = getPage().locator(xpath).elementHandles();
        // Iterar sobre os botões encontrados e clicar em cada um
        for (ElementHandle botao : botoes) {
            System.out.println("Clicando no botão: " + botao.textContent());
            botao.click();
            // Aguardar um pequeno tempo, se necessário (opcional)
            getPage().waitForTimeout(500);  // 500ms de espera (ajuste conforme necessário)
        }
    }

    public static void conferirCarinhoComTodosItem(){
        // Verificar se o carrinho contém exatamente 6 itens

        getPage().waitForTimeout(500);
        // Vamos assumir que o carrinho tem um ícone ou uma contagem de itens em um local específico
        String xpathCarrinho = "//span[contains(.,'6')]"; // Ajuste conforme o carrinho
        Locator carrinho = getPage().locator(xpathCarrinho);

        // Esperar até que a contagem do carrinho esteja visível
        carrinho.waitFor(new Locator.WaitForOptions().setTimeout(5000)); // Aguarda até 5 segundos

        // Pegar o texto da quantidade do carrinho
        String quantidadeCarrinhoTexto = carrinho.innerText();
        System.out.println(quantidadeCarrinhoTexto);

        // Verificar se a quantidade do carrinho é igual a 6
        try {
            int quantidadeCarrinho = Integer.parseInt(quantidadeCarrinhoTexto);
            if (quantidadeCarrinho == 6) {
                System.out.println("Carrinho contém exatamente 6 itens.");
                // Clique no botão para finalizar a compra ou outro botão de sua escolha
                getPage().locator(xpathCarrinho).click();  // Clica no botão "Finalizar Compra"
                System.out.println("Cliquei no botão para finalizar a compra.");
            } else {
                System.out.println("Carrinho não contém 6 itens. Contagem atual: " + quantidadeCarrinho);
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro ao verificar a quantidade de itens no carrinho: " + e.getMessage());
        }

    }

    public static void validarListaDeCompra(){
        getPage().waitForTimeout(500);
        // Agora vamos verificar os itens no carrinho
        // Assumindo que o carrinho tem uma lista de itens identificados por um texto
        String xpathCarrinho = "//div[contains(@class,'list')]"; // Ajuste conforme necessário, lista de itens no carrinho
        Locator listaCarrinho = getPage().locator(xpathCarrinho);

        // Esperar até que os itens no carrinho estejam visíveis
        listaCarrinho.waitFor(new Locator.WaitForOptions().setTimeout(5000)); // Aguarda até 5 segundos

        // Obter o texto dos itens no carrinho
        List<String> itensCarrinho = listaCarrinho.allTextContents(); // Retorna uma lista de strings com o conteúdo de cada item

        // Itens esperados no carrinho
        String[] itensEsperados = {"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"};

        // Verificar se todos os itens esperados estão presentes no carrinho
        boolean todosItensPresentes = true;
        for (String itemEsperado : itensEsperados) {
            if (!itensCarrinho.contains(itemEsperado)) {
                System.out.println("Item não encontrado no carrinho: " + itemEsperado);
            }
        }

//        // Se todos os itens estiverem no carrinho, realizar o clique
//        if (todosItensPresentes) {
//            System.out.println("Todos os itens estão no carrinho.");
//
//            // Clique no botão de finalizar compra ou qualquer outra ação que você deseje
//            String xpathFinalizarCompra = "//button[contains(@id,'checkout')]"; // Ajuste conforme o botão
//            getPage().locator(xpathFinalizarCompra).click();  // Clica no botão "Finalizar Compra"
//            System.out.println("Cliquei no botão para finalizar a compra.");
//        } else {
//            System.out.println("Nem todos os itens esperados estão no carrinho.");
//        }
//

    }

    public static void btnFinishEValidoMenssagem(){
        String xpathFinalizarCompra = "//button[@id='finish']"; // Ajuste conforme o botão
        getPage().locator(xpathFinalizarCompra).click();  // Clica no botão "Finalizar Compra"
        String textoEsperado = "Thank you for your order!";  // Modifique conforme necessário

        // Usar o metodo locator para buscar o texto na página
        Locator locatorTexto = getPage().locator("text=" + textoEsperado);

        // Esperar que o texto esteja visível na página
        boolean textoEncontrado = locatorTexto.isVisible();

        // Verificar se o texto está presente
        if (textoEncontrado) {
            System.out.println("Texto encontrado: " + textoEsperado);
            // Aqui você pode adicionar qualquer ação adicional, como clicar em um botão
            // String xpathBotao = "//button[text()='Clique Aqui']";
            // page.locator(xpathBotao).click();
        } else {
            System.out.println("Texto não encontrado: " + textoEsperado);
        }
}

}