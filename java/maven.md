# Apache Maven
Maven é um ferramenta de gerenciamento de projetos utilizada principalmente me projetos Java. Segundo a definição da documentação oficial do Maven:<br>
*O Maven é uma tentativa de aplicar padrões à infraestrutura de construção de um projeto, a fim de promover a compreensão e a produtividade, fornecendo um caminho claro para a utilização das melhroes práticas.*

Quando criamos um projeto Maven, ele é atrelado a um arquivo `pom.xml`. Neste arquivo, nós descrevemos as dependências de nosso projeto e a maneira como este deve ser compilado. Com o Maven, é possível, por exemplo, automatizar a execução de testes unitários durante a fase de build, entre outras automatizações.

Com o Maven não temos mais a necessidade de baixarmos as dependências de nosso projeto e as configurar dentro do Build Path/Classpath de nossas aplicações.

## O que são Maven Archetypes?
Podemos criar nossos projetos Java usando o Maven, esses projetos são criados a partir de templates base que são chamados de archetypes (arquétipos), isso torna o processo mais fácil.

## Criando nosso primeiro projeto com o Maven
Com o terminal aberto na pasta onde deseja criar o projeto vamos executar o comando `mvn archetype:generate`, após a execução desse comando será exibido no terminal a lista de arquétipos disponíveis para a criação do projeto.

Você deve escolher o número correspondente ao arquétipo que deseja utilizar. Caso não coloque nenhuma opção de arquétipo o maven irá utilizar por padrão o maven-archetype-quickstart.

Em seguida é necessário escolher qual a versão do arquétipo. Após a escolha da versão o Maven irá perguntar quais os valores para a propriedades groupId, artifactId, version e package.

- **groupId**: O nome da organização ao qual pertence esse projeto, possui o mesmo padrão de nomenclatura de pacotes
- **artifcatId**: O nome do projeto
- **version**: A versão do nosso projeto, caso não seja colocado nenhum valor o Maven irá utilizar o valor padrão que é 1.0-SNAPSHOT
- **package**: O nome do pacote principal do nosso projeto, é boa pratica colocar a junção do groupId com o artifactId, caso não seja passado nenhum valor, o Maven irá assumir o mesmo valor colocado no groupId

Após colocar todos os valores basta confirma-los com o “Y”.

## Estrutura das pastas do nosso projeto
Após a execução do comando para a criação do projeto foi criada uma pasta com o mesmo nome informado para o artifactId e dentro desta pasta foi criada uma estrutura de pastas para a organização do nosso projeto, dependendo de qual arquétipo você escolheu essa estrutura de pastas pode ser diferente. Exemplo:

```console
projeto-teste
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── br
    │           └── com
    │               └── exemplo
    │                   └── projetoteste
    │                       └── App.java
    └── test
        └── java
            └── br
                └── com
                    └── exemplo
                        └── projetoteste
                            └── AppTest.java
```

Dentro da pasta do nosso projeto temos o arquivo `pom.xml` que contém as informações sobre o projeto e quais as suas dependências, também temos as pastas `src` que contém a pasta `main` que irá guardar o código fonte de nosso projeto e a pasta `test` que irá conter os códigos fontes para os testes automatizados. Dentro de cada uma destas pastas terá uma estrutura de pastas de acordo com o nome definido no package.

Além das pastas já criadas pelo Maven existe uma outra pasta que será criada sempre que executar o comando para que nosso projeto seja compilado, após a execução do comando mvn compile uma nova pasta será criada, a pasta `target`, essa pasta irá conter os arquivos `.class` do nosso projeto.

## Gerenciamento de dependências
Para gerenciar as dependências do nosso projeto utilizamos o arquivo pom.xml.

O Maven irá buscar por essas dependências em locais chamados de repositórios, existem basicamente dois repositórios, o repositório local que está localizado na pasta .m2/repository e o repositório remoto que está localizado no repositório público do Maven.

