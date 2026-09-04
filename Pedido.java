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
}   
