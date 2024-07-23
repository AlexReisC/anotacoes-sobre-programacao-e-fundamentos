# JDBC
Java Database Connectivity é uma API que serve para realizar a conexão de programas Java com qualquer banco de dados.

Para tal é necessário o **driver JDBC** do banco pretendido (MySQL, Oracle etc..). Para funcionar esses drivers precisam estar carregados na memória. Quem faz isso é a classe `java.sql.DriverManager`.

Para carregar um driver utiliza-se o método `forName` da classe `java.lang.Class`.

Uma conexão é representada pela interface `java.sql.Connection`. 