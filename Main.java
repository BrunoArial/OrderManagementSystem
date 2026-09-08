import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        Cliente cliente = new Cliente(
            "Bruno", 
            "brunoarial@gmail.com", 
            1
        ); 

        Pedido pedido = new Pedido(
            cliente,
            "P001", 
            "Em andamento", 
            "09/09/2026"
        );

        Produto produto1 = new Produto(
                1,
                "Produto A",
                new BigDecimal("19.99"),
                10
        );
        Produto produto2 = new Produto(
                2,
                "Produto B",
                new BigDecimal("50.00"),
                15
        );

        produto1.mostrarProduto();
        produto2.mostrarProduto();
        Produto[] produtos = {produto1, produto2};
        boolean quantidadeValida = false;
        for (Produto produto : produtos) {
            quantidadeValida = false;
            while (!quantidadeValida) {
                try {

                    System.out.println();
                    System.out.println("ESTOQUE DISPONÍVEL: " + produto.getEstoque());
                    System.out.print("Digite a quantidade desejada: ");

                    int quantidade = scanner.nextInt();
                    produto.reduzirEstoque(quantidade);

                    ItemPedido itemPedido = new ItemPedido(produto, quantidade);
                    itemPedido.infoItemPedido();
                    pedido.adicionarItens(itemPedido);

                    quantidadeValida = true;

                } catch (InputMismatchException e) {

                    System.out.println("Digite um número inteiro.");

                    scanner.nextLine();

                } catch (IllegalArgumentException e) {

                    System.out.println("Erro: " + e.getMessage());
                }
            }
        }

        
        System.out.println();
        System.out.println("Estoque restante: " + produto1.getEstoque());
        System.out.println("Estoque restante: " + produto2.getEstoque());

        System.out.println("QUANTIDADE DE ITENS NO PEDIDO: " + pedido.getQuantidadeDeItens());

        pedido.mostrarItem();
        System.out.println("VALOR TOTAL DO PEDIDO: " + pedido.retornarValorTotal());
        System.out.println();
        pedido.mostrarPedido();
        scanner.close();
    }
}