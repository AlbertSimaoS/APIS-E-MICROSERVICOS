# 🏦 Escritório de Investimentos VcRiquinho — Protótipo

Este repositório contém a documentação e o protótipo do sistema do **Escritório de Investimentos VcRiquinho**, desenvolvido com base nos pilares e boas práticas da **Programação Orientada a Objetos (POO)**.

---

## 1. Estrutura de Classes (UML)

```mermaid
classDiagram
    class Conta {
        <<interface>>
        +depositar(valor: double) void
        +sacar(valor: double) void
        +getSaldo() double
        +realizarSimulacao(dias: int, taxaCDIMensal: double, cliente: Cliente) void
    }

    class ContaBancaria {
        <<abstract>>
        #saldo: double
        #numeroConta: String
        +depositar(valor: double) void
        +sacar(valor: double) void
        +getSaldo() double
        #validarPeriodoSimulacao(dias: int) void
    }

    Conta <|.. ContaBancaria

    class ContaCorrente {
        +realizarSimulacao(dias: int, taxaCDIMensal: double, cliente: Cliente)
    }

    class ContaCDI {
        +realizarSimulacao(dias: int, taxaCDIMensal: double, cliente: Cliente)
    }

    class ContaInvestimento {
        -produtos: List~ProdutoInvestimento~
        +adicionarProduto(p: ProdutoInvestimento)
        +removerProduto(p: ProdutoInvestimento)
        +realizarSimulacao(dias: int, taxaCDIMensal: double, cliente: Cliente)
    }

    ContaBancaria <|-- ContaCorrente
    ContaBancaria <|-- ContaCDI
    ContaBancaria <|-- ContaInvestimento

    class ProdutoInvestimento {
        <<abstract>>
        #nome: String
        #descricao: String
        +calcularRendimento(valor: double, dias: int) double
        +isElegivelTaxa(dias: int) boolean
    }

    class RendaFixa {
        -rendimentoMensalFixo: double
        -carenciaDias: int
        +calcularRendimento(valor: double, dias: int) double
        +isElegivelTaxa(dias: int) boolean
    }

    class RendaVariavel {
        -rendimentoMensalEsperado: double
        +calcularRendimento(valor: double, dias: int) double
        +isElegivelTaxa(dias: int) boolean
    }

    ProdutoInvestimento <|-- RendaFixa
    ProdutoInvestimento <|-- RendaVariavel

    class Cliente {
        <<abstract>>
        #nome: String
        #email: String
        #contas: List~Conta~
        +Cliente(nome: String, email: String, contaInicial: Conta)
        +adicionarConta(c: Conta)
        +getTaxaInvestimentoAutomatico() double
    }

    class PessoaFisica {
        -cpf: String
        +getTaxaInvestimentoAutomatico() double
    }

    class PessoaJuridica {
        -cnpj: String
        +getTaxaInvestimentoAutomatico() double
    }

    Cliente <|-- PessoaFisica
    Cliente <|-- PessoaJuridica

    Cliente "1" --> "1..*" Conta : possui
    ContaInvestimento "*" --> "*" ProdutoInvestimento : possui
