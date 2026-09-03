import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new Cliente("Bruno", "brunoarial@gmail.com", 1);
        Pedido pedido = new Pedido(cliente, "P001", "Item 1, Item 2", "Em andamento", "2023-10-01");
        Produto produto = new Produto(1, "Produto A", new BigDecimal("19.99"), 10);
        boolean deuErro = false;
        int quantidade = 0;
        
        cliente.mostrarCliente();
        System.out.println();
        pedido.mostrarPedido();
        System.out.println();
        produto.mostrarProduto();
        System.out.println();

        do {
            deuErro = false;
            try {
                System.out.println("ESTOQUE DISPONÍVEL: " + produto.getEstoque());
                System.out.print("Digite a quantidade de produtos pedido: ");
                quantidade = scanner.nextInt();
                System.out.println();

                if (quantidade > produto.getEstoque()) {
                    System.out.printf("Erro: quantidade (%d) > estoque (%d), digite novamente\n", quantidade, produto.getEstoque());
                }
                else if (quantidade <= 0) {
                    System.out.printf("Erro: quantidade (%d) <= 0, digite novamente\n", quantidade);   
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Você deve digitar um número inteiro!\n");
                deuErro = true;

                scanner.nextLine();
            }
            catch (Exception e) {
                System.out.println("Ocorreu um erro desconhecido e inesperado!\n");
                deuErro = true;

                scanner.nextLine();
            }
        }while(quantidade > produto.getEstoque() || quantidade <= 0 || deuErro == true);

        System.out.println("Estoque restante: " + produto.getEstoque());
        produto.reduzirEstoque(quantidade);
        
        System.out.println();

        scanner.close();
    }
}
