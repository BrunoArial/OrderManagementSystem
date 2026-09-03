import java.math.BigDecimal;

public class Produto {
    private int IdProduto;
    private String NomeProduto;
    private BigDecimal Preco;
    private int Estoque;

    public Produto(int idProduto, String nomeProduto, BigDecimal preco, int estoque) {
        this.IdProduto = idProduto;
        this.NomeProduto = nomeProduto;
        this.Preco = preco;
        this.Estoque = estoque;
    }

    int getIdProduto() {
        return this.IdProduto;
    }

    String getNomeProduto() {
        return this.NomeProduto;
    }

    BigDecimal getPreco() {
        return this.Preco;
    }

    int getEstoque() {
        return this.Estoque;
    }

    String setNomeProduto(String NomeProduto) {
        return this.NomeProduto;
    }

    BigDecimal setPreco(BigDecimal Preco) {
        return this.Preco;
    }

    public void mostrarProduto() {
        System.out.println("DADOS DO PRODUTO:");
        System.out.println("ID: " + this.IdProduto);
        System.out.println("NOME: " + this.NomeProduto);
        System.out.println("PREÇO: " + this.Preco);
        System.out.println("ESTOQUE: " + this.Estoque);
    }

    public void reduzirEstoque(int quantidade) {
        this.Estoque = this.Estoque - quantidade;
        mostrarProduto();
    }
}
