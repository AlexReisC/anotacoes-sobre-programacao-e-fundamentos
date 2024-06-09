# Padrões de Projeto
Padrões de projeto (design patterns) são soluções típicas para problemas comuns em projeto de software. Eles são como plantas de obra pré-fabricadas que você pode costumizar para resolver um problema de projeto recorrente em seu código.

O padrão não é um pedaço de código especifico para copiar, mas sim um conceito geral para resolver um problema. Os padrões são muitas vezes confundidos com algoritmos, já que ambos descrevem soluções típicas para problemas conhecidos. Mas enquanto um algoritmo descreve um conjunto de passos para atingir um resultado, um padrão é mais uma descrição de alto nível de uma solução.

## Do que consiste um padrão?
A maioria dos padrões são descritos formalmente para que as pessoas possam reproduzi-los em diferentes contextos. Aqui estão algumas seções que são geralmente presentes em uma descrição de um padrão:

- O **Propósito** do padrão descreve brevemente o problema e a solução.
- A **Motivação** explica a fundo o problema e a solução que o padrão torna possível.
- As **Estruturas** de classes mostram cada parte do padrão e como se relacionam.
- **Exemplos de código** em uma das linguagens de programação populares tornam mais fácil compreender a ideia por trás do padrão.

## Criticas dos padrões

### Gambiarras para uma linguagem de programação fraca
Geralmente quando uma linguagem ou tecnologia escolhida tem um nível fraco de abstração, os padrões se tornam gambiarras para resolver isto.

Por exemplo, o padrão **Strategy** pode ser implementado com uma simples função anônima (lambda) na maioria das linguagens de programação moderna.

### Soluções ineficientes
Os padrões tentam sistematizar abordagens que são comumente usadas. No entanto muitas pessoas os veêm como dogmas e os implementam direto ao ponto, sem adaptá-los ao contexto de seu projeto.

### Uso injustificável
Esse problema assombra muitos novatos que acabaram de conhecer os padrões. Eles tentam aplica-los a todo momento, até mesmo em situações onde um código mais simples seria mais eficiente.

## Classificação dos padrões
Padrões de projeto diferem em sua complexidade, nível de detalhes e escala de aplicabilidade ao sistema inteiro sendo desenvolvido.

Os padrões mais básicos e de baixo nível são comumente chamados *idiomáticos*. Eles geralmente se aplicam apenas à uma única linguagem de programação.

Os padrões mais universais e de alto nível são os *padrões arquitetônicos*; desenvolvedores podem implementar esses padrões em praticamente qualquer linguagem. Ao contrário de outros padrões, eles podem ser usados para fazer o projeto da arquitetura de toda uma aplicação.

Além disso, todos os padrões podem ser categorizados por seu propósito, ou intenção. Os três grupos principais de padrões:
- Os **padrões criacionais** forncecem mecanismo de criação de objetos que aumentam a flexibilidade e reutilização do código.
- Os **padrões estruturais** explicam como montar objetos e classes em estruturas maiores, enquanto ainda mantém as estruturas flexíveis e eficientes.
- Os **padrões comportamentais** cuidam da comunicação eficiente e da assinalação de responsabilidades entre objetos.

# Catálogo

## Padrões criacionais
- Factory Method
- [Builder](builder.md)
- Singleton

## Padrões estruturais
- 

## Padrões comportamentais
- 

# Referência
- [O que é um padrão de projeto?](https://refactoring.guru/pt-br/design-patterns/what-is-pattern)
