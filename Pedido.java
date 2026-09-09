import java.math.BigDecimal;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pedido {
    Cliente cliente;
    ArrayList<ItemPedido> listaDeItens = new ArrayList<>();
    String idPedido;
    StatusPedido status;
    LocalDateTime data;

    public Pedido(Cliente cliente, String idPedido, StatusPedido status) {
        this.cliente = cliente;
        this.idPedido = idPedido;
        this.status = status;
        this.data = LocalDateTime.now();
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    void adicionarItens(ItemPedido item) {
        if (this.status != StatusPedido.PENDENTE) {
            throw new IllegalStateException ("Você só pode adicionar itens em pedidos pendentes.");
        }

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
        System.out.println("STATUS: " + this.status);
        
        System.out.println("DATA: " + this.data.format(formatter));
    }

    void confirmarPedido() {
        if (this.status != StatusPedido.PENDENTE) {
            throw new IllegalStateException("Apenas pedidos pendentes podem ser confirmados.");
        }

        this.status = StatusPedido.CONFIRMADO;
    }

    void cancelarPedido() {
        if (this.status == StatusPedido.CANCELADO) {
            throw new IllegalStateException("O pedido já está cancelado.");
        }

        this.status = StatusPedido.CANCELADO;
    }
}   
    
