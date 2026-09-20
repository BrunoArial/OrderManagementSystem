public class Cliente {
    private String nome;
    private String email;
    private int idCliente;


    public Cliente(String nome, String email, int idCliente) {
        this.nome = nome;
        this.email = email;
        this.idCliente = idCliente;
    }

    String getNome() {
        return this.nome;
    }

    String getEmail() {
        return this.email;
    }

    int getIdCliente() {
        return this.idCliente;
    }
}
