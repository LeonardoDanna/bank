import java.util.Scanner;

public class Desafio {
    static double saldo = 0;

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        String nomeCliente = "DUDU";
        String tipoConta = "Corrente";
        int opcao = 0;
        double valor = 0;

        entrada(nomeCliente, tipoConta);

        // Loop que mantém o programa rodando até o usuário escolher a opção 4
        while (opcao != 4) {
            operacoes();

            System.out.println("Digite a opção desejada:");
            opcao = leitura.nextInt();

            escolha(opcao,valor);
        }
    }

    private static void operacoes() {
        String menu = """
                Operações:
               
                1 - Consultar saldos
                2 - Receber valor
                3 - Transferir valor
                4 - Sair
               
               """;
        System.out.println(menu);
    }

    private static void escolha(int opcao, double valor) {
        switch (opcao) {
            case 1:
                System.out.println("O saldo atual é de R$" + saldo);
                break;

            case 2:
                System.out.println("Informe o valor a receber: ");

                Scanner valorAReceber = new Scanner(System.in);
                valor = valorAReceber.nextDouble();

                saldo += valor;

                System.out.println("Saldo atualizado: R$" + saldo);
                break;
            case 3:
                System.out.println("Informe o valor a transferir: : ");

                Scanner valorAPerder = new Scanner(System.in);
                valor = valorAPerder.nextDouble();

                if (valor > saldo) {
                    System.out.println("Não há saldo suficiente para fazer a transferência.\n");
                } else {
                    saldo -= valor;
                    System.out.println("Saldo atualizado: R$" + saldo);
                }
                break;
            case 4:
                System.out.println("Até breve!");
                break;
            default:
                System.out.println("Opção inválida. Escolha entre 1, 2, 3 ou 4.\n");
        }
    }

    private static void entrada(String nomeCliente, String tipoConta) {
        System.out.println("-------------------------------------");
        System.out.println("\nDados iniciais do cliente:");
        System.out.println();
        System.out.println("Nome: " + nomeCliente);
        System.out.println("Tipo conta: " + tipoConta);
        System.out.println("Saldo Inicial: " + saldo);
        System.out.println("\n-------------------------------------");
        System.out.println();
    }
}