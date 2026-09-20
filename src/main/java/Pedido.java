import java.math.BigDecimal;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

    public class Pedido {
        private Cliente cliente;
        private ArrayList<ItemPedido> listaDeItens = new ArrayList<>();
        private String idPedido;
        private StatusPedido status;
        private LocalDateTime data;

        public Pedido(Cliente cliente, String idPedido, StatusPedido status) {
            this.cliente = cliente;
            this.idPedido = idPedido;
            this.status = status;
            this.data = LocalDateTime.now();
        }
        private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        StatusPedido getStatus() {
            return this.status;
        }

        void adicionarItens(ItemPedido item) {
            if (this.status != StatusPedido.PENDENTE) {
                throw new IllegalStateException ("Você só pode adicionar itens em pedidos pendentes.");
            }

            item.getProduto().reduzirEstoque(item.getQuantidadePedido());

            listaDeItens.add(item);
        }

        void removerItens(ItemPedido item) {
            if (this.status != StatusPedido.PENDENTE) {
                throw new IllegalStateException ("Você só pode remover itens em pedidos pendentes.");
            }

            boolean removido = listaDeItens.remove(item);

            if (removido) {
                item.getProduto().aumentarEstoque(item.getQuantidadePedido());
            }
            else {
                throw new IllegalArgumentException("O item não pertence a este pedido."); 
            }
        }

        void removerItensPorIDProduto (int idProdutoREM) {
            ItemPedido itemEncontrado = null;

            for (ItemPedido item : listaDeItens) {
                if(item.getProduto().getIdProduto() == idProdutoREM) {
                    itemEncontrado = item;
                    break;
                }
            }

            if (itemEncontrado == null) {
                throw new IllegalArgumentException("O produto não pertence a este pedido.");
            }

            removerItens(itemEncontrado);
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
            System.out.println("Cliente: " + cliente.getNome() + " (email: " + cliente.getEmail() + ")" + " (id: " + cliente.getIdCliente() + ")");
            mostrarItem();
            System.out.println("VALOR TOTAL: " + retornarValorTotal());
            System.out.println("STATUS: " + this.status);
            
            System.out.println("DATA E HORÁRIO: " + this.data.format(formatter));
        }

        void confirmarPedido() {
            if (this.status != StatusPedido.PENDENTE) {
                throw new IllegalStateException("Apenas pedidos pendentes podem ser confirmados.");
            }
            if (this.listaDeItens.isEmpty()) {
                throw new IllegalStateException("Não é possível confirmar um pedido sem itens.");
            }
            this.status = StatusPedido.CONFIRMADO;
        }

        void cancelarPedido() {
            if (this.status == StatusPedido.CANCELADO) {
                throw new IllegalStateException("O pedido já está cancelado.");
            }

            for (ItemPedido item : listaDeItens) {
                item.getProduto().aumentarEstoque(item.getQuantidadePedido());
            }

            this.status = StatusPedido.CANCELADO;
        }
    }   
        
