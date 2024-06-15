# Banco de Dados
Um banco de dados é uma coleção de dados relacionados. Ele tem as seguintes propriedades implícitas:
1. representa algum aspecto do mundo real, às vezes chamado de minimundo ou de universo de discurso;
2. é uma coleção logicamente coerente de dados com algum significado inerente; e
3. é projetado, montado e preenchido com dados para uma finalidade específica.

Um banco de dados pode ter qualquer tamanho e complexidade. Um exemplo de um grande banco de dados comercial é o Amazon.com. Um banco de dados pode ser gerado e mantido manualmente, ou pode ser computadorizado.

Um **sistema de gerenciamento de banco de dados (SGBD)** é um sistema computadorizado que permite que os usuários criem e mantenham um banco de dados. O SGBD é um sistema de software de uso geral que facilita o processo de definição, construção, manipulação e compartilhamento de bancos de dados entre diversos usuários e aplicações.

## Modelos de dados, esquemas e instancias
**Modelos de dados de alto nível ou conceituais** oferecem conceitos próximos ao modo como muitos usuários percebem os dados. **Os modelos de dados de baixo nível ou físicos** oferecem conceitos que descrevem os detalhes de como os dados são armazenados no computador, em geral em discos magnéticos.

Entre esses dois extremos está uma classe de **modelos de dados representativos (ou de implementação)**. 
- Oferece conceitos que podem ser facilmente entendidos pelos usuários finais, mas que não está muito longe do modo como os dados são organizados e armazenados no computador. 
- Os modelos de dados representativos ou de implementação são os usados com mais frequência nos SGBDs comerciais tradicionais.

Em um modelo de dados, é importante distinguir entre a descrição do banco de dados e o próprio banco de dados. A descrição de um banco de dados é chamada de **esquema do banco de dados**, que é especificado durante o projeto e não se espera que mude com frequência. A representação de um esquema é chamada de **diagrama de esquema**.

Chamamos cada objeto no esquema — por exemplo, ALUNO ou DISCIPLINA — de construtor do esquema. Um diagrama de esquema representa apenas alguns aspectos de um esquema, como os nomes de tipos de registro e itens de dados, e alguns tipos de restrições.

Quando definimos um novo banco de dados, especificamos seu esquema apenas para o SGBD. Nesse ponto, o estado correspondente é o estado *vazio*, sem dados. Obtemos o estado inicial do banco de dados quando ele é **populado** ou **carregado** com os dados iniciais. Daí em diante, toda vez que uma operação de atualização é aplicada ao banco
de dados, obtemos outro estado. Em qualquer ponto no tempo, o banco de dados tem um estado atual.

## Classificação dos SGBDs
Vários critérios podem ser utilizados para classificar os SGBDs. O primeiro é o modelo de dados no qual o SGBD é baseado. 

O principal modelo de dados usado atualmente em muitos SGBDs comerciais é o **modelo de dados relacional**, e os sistemas baseados nele são conhecidos como sistemas SQL. 

O **modelo de dados de objeto** foi implementado em alguns sistemas comerciais, mas não tem seu uso generalizado.

Recentemente, os chamados **sistemas big data**, também conhecidos como s**istemas de armazenamento de chave-valor** e **sistemas NOSQL**, utilizam diversos modelos de dados.

Alguns SGBDs experimentais se baseiam no modelo **XML**, que é um **modelo de dados estruturado em árvore**. Estes têm sido chamados de **SGBDs XML nativos**. Vários SGBDs relacionais comerciais acrescentaram interfaces e armazenamento XML a seus produtos.

O segundo critério usado para classificar SGBDs é o **número de usuários suportados pelo sistema**. Sistemas **monousuário** admitem apenas um usuário de cada vez. Sistemas **multiusuário**, que incluem a maioria dos SGBDs, admitem múltiplos usuários simultaneamente.

O terceiro critério é o número de locais sobre os quais o banco de dados está distribuído. 

Um SGBD é **centralizado** se os dados estiverem armazenados em um único computador. Um SGBD **distribuído** (SGBDD) pode ter o banco de dados real e o software de SGBD distribuídos por vários locais, conectados por uma rede de computadores. Os SGBDDs **homogêneos** usam o mesmo software de SGBD em todos os locais, ao passo que SGBDDs heterogêneos podem usar um software de SGBD diferente em cada local.

O quarto critério é o **custo**. Também podemos classificar um SGBD com base nas opções de tipos de caminho de acesso para armazenar arquivos. Por fim, um SGBD pode ser de uso geral ou de uso especial.

O **modelo de dados relacional básico** representa um banco de dados como uma coleção de tabelas, em que cada tabela pode ser armazenada como um arquivo separado.

O **modelo de dados de objeto** define um banco de dados em termos de objetos, suas propriedades e operações.

O **modelo de dados de chave-valo**r associa uma chave única a cada valor e fornece acesso muito rápido a um valor a partir de sua chave.

O **modelo de dados de documento** é baseado em JSON e armazena os dados como documentos.

O **modelo de dados de grafo** armazena objetos como nós de um grafo e relações entre objetos como arestas direcionadas do grafo.

Os **modelos de dados baseados em coluna** armazenam as colunas de linhas agrupadas em páginas de disco para obter acesso rápido e permitem múltiplas versões dos dados.

O **modelo hierárquico** representa os dados como estruturas hierárquicas em forma de árvore.
