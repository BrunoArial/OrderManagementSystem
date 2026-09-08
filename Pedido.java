import java.math.BigDecimal;
import java.util.ArrayList;

public class Pedido {
    Cliente cliente;
    ArrayList<ItemPedido> listaDeItens = new ArrayList<>();
    String idPedido;
    String status;
    String data;

    public Pedido(Cliente cliente, String idPedido, String status, String data) {
        this.cliente = cliente;
        this.idPedido = idPedido;
        this.status = status;
        this.data = data;
    }

    void adicionarItens(ItemPedido item) {
        listaDeItens.add(item);
    }

    int getQuantidadeDeItens() {
        return (listaDeItens.size());
    }

    void mostrarItem() {
        for (ItemPedido item : listaDeItens) {
            item.infoItemPedido(); 
        }
    }

    BigDecimal retornarValorTotal() {
        BigDecimal valorTotal = BigDecimal.ZERO;
        for (ItemPedido item : listaDeItens) {
            valorTotal = valorTotal.add(item.calcularSubtotal());
        }
        return valorTotal;
    }

    void mostrarPedido() {
        System.out.println("ID do pedido: " + this.idPedido);
        System.out.println("Cliente: " + cliente.nome + " (email: " + cliente.email + ")" + " (id: " + cliente.idCliente + ")");
        mostrarItem();
        System.out.println("VALOR TOTAL: " + retornarValorTotal());
    }
}   
    
