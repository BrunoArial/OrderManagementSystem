import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Produto {
    ItemPedido itemPedido = new ItemPedido(null, 0);
    private int idProduto;
    private String nomeProduto;
    private BigDecimal preco;
    private int estoque;

    public Produto(int idProduto, String nomeProduto, BigDecimal preco, int estoque) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.estoque = estoque;
    }

    int getIdProduto() {
        return this.idProduto;
    }

    String getNomeProduto() {
        return this.nomeProduto;
    }

    BigDecimal getPreco() {
        return this.preco;
    }

    int getEstoque() {
        return this.estoque;
    }

    public void mostrarProduto() {
        System.out.println("DADOS DO PRODUTO:");
        System.out.println("ID: " + this.idProduto);
        System.out.println("NOME: " + this.nomeProduto);
        System.out.println("PREÇO: " + this.preco);
        System.out.println("ESTOQUE: " + this.estoque);
    }

    public void reduzirEstoque(int quantidade) {
        this.estoque = this.estoque - quantidade;
        mostrarProduto();
    }

    public void verificarQuantidadeProduto(boolean deuErro) {
        Scanner scanner = new Scanner(System.in);
        do {
        deuErro = false;
            try {
                System.out.println("ESTOQUE DISPONÍVEL: " + this.estoque);
                System.out.print("Digite a quantidade de produtos pedido: ");
                itemPedido.quantidadePedido = scanner.nextInt();
                System.out.println();

                if (itemPedido.quantidadePedido > this.estoque) {
                    System.out.printf("Erro: quantidade (%d) > estoque (%d), digite novamente\n", itemPedido.quantidadePedido, this.estoque);
                }
                else if (itemPedido.quantidadePedido <= 0) {
                    System.out.printf("Erro: quantidade (%d) <= 0, digite novamente\n", itemPedido.quantidadePedido);   
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Você deve digitar um número inteiro!\n");
                deuErro = true;

                scanner.nextLine();
            }
        }while(itemPedido.quantidadePedido > this.estoque || itemPedido.quantidadePedido <= 0 || deuErro);

        reduzirEstoque(itemPedido.quantidadePedido);
        System.out.println("Estoque restante: " + this.getEstoque());
        scanner.close();
    }
}
