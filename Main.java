import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cliente cliente = new Cliente("Bruno", "brunoarial@gmail.com", 1);
        Pedido pedido = new Pedido(cliente, "P001", "Item 1, Item 2", "Em andamento", "2023-10-01");
        Produto produto = new Produto(1, "Produto A", new BigDecimal("19.99"), 10);
        ItemPedido itemPedido = new ItemPedido(produto, 0);
        boolean deuErro = false;
        
        cliente.mostrarCliente();

        System.out.println();

        pedido.mostrarPedido();

        System.out.println();

        produto.mostrarProduto();

        System.out.println();

        produto.verificarQuantidadeProduto(deuErro);

        System.out.println(produto.itemPedido.quantidadePedido);

        System.out.println();

        itemPedido.infoItemPedido(produto);

        
        scanner.close();
    }
}