Ao adicionar uma nova dependência em nosso projeto, o Maven primeiro realiza a busca em nosso repositório local, caso não encontre irá buscar no repositório remoto e então fazer o download da biblioteca e disponibiliza-la no repositório local, dessa maneira caso você necessite utilizar a mesma biblioteca em outro projeto não será necessário realizar o download novamente.

## Entendendo o pm=om.xml
Exemplo de `pom.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>br.com.treinaweb</groupId>
  <artifactId>treinaweb-maven</artifactId>
  <version>1.0-SNAPSHOT</version>

  <name>treinaweb-maven</name>
  <!-- FIXME change it to the project's website -->
  <url>http://www.example.com</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.7</maven.compiler.source>
    <maven.compiler.target>1.7</maven.compiler.target>
  </properties>

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <build>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
        <!-- clean lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#clean_Lifecycle -->
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.1.0</version>
        </plugin>
        <!-- default lifecycle, jar packaging: see https://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_jar_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.22.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-jar-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
        <!-- site lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#site_Lifecycle -->
        <plugin>
          <artifactId>maven-site-plugin</artifactId>
          <version>3.7.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-project-info-reports-plugin</artifactId>
          <version>3.0.0</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
</project>
```

Podemos dividir o arquivo `pom.xml` em quatro partes, a primeira possui as coordenadas do projeto, ou seja, os dados que identificam o projeto, como groupid, artifactId e version.

```xml
<groupId>br.com.treinaweb</groupId>
<artifactId>treinaweb-maven</artifactId>
<version>1.0-SNAPSHOT</version>
```

A segunda parte são as propriedades do projeto, essa parte contém informações de encondig e também a versão do Java que estamos utilizando.

```xml
<properties>
  <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  <maven.compiler.source>1.7</maven.compiler.source>
  <maven.compiler.target>1.7</maven.compiler.target>
</properties>
```

A terceira parte é onde definimos as dependencias de nosso projeto.
```xml
<dependencies>
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.11</version>
    <scope>test</scope>
  </dependency>
</dependencies>
```

E por último temos as informações de build que dizem como o projeto deve ser compilado pelo Maven, nessa parte também estão descritas quais plugins do Maven o nosso projeto necessita para ser compilado.

```xml
<build>
  <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
    <plugins>
      <!-- clean lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#clean_Lifecycle -->
      <plugin>
        <artifactId>maven-clean-plugin</artifactId>
        <version>3.1.0</version>
      </plugin>
      <!-- default lifecycle, jar packaging: see https://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_jar_packaging -->
      <plugin>
        <artifactId>maven-resources-plugin</artifactId>
        <version>3.0.2</version>
      </plugin>
      <plugin>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.0</version>
      </plugin>
      <plugin>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.22.1</version>
      </plugin>
      <plugin>
        <artifactId>maven-jar-plugin</artifactId>
        <version>3.0.2</version>
      </plugin>
      <plugin>
        <artifactId>maven-install-plugin</artifactId>
        <version>2.5.2</version>
      </plugin>
      <plugin>
        <artifactId>maven-deploy-plugin</artifactId>
        <version>2.8.2</version>
      </plugin>
      <!-- site lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#site_Lifecycle -->
      <plugin>
        <artifactId>maven-site-plugin</artifactId>
        <version>3.7.1</version>
      </plugin>
      <plugin>
        <artifactId>maven-project-info-reports-plugin</artifactId>
        <version>3.0.0</version>
      </plugin>
    </plugins>
  </pluginManagement>
</build>
```

## Adicionando dependências em nosso projeto
Para adicionarmos uma nova dependência em nosso projeto basta que no arquivo pom.xmldentro da tag `dependencies` adicionemos uma nova tag `dependency` com as informações de groupId, artifactId e version da biblioteca que queremos adicionar como dependência.

## Referência
- [Introdução ao Maven](https://www.treinaweb.com.br/blog/introducao-ao-maven-aprenda-como-criar-e-gerenciar-projetos-java#google_vignette)