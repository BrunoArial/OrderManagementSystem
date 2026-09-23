# Order Management System

Sistema de gerenciamento de pedidos desenvolvido em **Java** como projeto prático para consolidar fundamentos da linguagem, orientação a objetos, regras de negócio, tratamento de exceções, gerenciamento de dependências com Maven e testes automatizados com JUnit.

O projeto funciona inteiramente pelo terminal e foi desenvolvido sem frameworks de aplicação, mantendo o foco na compreensão dos principais recursos da linguagem Java antes da evolução para tecnologias como Spring Boot e APIs REST.

---

## Objetivo do projeto

Este projeto representa a conclusão de uma etapa de estudos voltada aos fundamentos de Java.

O objetivo foi construir uma aplicação completa de terminal aplicando os conceitos estudados em conjunto, em vez de praticá-los apenas de forma isolada.

A partir desta base, os próximos estudos serão direcionados ao desenvolvimento Back-End com Java, incluindo HTTP, APIs REST, Spring Boot, persistência de dados e bancos de dados relacionais.
---

## Funcionalidades

O sistema permite:

- Criar um pedido associado a um cliente;
- Adicionar produtos ao pedido;
- Remover produtos do pedido;
- Consultar os dados do pedido;
- Calcular subtotais e o valor total;
- Controlar automaticamente o estoque dos produtos;
- Confirmar pedidos;
- Cancelar pedidos;
- Restaurar o estoque ao remover itens ou cancelar pedidos;
- Registrar data e horário de criação do pedido;
- Interagir com o sistema através de um menu no terminal;
- Tratar entradas inválidas e violações das regras de negócio.

---

## Regras de negócio

O projeto implementa regras como:

- Apenas pedidos com status `PENDENTE` podem receber novos itens;
- Apenas pedidos `PENDENTE` permitem remoção de itens;
- A quantidade adicionada deve ser maior que zero;
- Não é possível adicionar uma quantidade maior que o estoque disponível;
- Ao adicionar um item ao pedido, seu estoque é reduzido automaticamente;
- Ao remover um item, sua quantidade é devolvida ao estoque;
- Um pedido vazio não pode ser confirmado;
- Apenas pedidos `PENDENTE` podem ser confirmados;
- Ao cancelar um pedido, os produtos são devolvidos ao estoque;
- Um pedido já cancelado não pode ser cancelado novamente.

Os pedidos utilizam os seguintes estados:

```text
PENDENTE
CONFIRMADO
CANCELADO
```

---

## Estrutura do domínio

O sistema foi dividido em classes com responsabilidades específicas.

### `Cliente`

Representa o cliente responsável pelo pedido.

Possui:

- Nome;
- E-mail;
- Identificador.

### `Produto`

Representa um produto disponível para compra.

Responsável por armazenar:

- ID;
- Nome;
- Preço;
- Estoque.

Também concentra as regras de aumento e redução de estoque.

### `ItemPedido`

Representa um produto dentro de um pedido.

Relaciona:

```text
Produto + Quantidade
```

e calcula seu próprio subtotal:

```text
preço × quantidade
```

### `Pedido`

É responsável pelo gerenciamento do pedido e de suas principais regras de negócio.

Mantém:

- Cliente;
- Lista de itens;
- ID do pedido;
- Status;
- Data e horário.

Também realiza operações como:

- Adicionar itens;
- Remover itens;
- Calcular o valor total;
- Confirmar o pedido;
- Cancelar o pedido;
- Restaurar estoque quando necessário.

### `StatusPedido`

Enum utilizado para representar o estado atual do pedido:

```java
PENDENTE,
CONFIRMADO,
CANCELADO
```

---

## Estrutura do projeto

```text
OrderManagementSystem
│
├── pom.xml
├── README.MD
│
└── src
    ├── main
    │   └── java
    │       ├── Cliente.java
    │       ├── ItemPedido.java
    │       ├── Main.java
    │       ├── Pedido.java
    │       ├── Produto.java
    │       └── StatusPedido.java
    │
    └── test
        └── java
            ├── PedidoTest.java
            └── ProdutoTest.java
```

A estrutura segue o padrão utilizado pelo Maven:

```text
src/main/java
```

para o código da aplicação e:

```text
src/test/java
```

para os testes automatizados.

---

## Tecnologias utilizadas

- Java 25
- Maven
- JUnit 5
- Maven Surefire Plugin
- Git
- GitHub

---

## Conceitos praticados

Durante o desenvolvimento foram aplicados conceitos como:

- Programação Orientada a Objetos;
- Classes e objetos;
- Construtores;
- Encapsulamento;
- Composição entre objetos;
- Collections com `ArrayList`;
- Arrays;
- Enums;
- Tratamento de exceções;
- `IllegalArgumentException`;
- `IllegalStateException`;
- `InputMismatchException`;
- `BigDecimal` para valores monetários;
- `LocalDateTime`;
- `DateTimeFormatter`;
- Estruturas de repetição;
- Estruturas condicionais;
- Entrada de dados com `Scanner`;
- Separação de responsabilidades entre classes;
- Gerenciamento de dependências com Maven;
- Testes automatizados com JUnit;
- Assertions com `assertEquals`;
- Testes de exceções com `assertThrows`.

---

## Testes automatizados

O projeto possui testes automatizados utilizando **JUnit 5**.

Atualmente são testados comportamentos de `Produto` e `Pedido`.

### Produto

Os testes verificam:

- Redução correta do estoque;
- Bloqueio de quantidade maior que o estoque disponível;
- Bloqueio de quantidade igual a zero.

### Pedido

Os testes verificam:

- Redução de estoque ao adicionar um item;
- Restauração de estoque ao remover um item;
- Confirmação de pedido pendente com itens;
- Bloqueio da confirmação de pedidos vazios;
- Restauração do estoque ao cancelar um pedido;
- Alteração do status para `CANCELADO`.

Atualmente o projeto possui **8 testes automatizados**.

Para executar todos os testes:

```bash
mvn test
```

---

## Como executar

### Pré-requisitos

É necessário ter instalado:

- JDK 25;
- Apache Maven;
- Git.

Clone o repositório:

```bash
git clone https://github.com/BrunoArial/OrderManagementSystem.git
```

Entre na pasta:

```bash
cd OrderManagementSystem
```

Compile o projeto:

```bash
mvn compile
```

Execute a aplicação:

```bash
java -cp target/classes Main
```

---

## Build

Para executar os testes e gerar o pacote do projeto:

```bash
mvn package
```

O Maven executará o processo de compilação, os testes automatizados e criará o artefato do projeto dentro da pasta:

```text
target/
```

---

## Fluxo básico da aplicação

```text
Cliente
   │
   ▼
Pedido (PENDENTE)
   │
   ├── ItemPedido ──► Produto
   │
   ├── ItemPedido ──► Produto
   │
   ▼
Valor Total
   │
   ├── CONFIRMADO
   │
   └── CANCELADO
```

Ao adicionar produtos, o estoque é atualizado automaticamente. Enquanto o pedido estiver pendente, itens ainda podem ser adicionados ou removidos.

Quando confirmado, o pedido deixa de aceitar alterações.

Quando cancelado, as quantidades dos produtos presentes no pedido são devolvidas ao estoque.