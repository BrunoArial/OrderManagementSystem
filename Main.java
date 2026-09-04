import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Produto produto = new Produto(
                1,
                "Produto A",
                new BigDecimal("19.99"),
                10
        );

        produto.mostrarProduto();

        int quantidade = 0;
        boolean quantidadeValida = false;

        while (!quantidadeValida) {

            try {

                System.out.println();
                System.out.println("ESTOQUE DISPONÍVEL: " + produto.getEstoque());
                System.out.print("Digite a quantidade desejada: ");

                quantidade = scanner.nextInt();

                produto.reduzirEstoque(quantidade);

                quantidadeValida = true;

            } catch (InputMismatchException e) {

                System.out.println("Digite um número inteiro.");

                scanner.nextLine();

            } catch (IllegalArgumentException e) {

                System.out.println("Erro: " + e.getMessage());
            }
        }

        System.out.println();
        System.out.println("Estoque restante: " + produto.getEstoque());

        scanner.close();
    }
}