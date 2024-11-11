# SQL
SQL é a abreviação de *Structured Query Language*, ela é utilizada para acessar e manipular os dados de um banco de dados relacional.

## SELECT
Extrai dados de uma tabela e exibe os resultados. A instrução SELECT permite selecionar que colunas serão acessadas em uma tabela.
```
SELECT atributo FROM tabela
```

Exibir todas as colunas da tabela
```
SELECT * FROM tabela
```

Também é possível realizar cálculos em uma ou mais colunas e incluí-los no resultado da consulta.
```
SELECT 
atributo1, 
atributo2,
atributo2 * 1.07 AS atributo2_taxado
FROM tabela;
```
(AS, *alias*,  é usado para nomear a coluna do resultado do calculo)


# Referência
Introdução à linguagem SQL