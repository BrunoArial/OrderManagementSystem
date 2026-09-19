import java.math.BigDecimal;

public class ItemPedido {
    Produto produto;
    private int quantidadePedido;

    public ItemPedido(Produto produto, int quantidadePedido) {
        this.produto = produto;
        this.quantidadePedido = quantidadePedido;
    }

    public BigDecimal calcularSubtotal() {
        return produto.getPreco().multiply(BigDecimal.valueOf(quantidadePedido));
    }
    
    Produto getProduto() {
        return this.produto;
    }

    int getQuantidadePedido() {
        return this.quantidadePedido;
    }

    void setQuantidadePedido(int quantidadePedido) {
        this.quantidadePedido = quantidadePedido;
    }

    public void infoItemPedido() {

        System.out.println("PRODUTO: " + produto.getNomeProduto());
        System.out.println("QUANTIDADE: " + quantidadePedido);
        System.out.println("SUBTOTAL: " + calcularSubtotal());
    }

    public void adicionarQuantidade(int quantidadePedidoADD) {
        this.quantidadePedido += quantidadePedidoADD;
    }
}