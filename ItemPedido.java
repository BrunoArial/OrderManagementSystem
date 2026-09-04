import java.math.BigDecimal;

public class ItemPedido {
    Produto produto;
    int quantidadePedido;
    BigDecimal subtotal;

     public ItemPedido (Produto produto, int quantidadePedido) {
        this.produto = produto;
        this.quantidadePedido = quantidadePedido;
    }

    public void infoItemPedido(Produto produto) {
        subtotal = produto.getPreco().multiply(BigDecimal.valueOf(produto.itemPedido.quantidadePedido));
        System.out.println("QUANTIDADE PEDIDO: " + produto.itemPedido.quantidadePedido);
        System.out.println("SUBTOTAL: " +  subtotal);
    }
}
