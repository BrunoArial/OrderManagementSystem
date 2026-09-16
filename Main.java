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
            StatusPedido.PENDENTE
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

        Produto[] produtos = {produto1, produto2};

        adicionarProdutosAoPedido(scanner, pedido, produtos);

        pedido.mostrarPedido();

        System.out.println();
        System.out.println("1 - Confirmar pedido");
        System.out.println("2 - Cancelar pedido");

        int opcao = 0;

        do {
            System.out.print("Escolha uma opção: ");

        try {
            opcao = scanner.nextInt();

            if (opcao != 1 && opcao != 2) {
                System.out.println("Opção inválida.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Digite um número inteiro.");
            scanner.nextLine();
            opcao = 0;
        }

        } while (opcao != 1 && opcao != 2);

        if (opcao == 1) {
            pedido.confirmarPedido();
            pedido.mostrarPedido();
        } 
        else {
            pedido.cancelarPedido();
            pedido.mostrarPedido();
        }
            
        scanner.close();
    }

    static void adicionarProdutosAoPedido(Scanner scanner, Pedido pedido, Produto[] produtos) {

    for (Produto produto : produtos) {

        boolean quantidadeValida = false;
        char resposta;

        System.out.println();
        produto.mostrarProduto();

        do {
            System.out.println("Deseja adicionar ao pedido? (s/n)");
            resposta = scanner.next().charAt(0);

            if (resposta != 's' && resposta != 'S'
                    && resposta != 'n' && resposta != 'N') {

                System.out.println("Digite apenas S ou N.");
            }

        } while (resposta != 's' && resposta != 'S'
                && resposta != 'n' && resposta != 'N');

        if (resposta == 'n' || resposta == 'N') {
            continue;
        }

        while (!quantidadeValida) {

            try {
                System.out.print("Digite a quantidade desejada: ");
                int quantidade = scanner.nextInt();

                ItemPedido itemPedido =
                        new ItemPedido(produto, quantidade);

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
}
    }
