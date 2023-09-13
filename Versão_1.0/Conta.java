import Utilitarios.Utils;

public class Conta {
    private static int contadorDeContas = 1;

    private int numConta;
    private Cliente cliente;
    private double saldo = 0.0;

    public Conta(Cliente cliente) {
        this.numConta = contadorDeContas;
        this.cliente = cliente;
        contadorDeContas += 1;

    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String toString() {
        return "\nNúmero da Conta: " + this.getNumConta() +
                "\nNome: " + this.cliente.getNome() +
                "\nCPF: " + this.cliente.getcpf() +
                "\nE-mail: " + this.cliente.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n";

    }

    public void depositar(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Deposito realizado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar o deposito!");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar o saque!");
        }
    }

    public void transferir(Conta contaParaDeposito, double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Não foi possível realizar a transferência!");
        }

    }

}
