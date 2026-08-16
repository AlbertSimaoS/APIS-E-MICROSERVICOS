Escritório de Investimentos VcRiquinho — Protótipo
1. Estrutura de Classes UML
classDiagram
    class Conta {
        <<interface>>
        +depositar(valor: double): void
        +sacar(valor: double): void
        +getSaldo(): double
        +realizarSimulacao(dias: int, taxaCDIMensal: double, cliente: Cliente): void
    }

    class ContaBancaria {
        <<abstract>>
        #saldo: double
        #numeroConta: String
        +depositar(valor: double): void
        +sacar(valor: double): void
        +getSaldo(): double
        #validarPeriodoSimulacao(dias: int): void
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
        +calcularRendimento(valor: double, dias: int): double
        +isElegivelTaxa(dias: int): boolean
    }

    class RendaFixa {
        -rendimentoMensalFixo: double
        -carenciaDias: int
        +calcularRendimento(valor: double, dias: int): double
        +isElegivelTaxa(dias: int): boolean
    }

    class RendaVariavel {
        -rendimentoMensalEsperado: double
        +calcularRendimento(valor: double, dias: int): double
        +isElegivelTaxa(dias: int): boolean
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
        +getTaxaInvestimentoAutomatico(): double
    }

    class PessoaFisica {
        -cpf: String
        +getTaxaInvestimentoAutomatico(): double
    }

    class PessoaJuridica {
        -cnpj: String
        +getTaxaInvestimentoAutomatico(): double
    }

    Cliente <|-- PessoaFisica
    Cliente <|-- PessoaJuridica

    Cliente "1" --> "1..*" Conta : possui
    ContaInvestimento "*" --> "*" ProdutoInvestimento : possui

2. Principais decisões de implementação

O projeto foi desenvolvido utilizando os fundamentos da Programação Orientada a Objetos, buscando separar responsabilidades e facilitar a manutenção do sistema.

Encapsulamento e regras do sistema
Conta obrigatória para cada cliente: o cliente precisa receber uma conta no momento de sua criação. O construtor de Cliente e de suas subclasses verifica se a conta informada é válida. Caso seja null, é lançada uma IllegalArgumentException.
Controle dos períodos de simulação: a classe ContaBancaria possui uma validação centralizada para os períodos permitidos. Dessa maneira, as subclasses podem reutilizar essa regra antes de executar suas respectivas simulações.
Proteção dos atributos: os dados internos das classes utilizam private ou protected, evitando que sejam modificados diretamente de fora das classes.
Herança, abstração e interfaces

A interface Conta estabelece os comportamentos que todas as contas devem possuir, como depositar, sacar, consultar o saldo e realizar simulações.

A classe abstrata ContaBancaria funciona como uma base para os diferentes tipos de conta. Ela concentra comportamentos que são comuns entre elas, evitando a repetição de código.

A partir dela são especializadas as classes:

ContaCorrente;
ContaCDI;
ContaInvestimento.

Da mesma forma, ProdutoInvestimento serve como classe base para os diferentes tipos de investimentos, sendo especializada em RendaFixa e RendaVariavel.

Uso de polimorfismo

O polimorfismo permite que o programa trabalhe com diferentes objetos por meio de suas classes ou interfaces mais genéricas.

Na ContaInvestimento, por exemplo, existe uma coleção de objetos do tipo ProdutoInvestimento. Cada investimento pode executar sua própria versão de calcularRendimento() e isElegivelTaxa(), de acordo com seu tipo.

Assim, uma RendaFixa pode verificar sua condição de carência, enquanto uma RendaVariavel pode utilizar uma regra diferente, sem que a classe responsável pela simulação precise identificar manualmente o tipo de cada objeto.

O mesmo conceito é utilizado com as contas dos clientes. A coleção utiliza referências do tipo Conta, mas cada objeto executa o comportamento específico de sua implementação, seja uma conta corrente, CDI ou investimento.

Protótipo em memória e operações CRUD

Para demonstrar o funcionamento do sistema sem depender de um banco de dados, o protótipo utiliza coleções em memória para armazenar os objetos.

A classe Main demonstra as principais operações de um CRUD:

Create: criação e inclusão de clientes, contas e produtos;
Read: consulta e exibição das informações armazenadas;
Update: alteração dos dados e estados dos objetos;
Delete: remoção de elementos das coleções.

Também é considerada a relação entre os investimentos e as contas dos clientes. Dessa forma, quando um produto de investimento é removido do sistema, sua associação com as contas que o utilizavam também deve ser atualizada.
