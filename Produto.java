import java.math.BigDecimal;

public class Produto {

    private int idProduto;
    private String nomeProduto;
    private BigDecimal preco;
    private int estoque;

    public Produto(int idProduto, String nomeProduto, BigDecimal preco, int estoque) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.estoque = estoque;
    }

    int getIdProduto() {
        return this.idProduto;
    }

    String getNomeProduto() {
        return this.nomeProduto;
    }

    BigDecimal getPreco() {
        return this.preco;
    }

    int getEstoque() {
        return this.estoque;
    }

    public void mostrarProduto() {
        System.out.println("DADOS DO PRODUTO:");
        System.out.println("ID: " + this.idProduto);
        System.out.println("NOME: " + this.nomeProduto);
        System.out.println("PREÇO: " + this.preco);
        System.out.println("ESTOQUE: " + this.estoque);
    }

    public void reduzirEstoque(int quantidade) {

        if (quantidade <= 0) {
            throw new IllegalArgumentException(
                "A quantidade deve ser maior que zero."
            );
        }

        if (quantidade > this.estoque) {
            throw new IllegalArgumentException(
                "Não há estoque suficiente."
            );
        }

        this.estoque = this.estoque - quantidade;
    }
}