public class Pedido {
    Cliente cliente;
    String idPedido;
    String listaDeItens;
    String status;
    String data;

    public Pedido(Cliente cliente, String idPedido, String listaDeItens, String status, String data) {
        this.cliente = cliente;
        this.idPedido = idPedido;
        this.listaDeItens = listaDeItens;
        this.status = status;
        this.data = data;
    }

    void mostrarPedido() {
        System.out.println("DADOS DO PEDIDO:");
        System.out.println("NOME: " + this.cliente.nome);
        System.out.println("EMAIL: " + this.cliente.email);
        System.out.println("ID CLIENTE: " + this.cliente.idCliente);
        System.out.println("ID PEDIDO: " + this.idPedido);
        System.out.println("LISTA DE ITENS: " + this.listaDeItens);
        System.out.println("STATUS: " + this.status);
        System.out.println("DATA: " + this.data);
    }
}   
