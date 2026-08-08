package Bloco2;

public class ContaBancaria {
    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo) {
            throw new SaldoInsuficienteException(
                    "Saldo insuficiente! Saldo disponível: R$ " + saldo + " | Tentativa de saque: R$ " + valor
            );
        }
        this.saldo -= valor;
        System.out.println("Saque de R$ " + valor + " realizado com sucesso. Saldo restante: R$ " + saldo);
    }
}
