public class Cliente {
    String nome;
    String email;
    int idCliente;


    public Cliente(String nome, String email, int idCliente) {
        this.nome = nome;
        this.email = email;
        this.idCliente = idCliente;
    }

    void mostrarCliente() {
        System.out.println("DADOS DO CLIENTE:");
        System.out.println("NOME:" + this.nome);
        System.out.println("EMAIL: " + this.email);
        System.out.println("ID: " + this.idCliente);
    }
}
