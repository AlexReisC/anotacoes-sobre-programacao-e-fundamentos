# Relacionamentos entre classes em Orientação a Objetos

## Relacionamento do tipo "É-UM"

Um relacionamento "É-UM" refere-se a herança, onde uma classe herda atributos e métodos de outra classe. Na UML, a herança é representada por uma linha sólida com uma seta apontando para a superclasse.

## Relacionamento do tipo "TEM-UM"

Uma instância de uma classe TEM UMA referência a uma instância de outra classe.

### Associação

É um relacionamento fraco entre duas classes, onde uma classe interaja com outra, mas ambas podem existir de forma independente. Na UML, a associação é representada por uma linha simples entre as classes. Na UML, a associação é representada por uma linha sólida.

### Agregação

Tipo de associação em que uma classe contém ou agrega outra classe como parte de sua estrutura. As classes são independentes. Por exemplo, uma classe `Student` e uma classe `ContactInfo`. `Student` (aluno) TEM-UM `ContactInfo` (informações de contato), `ContactInfo` pode ser usada em outros lugares. `Student` pode existir sem `ContactInfo` e vice-versa.<br>Na UML, a agregação é representada por uma linha sólida com um losango oco no final da linha que aponta para a classe que é parte da agregação.

### Composição

Neste relacionamento, uma classe é composta por outra classe. A classe composta não pode existir sem a classe que a compõe. Por exemplo, a classe `Student` e a classe `StudentId`. `StudentId` não pode existir sem `Student`.<br>Na UML, a composição é representada por uma linha sólida com um losango preenchido no final da linha que aponta para a classe que é parte da composição.

## Referências

- [Principios de Programação Orientada a Objetos em Java: Conceitos de POO para iniciantes](https://www.freecodecamp.org/portuguese/news/principios-de-programacao-orientada-a-objetos-em-java-conceitos-de-poo-para-iniciantes/#:~:text=heran%C3%A7a%20no%20Java-,Relacionamentos,-I.%20Relacionamento)