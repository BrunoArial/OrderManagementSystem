import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class ProdutoTest {

    @Test
    void deveReduzirEstoque() {

        Produto produto = new Produto(
            1,
            "Produto Teste",
            new BigDecimal("10.00"),
            10
        );

        produto.reduzirEstoque(3);

        assertEquals(7, produto.getEstoque());
    }
}