# JDBC
Java Database Connectivity é uma API que serve para realizar a conexão de programas Java com qualquer banco de dados.

Para tal é necessário o **driver JDBC** do banco pretendido (MySQL, Oracle etc..). Para funcionar esses drivers precisam estar carregados na memória e quem faz isso é a classe `java.sql.DriverManager`.

Para carregar um driver utiliza-se o método `forName(String name)` da classe `java.lang.Class`.

## Conexão

Uma conexão é representada pela interface `java.sql.Connection`. É necessário um objeto de uma classe que implemente essa interface. 

A classe `DriverManager` possuí o método `getConnection()` que é responsável por obter a conexão. Ele recebe a URL, o usuario e a senha do banco. A URL é o caminho do banco de dados e tem o formato: `jdbc:mysql://localhost:3306/seu_banco`

- `jdbc` é o protocolo
- `mysql` o sub-protocolo
- `localhost`é o endereço do servidor (IP ou nome)
- `3306` é a porta
- `seu_banco` é o nome do banco de dados

Alguns métodos da interface Connection:
- `close()`: fecha a conexão
- `createStatement()`: cria um objeto `Statement` que é usado para enviar expressões SQL para o banco. O retorno é um objeto da interface `java.sql.Statement`.
- `isClosed()`: verifica se a conexão está fechada
- `isReadOnly()`: verifica se a conexão é somente leitura
- `prepareCall(String sql)`: cria um objeto para execução de stored procedures, o objeto retornado implementa
- `getMetaData()`: busca os metadados do banco de dados. Metadados seriam basicamente a estrutura do banco, nomes de tabelas, campos, tipos, etc. Retorna um objeto da interface `java.sql.DatabaseMetaData`.
- `prepareStatement(String sql)`: Cria um objeto semelhante ao criado por `createStatement()`, porém permite trabalhar com queries parametrizadas.

## Consultas

A execução de consultas e atualizações no banco de dados gira em torno da interface `java.sql.Statement` (e sub-interfaces). Com uma instância de `Statement` já podemos executar uma query no banco. 

O método `executeQuery()` é usado para executar consultas apenas, e não deve ser usado para comandos como update, delete, create, etc. Para isso temos o método `executeUpdate()`. Já o método `execute()` é utilizado em situações em que a query pode retornar mais de um resultado (como em algumas execuções de stored procedures).

### ResultSet

O resultado da consulta está no objeto “resultado” da interface `java.sql.ResultSet`. Esse objeto possui uma série de métodos `getXXX()` usados para recuperar os dados que estão no objeto `ResultSet` de acordo com um tipo. Por exemplo, para recuperar uma coluna do tipo int use o método `getInt()`, como String `getString()`, como double `getDouble()`, e assim por diante.

Um `ResultSet` controla a posição dos registros retornados utilizando um ponteiro. Esse ponteiro aponta para uma determinada linha, chamada de current, de onde serão retirados os dados ao chamar um dos métodos get. Ao ser criado, esse ponteiro aponta para uma linha antes da primeira válida, e é necessário movê-lo para uma linha válida antes de acessar os dados, caso contrário será lançada a exceção

Para mover esse ponteiro, use um dos métodos de navegação do ResultSet:
- `absolute(int row)`: move para uma linha específica;
- `afterLast()`: move para a linha após a última, ou seja uma linha inválida;
- `beforeFirst()`: move para a linha antes da primeira, exatamente como quando o ResultSet é criado, também uma linha inválida;
- `first()`: move para a primeira linha;
- `last()`: move para a última linha;
- `next()`: move para a próxima linha;
- `previous()`: move para a linha anterior;
- `relative(int rows)`: move algumas posições, especificadas pelo parâmetro, relativamente à atual.

Por padrão, um `Statement` só permite um `ResultSet` aberto por vez. Para manter vários ResultSets abertos simultaneamente, eles devem ser criados por `Statements` diferentes.

## Alterações
Para executar alterações utilize um dos métodos `executeUpdate()` disponíveis na interface `Statement`. A forma mais simples do método `executeUpdate()` recebe uma String que é a expressão SQL a ser executada. Essa expressão não pode retornar um resultado e deve ser um `INSERT`, `UPDATE` ou `DELETE`. O retorno do método é um valor int que indica o número de linhas afetadas.

## PreparedStatement
Como as expressões SQL são tratadas como strings, para inserir um valor nela é necessário concatenar valores. Isso pode não ser muito conveniente, então podemos usar uma sub-interface de `Statement` para trabalhar com expressões parametrizadas, o `PreparedStatement`.

Um objeto `PreparedStatement` é obtido através do método `prepareStatement(String sql)` da conexão, o parâmetro que será passado é a expressão SQL e no lugar de cada parâmetro um **?**.

A partir desse objeto é possível inserir vários registros na tabela ‘amigos’ simplesmente setando os parâmetros. Não é necessário recriar o objeto para executar outra alteração, os dados dos parâmetros são retidos no objeto até que sejam substituídos por outros, ou pela chamada do método `clearParameters()`.

Há uma série de métodos `setXXX()` na interface `PreparedStatement`, e cada um recebe um tipo de parâmetro, sempre o índice do parâmetro e o valor a ser colocado nele. Deve ser definido um valor para todos os parâmetros antes de efetuar a execução, caso contrário será lançada uma exceção.

### ResultSet Atualizavel
É possível utilizar o próprio `ResultSet` para atualizar os dados na tabela. Para isso é necessário criar o `ResultSet` como atualizável passando a constante `ResultSet.CONCUR_UPDATABLE` na criação do `Statement` que dará origem ao `ResultSet`.

Enquanto o método `updateRow()` é utilizado para confirmar as alterações, o método `cancelRowUpdates()` pode ser usado para cancelá-las.

Também é possível inserir novos registros a partir do `ResultSet`. Utilizando o método `moveToInsertRow()` é possível mover-se para uma linha “em branco” do `ResultSet`, colocar dados nela e utilizar o método `insertRow()` para gravar as alterações no banco de dados.

Caso você desista de inserir o registro e queira voltar à linha normal, utilize o método `moveToCurrentRow()`.

Para excluir uma linha na tabela, pode ser usado o método `deleteRow()`.

## Store Procedures
A chamada de store procedures é possível com a interface `java.sql.CallableStatement` (sub-interface de `PreparedStatement`).

Um `CallableStatement` é criado a partir de uma conexão ativa através do método `prepareCall(String sql)`. A String passada como parâmetro tem uma sintaxe particular e padronizada, o driver é responsável por convertê-la para a sintaxe especifica do SGBD utilizado.

A sintaxe para chamar o procedimento é `{call ()}`.

Procedimentos com parâmetros de saída devem registrar esses parâmetros chamando um dos métodos `registerOutParameter()`. A forma mais simples desse método recebe dois parâmetros `int`, o primeiro é o índice do parâmetro e o segundo o tipo SQL do retorno, os tipos estão definidos por atributos estáticos da classe `java.sql.Types`.

## Referência
- [JDBC tutorial](https://www.devmedia.com.br/jdbc-tutorial/6638)
