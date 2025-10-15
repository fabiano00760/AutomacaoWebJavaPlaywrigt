package pages;

import com.microsoft.playwright.Page;
import fabricaDeDriver.DriverFactory;

public class CarrinhoDeCompraPage {

    // XPaths dos elementos na página
    private static final String primeiroProduto = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']";
    private static final String segundoProduto = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']";
    private final String carrinho = "//a[contains(.,'2')]";

    private final Page page;

    // Construtor que injeta a instância da página
    public CarrinhoDeCompraPage() {
        this.page = DriverFactory.getPage();
    }

    // Método genérico para clicar em qualquer produto
    public void adicionarProdutoAoCarrinho(String xpathProduto) {
        page.locator(xpathProduto).click();
    }

    // Métodos específicos para os produtos
    public void primeiroProduto() {
        adicionarProdutoAoCarrinho(primeiroProduto);
    }

    public void segundoProduto() {
        adicionarProdutoAoCarrinho(segundoProduto);
    }

    // Verifica se o carrinho contém a quantidade esperada
    public void conferirCarrinhoComQuantidadeEsperada(String quantidadeEsperada) {
        String texto = page.locator(carrinho).innerText();
        if (!texto.contains(quantidadeEsperada)) {
            throw new AssertionError("O carrinho não contém a quantidade esperada: " + quantidadeEsperada);
        }
    }
}