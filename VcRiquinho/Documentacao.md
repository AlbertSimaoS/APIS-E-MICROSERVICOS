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

2. Principais Decisões de Implementação
O projeto foi desenvolvido utilizando os fundamentos da Programação Orientada a Objetos, buscando separar responsabilidades e facilitar a manutenção e escalabilidade do sistema.

🔒 Encapsulamento e Regras do Sistema
Conta obrigatória para cada cliente: O cliente precisa receber uma conta no momento de sua criação. O construtor de Cliente e de suas subclasses verifica se a conta informada é válida. Caso seja null, é lançada uma IllegalArgumentException.

Controle dos períodos de simulação: A classe ContaBancaria possui uma validação centralizada para os períodos permitidos. Dessa maneira, as subclasses podem reutilizar essa regra antes de executar suas respectivas simulações.

Proteção dos atributos: Os dados internos das classes utilizam visibilidade private ou protected, evitando que sejam modificados diretamente de fora da hierarquia das classes.

🧱 Herança, Abstração e Interfaces
A interface Conta estabelece o contrato com os comportamentos que todas as contas devem possuir:

depositar(valor)

sacar(valor)

getSaldo()

realizarSimulacao(...)

A classe abstrata ContaBancaria funciona como uma base para os diferentes tipos de conta, concentrando comportamentos comuns para evitar duplicação de código.

A partir de ContaBancaria, são especializadas as classes:

ContaCorrente

ContaCDI

ContaInvestimento

Da mesma forma, ProdutoInvestimento serve como classe base abstrata para os diferentes produtos financeiros, sendo especializada em RendaFixa e RendaVariavel.

🎭 Uso de Polimorfismo
O polimorfismo permite que o programa trabalhe com diferentes objetos por meio de suas abstrações mais genéricas (interfaces ou classes pai):

Na ContaInvestimento, existe uma coleção de objetos do tipo ProdutoInvestimento. Cada investimento executa sua própria implementação dos métodos calcularRendimento() e isElegivelTaxa().

Uma RendaFixa valida suas condições de carência.

Uma RendaVariavel utiliza sua própria regra de projeção de mercado.

Tudo isso ocorre sem que a classe responsável pela simulação precise identificar manualmente o tipo concreto de cada objeto.

O mesmo conceito se aplica às contas dos clientes: a lista armazena referências do tipo Conta, mas cada objeto executa o comportamento específico de sua implementação (ContaCorrente, ContaCDI ou ContaInvestimento).

💾 Protótipo em Memória e Operações CRUD
Para demonstrar o funcionamento do sistema sem depender de um banco de dados relacional, o protótipo utiliza coleções em memória (List, Set, etc.) para armazenar os objetos.

A classe Main demonstra o ciclo completo de vida dos dados (CRUD):

Create: Criação e inclusão de clientes, contas e produtos de investimento;

Read: Consulta e exibição detalhada das informações armazenadas;

Update: Alteração dos dados cadastrais e estados dos objetos;

Delete: Remoção de elementos das coleções.

⚠️ Integridade Referencial: O sistema considera o relacionamento entre os investimentos e as contas. Quando um produto de investimento é removido do sistema, sua associação com as contas que o utilizavam também é atualizada de forma consistente.
