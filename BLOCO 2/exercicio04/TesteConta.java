package Bloco2;

public class TesteConta {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(100.0);

        System.out.println("--- Teste 1: Saque Válido ---");
        try {
            conta.sacar(40.0);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\n--- Teste 2: Saque com Saldo Insuficiente ---");
        try {
            conta.sacar(500.0);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Exceção capturada com sucesso!");
            System.out.println("Mensagem de erro: " + e.getMessage());
        }
    }
}
