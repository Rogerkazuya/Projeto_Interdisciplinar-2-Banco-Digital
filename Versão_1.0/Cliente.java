public class Cliente {
    private String nome;
    private String cpf;
    private String email;

    private static int contadorCliente = 1;

    public Cliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        contadorCliente += 1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getcpf() {
        return cpf;
    }

    public void setcpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "\nNome: " + this.getNome() + "\nCPF: " + this.getcpf() + "\nE-mail: " + this.getEmail();
    }

}
