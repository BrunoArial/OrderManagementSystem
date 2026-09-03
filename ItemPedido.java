import java.math.BigDecimal;

public class ItemPedido {
    Produto produto;
    int quantidadePedido;
    BigDecimal subtotal;

     public ItemPedido (Produto produto) {
        this.produto = produto;
    }

    public void infoItemPedido(int quantidade) {
        quantidadePedido = quantidade;
        subtotal = produto.getPreco().multiply(BigDecimal.valueOf(quantidadePedido));

        System.out.println(quantidadePedido);
        System.out.println(subtotal);
    }
}
