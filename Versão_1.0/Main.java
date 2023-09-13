import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();

    }

    public static void operacoes() {
        System.out.println("------------------------------------------------------");
        System.out.println("-----------------Seja Muito Bem Vindo-----------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|    Opção 1 -  Criar Conta    |");
        System.out.println("|    Opção 2 -  Depositar      |");
        System.out.println("|    Opção 3 -  Sacar          |");
        System.out.println("|    Opção 4 -  Transferir     |");
        System.out.println("|    Opção 5 -  Listar         |");
        System.out.println("|    Opção 6 -  Sair           |");

        int op = entrada.nextInt();

        switch (op) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listar();
                break;
            case 6:
                System.out.println("Obrigado por usar nossos serviços!");
                System.exit(0);

            default:
                System.out.println("Opão Inválida!");
                operacoes();
                break;

        }

    }

    public static void criarConta() {

        System.out.println("Nome: ");
        String nome = entrada.next();

        System.out.println("\nCPF: ");
        String cpf = entrada.next();

        System.out.println("\nE-mail: ");
        String email = entrada.next();

        Cliente c = new Cliente(nome, cpf, email);
        Conta conta = new Conta(c);

        contasBancarias.add(conta);

        System.out.println("Sua conta foi criada com sucesso!");

        operacoes();
    }

    private static Conta encontrarConta(int numConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                if (c.getNumConta() == numConta)
                    ;
                conta = c;
            }

        }
        return conta;
    }

    public static void depositar() {
        System.out.println("\nNúmero da conta: ");
        int numConta = entrada.nextInt();

        Conta conta = encontrarConta(numConta);

        if (conta != null) {
            System.out.println("\nQual valor quer depositar?");
            double valorDeposito = entrada.nextDouble();
            conta.depositar(valorDeposito);
        } else {
            System.out.println("A conta não foi encontrada");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("\nNúmero da conta: ");
        int numConta = entrada.nextInt();

        Conta conta = encontrarConta(numConta);

        if (conta != null) {
            System.out.println("\nQual valor quer sacar?");
            double valorSaque = entrada.nextDouble();
            conta.sacar(valorSaque);
        } else {
            System.out.println("A conta não foi encontrada");
        }
        operacoes();

    }

    public static void transferir() {
        System.out.println("\nNúmero da conta do Remetente: ");
        int numConta = entrada.nextInt();

        Conta contaRementente = encontrarConta(numConta);

        if (contaRementente != null) {
            System.out.println("Para qual conta deseja transferir? ");
            int numContaDestinatario = entrada.nextInt();

            Conta contaDestinatario = encontrarConta(numContaDestinatario);

            if (contaDestinatario != null) {
                System.out.println("Qual o valor da trasnferência? ");
                double valor = entrada.nextDouble();
                contaRementente.transferir(contaDestinatario, valor);
            }
        }

        operacoes();
    }

    public static void listar() {

        if (contasBancarias.size() > 0) {
            for (Conta conta : contasBancarias) {
                System.out.println(conta);
            }
        } else {
            System.out.println("Não há contas cadastrada!");
        }
    }

}