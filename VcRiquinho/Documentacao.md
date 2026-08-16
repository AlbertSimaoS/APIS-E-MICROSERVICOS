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
```

## 2. Principais Decisões de Implementação

O projeto foi desenvolvido com base nos princípios da **Programação Orientada a Objetos (POO)**, buscando organizar as responsabilidades entre as classes, reduzir a duplicação de código e facilitar futuras alterações no sistema.

### Encapsulamento e Regras de Negócio

- **Conta obrigatória para cada cliente:** todo cliente deve possuir uma conta no momento de sua criação. O construtor de `Cliente` e de suas subclasses valida a conta informada. Caso o valor seja `null`, uma `IllegalArgumentException` é lançada.

- **Validação dos períodos de simulação:** a classe `ContaBancaria` centraliza a validação dos períodos permitidos para as simulações. As classes especializadas reutilizam essa regra antes de realizar seus cálculos.

- **Proteção dos atributos:** os atributos das classes possuem modificadores `private` ou `protected`, evitando alterações diretas e garantindo maior controle sobre o estado dos objetos.

### Herança, Abstração e Interfaces

A interface `Conta` define os comportamentos básicos que devem estar disponíveis em todas as contas:

```text
depositar(valor)
sacar(valor)
getSaldo()
realizarSimulacao(...)
