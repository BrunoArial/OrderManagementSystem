import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class PedidoTest {
    
    @Test
    void deveReduzirEstoque() {

        Cliente cliente = new Cliente(
            "Cliente Teste", 
            "cliente@gmail.com", 
            1
        );

        Pedido pedido = new Pedido(
            cliente, 
            "P001", 
            StatusPedido.PENDENTE
        );

        Produto produto = new Produto(
            1, 
            "Produto Teste", 
            new BigDecimal("10.00"), 
            10
        );

        ItemPedido itemPedido = new ItemPedido(
            produto, 
            3
        );

        pedido.adicionarItens(itemPedido);

        assertEquals(7, produto.getEstoque());
    }

    @Test
    void deveRestaurarEstoqueAoRemoverItem() {
        Cliente cliente = new Cliente(
            "Cliente Teste", 
            "cliente@gmail.com", 
            1
        );

        Pedido pedido = new Pedido(
            cliente,
            "P001", 
            StatusPedido.PENDENTE
        );

        Produto produto = new Produto(
            1, 
            "Produto Teste", 
            new BigDecimal("10.00"), 
            10
        );

        ItemPedido itemPedido = new ItemPedido(
            produto, 
            5
        );

        pedido.adicionarItens(itemPedido);
        pedido.removerItens(itemPedido);

        assertEquals(10, produto.getEstoque());
    }

    // Confirmar um pedido pendente com itens deve mudar o status para CONFIRMADO
    @Test
    void deveConfirmarPedidoPendenteComItens() {
        Cliente cliente = new Cliente(
            "Cliente Teste", 
            "cliente@gmail.com", 
            1
        );

        Pedido pedido = new Pedido(
            cliente,
            "P001", 
            StatusPedido.PENDENTE
        );

        Produto produto = new Produto(
            1, 
            "Produto Teste", 
            new BigDecimal("10.00"), 
            10
        );

        ItemPedido itemPedido = new ItemPedido(
            produto, 
            5
        );

        pedido.adicionarItens(itemPedido);
        pedido.confirmarPedido();

        assertEquals(StatusPedido.CONFIRMADO, pedido.getStatus());
    }
}
